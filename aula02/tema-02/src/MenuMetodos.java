import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuMetodos {

    static List<Personagem> listaCombatentes = new ArrayList<>();
    static List<Arma> listaArmas = new ArrayList<>();
    static List<Magia> listaMagias = new ArrayList<>();
    static List<PoderDivino> listaPoderesDivinos = new ArrayList<>();
    static List<Personagem> listAtacados = new ArrayList<>();
    static int escolhaAtacante;
    static int escolhaAlvo;
    static int escolhaHabilidade;
    static int escolhaArma;


    public static void criacaoPersonagens() {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Quantos combatentes estarão presente em sua batalha, caro jogador?");
        int qtdCombatentes = teclado.nextInt();

        System.out.println("\n ==================== CRIAÇÃO DE PERSONAGENS ====================");
        for (int i = 0; i < qtdCombatentes; i++) {
            System.out.println("Qual a classe do " + (i + 1) + "º personagem? (Digite o número correspondente)");
            for (TiposDeClasses d : TiposDeClasses.values()) {
                System.out.println(d.getId() + " - " + d.getDescricao());
            }
            TiposDeClasses escolha = TiposDeClasses.findById(teclado.nextInt());
            System.out.print("Nome: ");
            String nome = teclado.next();
            System.out.print("Vida: ");
            int vida = teclado.nextInt();
            System.out.print("Ataque: ");
            int ataque = teclado.nextInt();
            System.out.print("Defesa: ");
            int defesa = teclado.nextInt();

            switch (escolha) {
                case BARBARO:
                    listaCombatentes.add(new Barbaro(TiposDeClasses.BARBARO, nome, vida, ataque, defesa, null));
                    break;
                case CLERIGO:
                    System.out.print("Fé: ");
                    int fe = teclado.nextInt();
                    listaCombatentes.add(new Clerigo(TiposDeClasses.CLERIGO, nome, vida, ataque, defesa, fe));
                    break;
                case DRUIDA:
                    System.out.print("Fé: ");
                    fe = teclado.nextInt();
                    listaCombatentes.add(new Druida(TiposDeClasses.DRUIDA, nome, vida, ataque, defesa, fe));
                    break;
                case FEITICEIRO:
                    System.out.print("Mana: ");
                    int mana = teclado.nextInt();
                    listaCombatentes.add(new Feiticeiro(TiposDeClasses.FEITICEIRO, nome, vida, ataque, defesa, mana));
                    break;
                case GUERREIRO:
                    listaCombatentes.add(new Guerreiro(TiposDeClasses.GUERREIRO, nome, vida, ataque, defesa, null));
                    break;
                case MAGO:
                    System.out.print("Mana: ");
                    mana = teclado.nextInt();
                    listaCombatentes.add(new Mago(TiposDeClasses.MAGO, nome, vida, ataque, defesa, mana));
                    break;
            }
            System.out.println("--------------------------------------------------------------");
        }
    }

    public static void homensDeArmaAtacar(List<Personagem> lista) {
        Scanner teclado = new Scanner(System.in);
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getVida() > 0 && lista.get(i) instanceof HomemDeArmas) {
                System.out.println((i + 1) + " - " + lista.get(i).getTipoClasse().getDescricao() + ": " + lista.get(i).getNome());
            }
        }
        escolhaAtacante = teclado.nextInt() - 1;
    }

    public static void personagensVivosAtacar(List<Personagem> lista) {
        Scanner teclado = new Scanner(System.in);
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getVida() > 0) {
                System.out.println((i + 1) + " - " + lista.get(i).getTipoClasse().getDescricao() + ": " + lista.get(i).getNome());
            }
        }
        escolhaAtacante = teclado.nextInt() - 1;
    }

    public static void personagensVivosAlvos(List<Personagem> lista, Personagem personagem, int escolhaHabilidade) {
        Scanner teclado = new Scanner(System.in);

        if ((personagem instanceof Arcano || personagem instanceof Sacerdote) && (listaMagias.get(escolhaHabilidade).isArea() || listaPoderesDivinos.get(escolhaHabilidade).isArea())) {
            System.out.println("Escolha os personagens alvos para o seu ataque. Digite algo como '1,3,5' correspondente aos personagens");
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getVida() > 0 && lista.get(i) != personagem) {
                    System.out.println((i + 1) + " - " + lista.get(i).getTipoClasse().getDescricao() + ": " + lista.get(i).getNome());
                }
            }
            String escolhaAlvos = teclado.next();
            String listaStr[] = escolhaAlvos.split(",");


            for (int i = 0; i < listaStr.length; i++) {
                listAtacados.add(lista.get(Integer.parseInt(listaStr[i]) - 1));
            }

        } else {
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getVida() > 0 && lista.get(i) != personagem) {
                    System.out.println((i + 1) + " - " + lista.get(i).getTipoClasse().getDescricao() + ": " + lista.get(i).getNome());
                }
            }
            escolhaAlvo = teclado.nextInt() - 1;
        }


