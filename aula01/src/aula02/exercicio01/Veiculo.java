package aula02.exercicio01;

public class Veiculo {

    //Representar veículos
    //Navio, submarino, trem, caminhão, carro, bicicleta, avião
    //Características dos veículos
    //Nome, velocidade máxima, terreno (terra, água, ar), profundidade máxima, lotação máxima, combustível, altitude máxima, número de rodas

    String nome;
    double velocidadeMaxima;
    String terreno;
    int lotacaoMaxima;

    public Veiculo(String nome, double velocidadeMaxima, String terreno, int lotacaoMaxima){
        this.nome = nome;
        this.velocidadeMaxima = velocidadeMaxima;
        this.terreno= terreno;
        this.lotacaoMaxima = lotacaoMaxima;
    }



}
