package aula01;

public class App {
    public static void main(String[] args) {


        Calculadora calculadoraDeIdades = new Calculadora();
        Comparador compararNumeros = new Comparador();

    /*
        int somaDasIdades = calculadoraDeIdades.soma(31, 41);
        System.out.println(somaDasIdades);

        int subtraiIdades = calculadoraDeIdades.subtrai(40, 30);
        System.out.println(subtraiIdades);

        int multiplicaIdades = calculadoraDeIdades.multiplica(40, 3);
        System.out.println(multiplicaIdades);

        int divideIdades = calculadoraDeIdades.divide(40, 30);
        System.out.println(divideIdades);
    */

        boolean compara = compararNumeros.menorQue(3, 5);
        System.out.println(compara);


    }


}


