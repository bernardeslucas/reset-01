package Exercicio3;

public class Aluno {
    String nome;
    double nota;
    boolean resultado;

    Aluno(String nome, double nota) {
        this.nome = nome;
        this.nota = nota;
    }

    boolean situacao() {
        resultado = this.nota >= 7;
        return resultado;
    }
}
