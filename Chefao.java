import javax.swing.JOptionPane;


public class Chefao extends Monstro {

    public Chefao(int i, int i1, int i2) {
        super( 120, 120, 200);
    }

    @Override
    public void acaoEspecial() {
        int cura = 30;
        this.setSaude(this.getSaude() + cura);
        JOptionPane.showMessageDialog(null, "O chefão usou sua ação especial e se curou em " + cura + " pontos de vida!");
    }
}
