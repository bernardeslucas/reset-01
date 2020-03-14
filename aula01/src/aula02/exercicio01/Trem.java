package aula02.exercicio01;

public class Trem extends Veiculo {
    String combustivel;
    int numeroDeRodas;
    // profundidade máxima, combustível, altitude máxima, número de rodas

    public Trem(String nome, double velocidadeMaxima, String terreno, int lotacaoMaxima, String combustivel, int numeroDeRodas) {
        super(nome, velocidadeMaxima, terreno, lotacaoMaxima);
        this.combustivel = combustivel;
        this.numeroDeRodas = numeroDeRodas;
    }

}
