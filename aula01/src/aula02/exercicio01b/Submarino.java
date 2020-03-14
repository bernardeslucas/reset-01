package aula02.exercicio01b;

public class Submarino extends VeiculoAquatico {

    double profundidadeMaxima;

    public Submarino(String nome, double velocidadeMaxima, String terreno, int lotacaoMaxima, String combustivel, double profundidadeMaxima) {
        super(nome, velocidadeMaxima, terreno, lotacaoMaxima, combustivel);
        this.profundidadeMaxima=profundidadeMaxima;
    }

    @Override
    public String toString() {
        return "Submarino{" +
                "profundidadeMaxima=" + profundidadeMaxima +
                ", combustivel='" + combustivel + '\'' +
                ", nome='" + nome + '\'' +
                ", velocidadeMaxima=" + velocidadeMaxima +
                ", terreno='" + terreno + '\'' +
                ", lotacaoMaxima=" + lotacaoMaxima +
                '}';
    }
}
