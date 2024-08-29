public abstract class Personagem {
    private int ataque;
    private int defesa;
    private int saude;

    public Personagem( int ataque, int defesa, int saude) {

        this.ataque = ataque;
        this.defesa = defesa;
        this.saude = saude;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public int getSaude() {
        return saude;
    }

    public void setSaude(int saude) {
        this.saude = saude;
    }

    public void receberDano(int dano) {

        int danoReal = dano - this.defesa;


        if (danoReal < 0) {
            danoReal = 0;
        }


        this.saude -= danoReal;


        if (this.saude < 0) {
            this.saude = 0;
        }

        // Exibe uma mensagem indicando o dano recebido
        System.out.println(  " Você recebeu " + danoReal + " de dano. Saúde restante: " + this.saude);
    }


    public boolean estaVivo() {
        return this.saude > 0;
    }


    public abstract void acaoEspecial();
}