//            for (int i = 0; i < listaMagias.size(); i++) {
//                System.out.println(i + 1 + " - " + listaMagias.get(i).getNome());
//            }
//            escolhaHabilidade = teclado.nextInt() - 1;
//        } else if (personagem instanceof Sacerdote) {
//            System.out.println("Escolha a habilidade para usar");
//            for (int i = 0; i < listaPoderesDivinos.size(); i++) {
//                System.out.println(i + 1 + " - " + listaPoderesDivinos.get(i).getNome());
//            }
//            escolhaHabilidade = teclado.nextInt() - 1;
//        }
//
//    }


//
    }

    public static void equipar() {
        Scanner teclado = new Scanner(System.in);
        homensDeArmaAtacar(listaCombatentes);
        for (int i = 0; i < listaArmas.size(); i++) {
            System.out.println(i + 1 + " - " + listaArmas.get(i).getNome());
        }
        escolhaArma = teclado.nextInt() - 1;
        HomemDeArmas combatente = (HomemDeArmas) listaCombatentes.get(escolhaAtacante);
        combatente.setArmaEquipada(listaArmas.get(escolhaArma));
    }

    public static void mostraHabilidades(Personagem personagem) {
        Scanner teclado = new Scanner(System.in);

        if (personagem instanceof Arcano) {
            System.out.println("Escolha a habilidade para usar");
            for (int i = 0; i < listaMagias.size(); i++) {
                System.out.println(i + 1 + " - " + listaMagias.get(i).getNome());
            }
            escolhaHabilidade = teclado.nextInt() - 1;

        } else if (personagem instanceof Sacerdote) {
            System.out.println("Escolha a habilidade para usar");
            for (int i = 0; i < listaPoderesDivinos.size(); i++) {
                System.out.println(i + 1 + " - " + listaPoderesDivinos.get(i).getNome());
            }
            escolhaHabilidade = teclado.nextInt() - 1;

        }

    }

    public static void combate() {

        if (listaCombatentes.get(escolhaAtacante) instanceof HomemDeArmas) {
            HomemDeArmas combatente = (HomemDeArmas) listaCombatentes.get(escolhaAtacante);
            try {
                combatente.atacar(listaCombatentes.get(MenuMetodos.escolhaAlvo), combatente.getArmaEquipada());
            } catch (Exception e){
                System.out.println("O Homem de Arma atacante não está com alguma arma equipada.");
            }

        } else if (listaCombatentes.get(escolhaAtacante) instanceof Sacerdote) {
            Sacerdote combatente = (Sacerdote) listaCombatentes.get(escolhaAtacante);
            if (listaPoderesDivinos.get(escolhaHabilidade).isArea()) {
                combatente.atacarArea(listAtacados, listaPoderesDivinos.get(escolhaHabilidade));
            } else {
                combatente.atacarIndividual(listaCombatentes.get(MenuMetodos.escolhaAlvo), MenuMetodos.listaPoderesDivinos.get(escolhaHabilidade));
            }

        } else if (listaCombatentes.get(escolhaAtacante) instanceof Arcano) {
            Arcano combatente = (Arcano) listaCombatentes.get(escolhaAtacante);
            if (listaMagias.get(escolhaHabilidade).isArea()) {
                combatente.atacarArea(listAtacados, listaMagias.get(escolhaHabilidade));
            } else {
                combatente.atacarIndividual(listaCombatentes.get(MenuMetodos.escolhaAlvo), MenuMetodos.listaMagias.get(escolhaHabilidade));
            }
        }
    }


}



