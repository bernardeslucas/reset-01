package aula02.exercicio01;

public class Bicicleta extends Veiculo {
    //Nome, velocidade máxima, terreno (terra, água, ar), profundidade máxima, lotação máxima, combustível, altitude máxima, número de rodas


    int numeroDeRodas;

    public Bicicleta(String nome, double velocidadeMaxima, String terreno, int lotacaoMaxima, int numeroDeRodas) {
        super(nome, velocidadeMaxima, terreno, lotacaoMaxima);
        this.numeroDeRodas = numeroDeRodas;

    }
}
