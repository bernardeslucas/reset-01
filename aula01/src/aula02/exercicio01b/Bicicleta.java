package aula02.exercicio01b;

public class Bicicleta extends VeiculoTerrestre {


    public Bicicleta(String nome, double velocidadeMaxima, String terreno, int lotacaoMaxima, int numeroDeRodas) {
        super(nome, velocidadeMaxima, terreno, lotacaoMaxima, numeroDeRodas);
    }

    @Override
    public String toString() {
        return "Bicicleta{" +
                "numeroDeRodas=" + numeroDeRodas +
                ", nome='" + nome + '\'' +
                ", velocidadeMaxima=" + velocidadeMaxima +
                ", terreno='" + terreno + '\'' +
                '}';
    }
}

