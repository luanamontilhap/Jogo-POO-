public class Monstro extends Personagem {

    public Monstro( int ataque, int defesa, int saude) {
        super( ataque, defesa, saude);
    }

    @Override
    public void acaoEspecial() {
        // Monstros comuns podem não ter habilidades especiais
    }
}
