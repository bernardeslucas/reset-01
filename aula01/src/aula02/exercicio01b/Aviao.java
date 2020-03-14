package aula02.exercicio01b;

public class Aviao extends VeiculoAereo {

    public Aviao(String nome, double velocidadeMaxima, String terreno, int lotacaoMaxima, String combustivel, double altitudeMaxima) {
        super(nome, velocidadeMaxima, terreno, lotacaoMaxima, combustivel, altitudeMaxima);

    }

    @Override
    public String toString() {
        return "Aviao{" +
                "altitudeMaxima=" + altitudeMaxima +
                ", nome='" + nome + '\'' +
                ", velocidadeMaxima=" + velocidadeMaxima +
                ", terreno='" + terreno + '\'' +
                ", lotacaoMaxima=" + lotacaoMaxima +
                '}';
    }
}
