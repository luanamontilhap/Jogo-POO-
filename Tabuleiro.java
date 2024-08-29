import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tabuleiro extends JFrame {
    private int linhas;
    private int colunas;
    private JButton[][] celulas;
    private String[][] conteudoCelas;
    private Heroi heroi;
    private Monstro monstro;
    private Chefao chefao; // Adicionado para o chefão
    private JLabel lblVidaHeroi;
    private JLabel lblDicas;
    private int personagemLinha;
    private int personagemColuna;

    public Tabuleiro(int linhas, int colunas, Heroi heroi, Monstro monstro) {
        this.linhas = linhas;
        this.colunas = colunas;
        this.heroi = heroi;
        this.monstro = monstro;
        this.celulas = new JButton[linhas][colunas];
        this.conteudoCelas = new String[linhas][colunas];

        setTitle("Tabuleiro com Botões");
        setSize(800, 500);
        setLayout(new BorderLayout());

        JPanel panelTabuleiro = new JPanel(new GridLayout(linhas, colunas));
        add(panelTabuleiro, BorderLayout.CENTER);

        JPanel panelInfo = new JPanel();
        lblVidaHeroi = new JLabel("Vida: " + heroi.getSaude());
        lblDicas = new JLabel("Dicas: x+y = 5; z*v = 28; b-a = 3 ");
        panelInfo.add(lblVidaHeroi);
        panelInfo.add(lblDicas);
        add(panelInfo, BorderLayout.SOUTH);

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                celulas[i][j] = new JButton();
                celulas[i][j].setBackground((i + j) % 2 == 0 ? new Color(75, 0, 130) : new Color(139, 0, 0));
                panelTabuleiro.add(celulas[i][j]);

                final int x = i;
                final int y = j;
                celulas[i][j].addActionListener(e -> {
                    try {
                        moverPersonagem(x, y);
                    } catch (MovimentoInvalidoException ex) {
                        JOptionPane.showMessageDialog(this, ex.getMessage());
                    }
                });

                conteudoCelas[i][j] = "Nada"; // Inicializa todas as células como vazias
            }
        }

        personagemLinha = 0;
        personagemColuna = 0;
        celulas[personagemLinha][personagemColuna].setText("H");

        posicionarElementos();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void posicionarElementos() {
        adicionarArmadilha(2, 3);
        adicionarArmadilha(4, 7);
        adicionarArmadilha(4, 1);
        adicionarMonstro(3, 5, "Chefinho");
        adicionarMonstro(4, 8, "Chefinho");

        int ultimaLinha = linhas - 1;
        int ultimaColuna = colunas - 1;
        conteudoCelas[ultimaLinha][ultimaColuna] = "Chefão";
        celulas[ultimaLinha][ultimaColuna].setText("C");
    }

    private void adicionarArmadilha(int linha, int coluna) {
        conteudoCelas[linha][coluna] = "Armadilha";
    }

    private void adicionarMonstro(int linha, int coluna, String tipo) {
        conteudoCelas[linha][coluna] = tipo;
    }

    public void moverPersonagem(int novaLinha, int novaColuna) throws MovimentoInvalidoException {
        celulas[personagemLinha][personagemColuna].setText("");

        personagemLinha = novaLinha;
        personagemColuna = novaColuna;
        celulas[personagemLinha][personagemColuna].setText("H");

        String conteudo = conteudoCelas[novaLinha][novaColuna];

        if (conteudo.equals("Armadilha")) {
            acionarArmadilha(heroi);
        } else if (conteudo.equals("Chefinho")) {
            monstro = new Monstro(30, 10, 50);
            Batalha batalha = new Batalha(heroi, monstro);
            batalha.iniciarBatalha();
        } else if (conteudo.equals("Chefão")) {
            Chefao chefao = new Chefao( 50, 50, 50);
            Batalha batalha = new Batalha(heroi, chefao);
            batalha.iniciarBatalha();
        }

        lblVidaHeroi.setText("Vida: " + heroi.getSaude());

        if (heroi.getSaude() <= 0) {
            JOptionPane.showMessageDialog(this, "Você morreu!");
            System.exit(0);
        }
    }
    public void acionarArmadilha(Heroi heroi) {
        int danoArmadilha = 10;
        heroi.setSaude(heroi.getSaude() - danoArmadilha);
        JOptionPane.showMessageDialog(null, "Você caiu em uma armadilha e perdeu " + danoArmadilha + " de vida!");
    }

    public boolean isChefao(int linha, int coluna) {
        return conteudoCelas[linha][coluna].equals("Chefão");
    }
}





















