package aula02.exercicio01b;

public class VeiculoAquatico extends Veiculo {
    String combustivel;

    public VeiculoAquatico(String nome, double velocidadeMaxima, String terreno, int lotacaoMaxima, String combustivel) {
        super(nome, velocidadeMaxima, terreno, lotacaoMaxima);
        this.combustivel = combustivel;
    }
}
