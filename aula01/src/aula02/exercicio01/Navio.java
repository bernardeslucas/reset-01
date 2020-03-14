package aula02.exercicio01;

public class Navio extends Veiculo {
    // profundidade máxima, combustível, altitude máxima, número de rodas


    String combustivel;


    // nome, velocidademaxima, terreno, lotacao
    Navio(String nome, double velocidadeMaxima, String terreno, int lotacaoMaxima, String combustivel) {
        super(nome, velocidadeMaxima, terreno, lotacaoMaxima);
        this.combustivel = combustivel;

    }


}
