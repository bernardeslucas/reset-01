package aula02.exercicio01b;

public class VeiculoAereo extends Veiculo {
    double altitudeMaxima;
    String combustivel;


    public VeiculoAereo(String nome, double velocidadeMaxima, String terreno, int lotacaoMaxima, String combustivel, double altitudeMaxima) {

        super(nome, velocidadeMaxima, terreno, lotacaoMaxima);
        this.combustivel = combustivel;
        this.altitudeMaxima = altitudeMaxima;
    }


}
