package aula02.exercicio01;

public class Aviao extends Veiculo {
    String combustivel;
    int numeroDeRodas;
    double altidudeMaxima;

    public Aviao(String nome, double velocidadeMaxima, String terreno, int lotacaoMaxima, String combustivel, int numeroDeRodas, double altidudeMaxima) {
        super(nome, velocidadeMaxima, terreno, lotacaoMaxima);
        this.combustivel = combustivel;
        this.numeroDeRodas = numeroDeRodas;
        this.altidudeMaxima = altidudeMaxima;

    }


}
