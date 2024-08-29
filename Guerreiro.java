public class Guerreiro extends Heroi {

    public Guerreiro() {
        super( 80, 100, 120);
    }

    @Override
    public void acaoEspecial() {
        // Defesa Poderosa: aumenta a defesa em 50%
        setDefesa(getDefesa() + (int)(getDefesa() * 0.5));
    }
}