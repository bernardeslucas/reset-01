package TiposAtaque;

public abstract class Habilidade {


    private final String nome;
    private final int poderAtaque;

    public Habilidade(String nome, int poderAtaque) {
        this.nome = nome;
        this.poderAtaque = poderAtaque;
    }

    public String getNome() {
        return nome;
    }

    public int getPoderAtaque() {
        return poderAtaque;
    }
}
