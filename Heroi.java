public abstract class Heroi extends Personagem {

    public Heroi( int ataque, int defesa, int saude) {
        super(ataque, defesa, saude);
    }

    @Override
    public abstract void acaoEspecial();
}

