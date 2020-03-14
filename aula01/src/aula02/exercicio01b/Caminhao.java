package aula02.exercicio01b;

public class Caminhao extends VeiculoTerrestre {

    String combustivel;


    public Caminhao(String nome, double velocidadeMaxima, String terreno, int lotacaoMaxima, int numeroDeRodas, String combustivel) {
        super(nome, velocidadeMaxima, terreno, lotacaoMaxima, numeroDeRodas);
        this.combustivel=combustivel;
    }

    @Override
    public String toString() {
        return "Caminhao{" +
                "combustivel='" + combustivel + '\'' +
                ", numeroDeRodas=" + numeroDeRodas +
                ", nome='" + nome + '\'' +
                ", velocidadeMaxima=" + velocidadeMaxima +
                ", terreno='" + terreno + '\'' +
                ", lotacaoMaxima=" + lotacaoMaxima +
                '}';
    }
}
