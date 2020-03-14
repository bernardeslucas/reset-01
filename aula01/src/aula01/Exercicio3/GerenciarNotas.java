package aula01.Exercicio3;

public class GerenciarNotas {
    public static void main(String[] args) {

        Aluno aluno1 = new Aluno("Lucas", 8.5);


        System.out.println(aluno1.nome);
        System.out.println(aluno1.nota);


        System.out.println(aluno1.situacao());

       /* boolean resultado = aluno1.nota>=7;
        System.out.println(resultado);
       */
    }
}
