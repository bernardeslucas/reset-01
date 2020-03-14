package aula02.exercicio01;

public class Carro extends Veiculo {
    //Nome, velocidade máxima, terreno (terra, água, ar), profundidade máxima, lotação máxima, combustível, altitude máxima, número de rodas

    String combustivel;
    int numeroDeRodas;

    public Carro(String nome, double velocidadeMaxima, String terreno, int lotacaoMaxima, String combustivel, int numeroDeRodas) {
        super(nome, velocidadeMaxima, terreno, lotacaoMaxima);
        this.combustivel = combustivel;
        this.numeroDeRodas = numeroDeRodas;

    }


}
