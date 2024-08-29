public class Palatino extends Heroi {

    public Palatino() {
        super( 70, 60, 150);
    }

    @Override
    public void acaoEspecial() {
        // Super Saúde: aumenta a saúde em 50%
        setSaude(getSaude() + (int)(getSaude() * 0.5));
    }
}
