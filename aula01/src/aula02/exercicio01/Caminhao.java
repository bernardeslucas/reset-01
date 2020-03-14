package aula02.exercicio01;

public class Caminhao extends Veiculo {
    // profundidade máxima, combustível, altitude máxima, número de rodas
    String combustivel;
    int numeroDeRodas;

    public Caminhao(String nome, double velocidadeMaxima, String terreno, int lotacaoMaxima, String combustivel, int numeroDeRodas) {
        super(nome, velocidadeMaxima, terreno, lotacaoMaxima);
        this.combustivel = combustivel;
        this.numeroDeRodas = numeroDeRodas;

    }
}
