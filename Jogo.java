public class Jogo {
    private Tabuleiro tabuleiro;
    private Heroi heroi;
    private Chefao chefao;
    private int celulasVisitadas;
    private final int CELULAS_MINIMAS = 3;

    public Jogo(Tabuleiro tabuleiro, Heroi heroi, Chefao chefao) {
        this.tabuleiro = tabuleiro;
        this.heroi = heroi;
        this.chefao = chefao;
        this.celulasVisitadas = 0;
    }

    public void moverParaCelula(int novaLinha, int novaColuna) throws MovimentoInvalidoException {
        if (tabuleiro.isChefao(novaLinha, novaColuna)) {
            if (celulasVisitadas < CELULAS_MINIMAS) {
                throw new MovimentoInvalidoException("Você deve visitar pelo menos " + CELULAS_MINIMAS + " células antes de enfrentar o chefão.");
            } else {
                System.out.println("Você está na célula do chefão! Prepare-se para a batalha final!");

                Batalha batalha = new Batalha(heroi, chefao);
                batalha.iniciarBatalha();

                if (!chefao.estaVivo()) {
                    System.out.println("Parabéns! Você derrotou o chefão!");
                }
            }
        } else {
            celulasVisitadas++;
            tabuleiro.moverPersonagem(novaLinha, novaColuna);
        }
    }

    public int getCelulasVisitadas() {
        return celulasVisitadas;
    }
}



