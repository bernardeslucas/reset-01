package exercicio3;

public class Item {

    private String nome;
    private double valor;
    private int quantidade;
    private Segmento segmento;


    public Item(String nome, double valor, Segmento segmento) {
        this.nome = nome;
        this.valor = valor;

        this.segmento = segmento;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Segmento getSegmento() {
        return segmento;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
