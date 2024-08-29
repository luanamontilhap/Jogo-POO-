import javax.swing.JOptionPane;

public class Batalha {
    private Heroi heroi;
    private Monstro monstro;

    public Batalha(Heroi heroi, Monstro monstro) {
        if (heroi == null) {
            throw new IllegalArgumentException("Herói não pode ser nulo.");
        }
        if (monstro == null) {
            throw new IllegalArgumentException("Monstro não pode ser nulo.");
        }
        this.heroi = heroi;
        this.monstro = monstro;
    }

    public void iniciarBatalha() {
        boolean continuarBatalha = true;

        while (heroi.getSaude() > 0 && monstro.getSaude() > 0 && continuarBatalha) {

            int dado = rolarDado();
            heroiEscolheAtributo(dado);

            // Herói ataca
            int danoHeroi = calcularDano(heroi.getAtaque(), monstro.getDefesa());
            monstro.receberDano(danoHeroi);  // Atualiza a saúde do monstro
            JOptionPane.showMessageDialog(null, "Você atacou o monstro e causou " + danoHeroi + " de dano!");

            // Verifica se o monstro ainda está vivo antes de ele atacar
            if (monstro.getSaude() > 0) {
                // Monstro ataca
                int danoMonstro = calcularDano(monstro.getAtaque(), heroi.getDefesa());
                heroi.receberDano(danoMonstro);  // Atualiza a saúde do herói
                JOptionPane.showMessageDialog(null, "O monstro atacou você e causou " + danoMonstro + " de dano!");
            }

            // Pergunta ao jogador se deseja continuar
            int resposta = JOptionPane.showConfirmDialog(null, "Deseja continuar a batalha?", "Continuar?",
                    JOptionPane.YES_NO_OPTION);

            if (resposta != JOptionPane.YES_OPTION) {
                continuarBatalha = false;
                JOptionPane.showMessageDialog(null, "Você fugiu da batalha.");
            }
        }

        // Verifica o resultado da batalha
        if (heroi.getSaude() > 0 && monstro.getSaude() <= 0) {
            JOptionPane.showMessageDialog(null, "Você derrotou o monstro!");
        } else if (monstro.getSaude() > 0 && heroi.getSaude() <= 0) {
            JOptionPane.showMessageDialog(null, "Você foi derrotado pelo monstro...");
        } else if (heroi.getSaude() > 0 && !continuarBatalha) {
            JOptionPane.showMessageDialog(null, "Você fugiu da batalha.");
        }
    }


    private int calcularDano(int ataque, int defesa) {
        int danoBase = rolarDado();
        int danoFinal = (ataque + danoBase) - defesa;

        // Garante que o dano final não seja menor que 1
        return Math.max(danoFinal, 1);
    }

    private int rolarDado() {
        return (int) (Math.random() * 6) + 1; // Dado de 1 a 6
    }

    private void heroiEscolheAtributo(int valor) {
        String[] opcoes = {"Ataque", "Defesa", "Saúde"};
        String escolha = (String) JOptionPane.showInputDialog(
                null,
                "Você rolou um " + valor + ". Onde deseja aplicar?",
                "Escolha o Atributo",
                JOptionPane.PLAIN_MESSAGE,
                null,
                opcoes,
                "Ataque"
        );

        if (escolha != null) {
            switch (escolha) {
                case "Ataque":
                    heroi.setAtaque(heroi.getAtaque() + valor);
                    break;
                case "Defesa":
                    heroi.setDefesa(heroi.getDefesa() + valor);
                    break;
                case "Saúde":
                    heroi.setSaude(heroi.getSaude() + valor);
                    break;
            }
        }
    }
}








