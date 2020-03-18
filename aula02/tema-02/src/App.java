import java.util.Scanner;

public class App {


    public static void main(String[] args) {
        //lista criada pra testar métodos restantes, metodo criar já funciona.



        MenuMetodos.listaCombatentes.add(new Barbaro(TiposDeClasses.BARBARO, "barbaro1", 2000, 20, 10, null));
        MenuMetodos.listaCombatentes.add(new Clerigo(TiposDeClasses.CLERIGO, "clerigo1", 2000, 20, 10, 50));
        MenuMetodos.listaCombatentes.add(new Feiticeiro(TiposDeClasses.FEITICEIRO, "feiticeiro1", 2000, 20, 10, 50));

        // fazer enum disso dps?
        MenuMetodos.listaArmas.add(new Arma("arma1", 10));
        MenuMetodos.listaArmas.add(new Arma("arma2", 15));

        MenuMetodos.listaMagias.add(new Magia("magia1indiv", 20, 5, false));
        MenuMetodos.listaMagias.add(new Magia("magia2area", 10, 5, true));

        MenuMetodos.listaPoderesDivinos.add(new PoderDivino("poderdiv1indiv", 12, 5, false));
        MenuMetodos.listaPoderesDivinos.add(new PoderDivino("poderdiv2area", 12, 5, true));


        Scanner teclado = new Scanner(System.in);
        System.out.println(" ============== HORA DO DUELO ============== ");
        int opcao = 0;
        while (opcao != 3) {
            System.out.println("1 - Equipar\n2 - Atacar\n3 - Encerrar");
            opcao = teclado.nextInt();
            switch (opcao){
                case 1:
                    MenuMetodos.equipar();
                    break;

                case 2:
                    //mostra todos personagens vivos aptos a atacar
                    MenuMetodos.personagensVivosAtacar(MenuMetodos.listaCombatentes);

                    // mostra habilidades (arcanos/sacerdotes)
                    MenuMetodos.mostraHabilidades(MenuMetodos.listaCombatentes.get(MenuMetodos.escolhaAtacante));

                    // seleciona alvo (descontando si mesmo)
                    MenuMetodos.personagensVivosAlvos(MenuMetodos.listaCombatentes, MenuMetodos.listaCombatentes.get(MenuMetodos.escolhaAtacante), MenuMetodos.escolhaHabilidade);

                    //combate
                    MenuMetodos.combate();
                    break;
                case 3:
                    System.out.println("Combate encerrado");
                    //aguardando implementação registros
                    break;
            }
            System.out.println("===========================================================================");





        }







        // SELECIONA ALVO - lista personagens vivos pegando o input do user pra ter o index




    }
}
