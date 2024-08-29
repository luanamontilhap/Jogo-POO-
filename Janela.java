import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Janela extends JFrame {

    public Janela() {
        setTitle("Bem-vindo ao Jogo");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 1));

        JButton btnJogar = new JButton("Jogar");
        btnJogar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirJanelaSelecaoHeroi();
            }
        });

        JButton btnDebug = new JButton("DEBUG");
        btnDebug.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirJanelaDebug();
            }
        });

        JButton btnSair = new JButton("Sair");
        btnSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        add(btnJogar);
        add(btnDebug);
        add(btnSair);

        setVisible(true);
    }

    private void abrirJanelaSelecaoHeroi() {
        JFrame selecaoHeroi = new JFrame("Seleção de Herói");
        selecaoHeroi.setSize(400, 200);
        selecaoHeroi.setLayout(new GridLayout(4, 1));
        selecaoHeroi.setLocationRelativeTo(null);

        JButton btnBarbaro = new JButton("Bárbaro");
        btnBarbaro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                distribuirPontos(new Barbaro());
                selecaoHeroi.dispose();
            }
        });

        JButton btnPalatino = new JButton("Paladino");
        btnPalatino.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                distribuirPontos(new Palatino());
                selecaoHeroi.dispose();
            }
        });

        JButton btnGuerreiro = new JButton("Guerreiro");
        btnGuerreiro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                distribuirPontos(new Guerreiro());
                selecaoHeroi.dispose();
            }
        });

        selecaoHeroi.add(btnBarbaro);
        selecaoHeroi.add(btnPalatino);
        selecaoHeroi.add(btnGuerreiro);

        selecaoHeroi.setVisible(true);
    }

    private void distribuirPontos(Heroi heroi) {

            int ataque = Integer.parseInt(JOptionPane.showInputDialog("Atribua os pontos de Ataque:"));
            int defesa = Integer.parseInt(JOptionPane.showInputDialog("Atribua os pontos de Defesa:"));
            int saude = Integer.parseInt(JOptionPane.showInputDialog("Atribua os pontos de Saúde:"));

            // Ajuste com base na classe do herói
            if (heroi instanceof Barbaro) {
                heroi.setAtaque((int) (ataque * 1.5)); // 50% a mais de ataque
            } else {
                heroi.setAtaque(ataque);
            }

            if (heroi instanceof Guerreiro) {
                heroi.setDefesa((int) (defesa * 1.5)); // 50% a mais de defesa
            } else {
                heroi.setDefesa(defesa);
            }

            if (heroi instanceof Palatino) {
                heroi.setSaude((int) (saude * 1.5)); // 50% a mais de saúde
            } else {
                heroi.setSaude(saude);
            }

        Chefao chefao = new Chefao( 60, 50, 80);  // Criação do chefão
        new Tabuleiro(5, 10, heroi, chefao);

        }



    private void abrirJanelaDebug() {
        Heroi debugHeroi = new Barbaro();
        // A lógica para o modo de depuração vai aqui
    }

    public static void main(String[] args) {
        new Janela();
    }
}



