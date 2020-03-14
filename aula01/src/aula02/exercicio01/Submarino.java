package aula02.exercicio01;

public class Submarino extends Veiculo {
    String combustivel;
    double profundidadeMaxima;

    public Submarino(String nome, double velocidadeMaxima, String terreno, int lotacaoMaxima, double profundidadeMaxima, String combustivel) {
        super(nome, velocidadeMaxima, terreno, lotacaoMaxima);
        this.profundidadeMaxima = profundidadeMaxima;
        this.combustivel = combustivel;
    }


}
