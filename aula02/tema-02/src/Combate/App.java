package Combate;

import ClassesPersonagem.*;
import TiposAtaque.Arma;
import TiposAtaque.Magia;
import TiposAtaque.PoderDivino;

public class App {

    public static void main(String[] args) {
//        personagens e tipos de ataque criados para teste da aplicação
        MenuMetodos.listaCombatentes.add(new Barbaro(TiposDeClasses.BARBARO, "barbaro1", 2000, 20, 10, null));
        MenuMetodos.listaCombatentes.add(new Clerigo(TiposDeClasses.CLERIGO, "clerigo1", 250, 20, 10, 50));
        MenuMetodos.listaCombatentes.add(new Feiticeiro(TiposDeClasses.FEITICEIRO, "feiticeiro1", 250, 20, 10, 50));
        MenuMetodos.listaArmas.add(new Arma("arma1", 10));
        MenuMetodos.listaArmas.add(new Arma("arma2", 15));
        MenuMetodos.listaMagias.add(new Magia("magia1indiv", 20, 30, false));
        MenuMetodos.listaMagias.add(new Magia("magia2area", 10, 20, true));
        MenuMetodos.listaMagias.add(new Magia("magia3indiv", 20, 0, false));
        MenuMetodos.listaPoderesDivinos.add(new PoderDivino("poderdiv1-indiv", 12, 25, false));
        MenuMetodos.listaPoderesDivinos.add(new PoderDivino("poderdiv2-area", 12, 25, true));
        MenuMetodos.listaPoderesDivinos.add(new PoderDivino("poderdiv3-indiv", 12, 0, false));



        //MenuMetodos.criacaoPersonagens();
        System.out.println("============== HORA DO DUELO ============== ");
        int opcao = 0;

        while (opcao != 3) {
            System.out.println("============ ETAPA " + (Registros.listaRegistros.size() + 1) + " DE COMBATE =========== ");
            System.out.println("1 - Equipar\n2 - Atacar\n3 - Encerrar");

            opcao = MenuMetodos.tratarInputInt();

            switch (opcao) {
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
                    if (MenuMetodos.checkFimDaBatalha()) {
                        System.out.println("Aplicação encerrada.");
                        Registros.imprimirRegistros();
                        Registros.duracaoCombate();
                        opcao = 3;
                        break;
                    }
                    break;

                case 3:
                    System.out.println("Aplicação encerrada.");
                    Registros.imprimirRegistros();
                    Registros.duracaoCombate();
                    break;

                default:
                    System.out.println("Opção Inválida.");
                    break;
            }
//            System.out.println("===========================================");
        }


    }
}
