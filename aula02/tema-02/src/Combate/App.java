package Combate;

import TiposAtaque.Arma;
import TiposAtaque.Magia;
import TiposAtaque.PoderDivino;

public class App {

    public static void main(String[] args) {

//         personagens criados para teste da aplicação
//        Menu.listaCombatentes.add(new Barbaro(TiposDeClasses.BARBARO, "barbaro1", 2000, 20, 10, null));
//        Menu.listaCombatentes.add(new Clerigo(TiposDeClasses.CLERIGO, "clerigo1", 250, 20, 10, 50));
//        Menu.listaCombatentes.add(new Feiticeiro(TiposDeClasses.FEITICEIRO, "feiticeiro1", 250, 20, 10, 50));


        Menu.listaArmas.add(new Arma("Machado Leviatã", 15));
        Menu.listaArmas.add(new Arma("Espada longa", 10));
        Menu.listaArmas.add(new Arma("Martelo de guerra", 12));

        Menu.listaMagias.add(new Magia("Raio de ácido", 15, 10, false));
        Menu.listaMagias.add(new Magia("Bola de fogo", 10, 20, true));
        Menu.listaMagias.add(new Magia("Turbilhão de água", 20, 15, false));
        Menu.listaMagias.add(new Magia("Magia genérica (usar em último caso)", 5, 0, false));

        Menu.listaPoderesDivinos.add(new PoderDivino("Lâmina flamejante", 15, 10, false));
        Menu.listaPoderesDivinos.add(new PoderDivino("Explosão solar", 8, 20, true));
        Menu.listaPoderesDivinos.add(new PoderDivino("Destruição", 12, 15, false));
        Menu.listaPoderesDivinos.add(new PoderDivino("Poder divino genérico (usar em último caso)", 5, 0, false));


     Menu.criacaoPersonagens();

        System.out.println("============================================ HORA DO DUELO ============================================");
        int opcao = 0;
        while (opcao != 3) {

            System.out.println("========================================== ETAPA " + (Registros.getContadorAtaques() + 1) + " DE COMBATE =========================================");
            System.out.println("1 - Equipar\n2 - Atacar\n3 - Encerrar");

            opcao = Menu.tratarInputInt();

            switch (opcao) {
                case 1:
                    Menu.equipar();
                    break;

                case 2:
                    //mostra todos personagens vivos aptos a atacar
                    Menu.personagensVivosAtacar(Menu.listaCombatentes);

                    // mostra habilidades (arcanos/sacerdotes)
                    Menu.mostraHabilidades(Menu.listaCombatentes.get(Menu.escolhaAtacante));

                    // seleciona alvo (descontando si mesmo)
                    Menu.personagensVivosAlvos(Menu.listaCombatentes, Menu.listaCombatentes.get(Menu.escolhaAtacante), Menu.escolhaHabilidade);

                    //combate
                    Menu.combate();
                    if (Menu.checkFimDaBatalha()) {
                        System.out.println("Sessão encerrada.");
                        Registros.imprimirRegistros();
                        Registros.duracaoCombate();
                        opcao = 3;
                        break;
                    }
                    break;

                case 3:
                    System.out.println("Sessão encerrada.");
                    Registros.imprimirRegistros();
                    Registros.duracaoCombate();
                    break;

                default:
                    System.out.println("Opção Inválida.");
                    break;
            }
        }


    }
}
