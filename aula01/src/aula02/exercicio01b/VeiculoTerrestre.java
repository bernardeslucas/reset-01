package aula02.exercicio01b;

public class VeiculoTerrestre extends Veiculo {
    int numeroDeRodas;


    public VeiculoTerrestre(String nome, double velocidadeMaxima, String terreno, int lotacaoMaxima, int numeroDeRodas) {
        super(nome, velocidadeMaxima, terreno, lotacaoMaxima);
        this.numeroDeRodas=numeroDeRodas;
    }
}
