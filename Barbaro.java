public class Barbaro extends Heroi {

    public Barbaro() {
        super( 100, 50, 100);
    }

    @Override
    public void acaoEspecial() {
        // Ataque Furioso: aumenta o ataque em 50%
        setAtaque(getAtaque() + (int)(getAtaque() * 0.5));
    }
}

