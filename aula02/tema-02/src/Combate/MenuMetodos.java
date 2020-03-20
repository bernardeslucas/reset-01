package Combate;

import ClassesPersonagem.*;
import TiposAtaque.Arma;
import TiposAtaque.Magia;
import TiposAtaque.PoderDivino;

import java.util.*;

public class MenuMetodos {

    static List<Personagem> listaCombatentes = new ArrayList<>();
    static List<Arma> listaArmas = new ArrayList<>();
    static List<Magia> listaMagias = new ArrayList<>();
    static List<PoderDivino> listaPoderesDivinos = new ArrayList<>();
    static List<Personagem> listAtacados = new ArrayList<>();
    static Integer escolhaAtacante;
    static int escolhaAlvo;
    static int escolhaHabilidade;
    static int escolhaArma;



    public static int tratarInputInt() {
        Scanner teclado = new Scanner(System.in);
        int valor;
        boolean isValid;

        while (true) {
            valor = 0;
            try {
                valor = teclado.nextInt();
            } catch (Exception e) {
                teclado.next();
            }
            isValid = valor > 0;
            if (isValid) {
                break;
            }

            System.out.println("Caracter inválido / número negativo. Digite um número do tipo 'int' >0:");
        }
        return valor;
    }

    public static int tratarInputIntPlusCheckList(List<Integer> lista, String tipo) {
        int valor;
        boolean isValid;
        while (true) {
            valor = tratarInputInt();
            isValid = lista.contains(valor);
            if (isValid) {
                break;
            }
            System.out.println(tipo + " indisponível. Digite um número válido conforme a lista acima ^:");
        }
        return valor;
    }

    public static void criacaoPersonagens() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Quantos combatentes estarão presente em sua batalha, caro jogador?");
        int qtdCombatentes = tratarInputInt();
        List<Integer> listaAuxiliar = new ArrayList<>();

        System.out.println("\n ==================== CRIAÇÃO DE PERSONAGENS ====================");
        for (int i = 0; i < qtdCombatentes; i++) {
            System.out.println("Qual a classe do " + (i + 1) + "º personagem? (Digite o número correspondente)");
            for (TiposDeClasses d : TiposDeClasses.values()) {
                System.out.println((d.getId()) + " - " + d.getDescricao());
                listaAuxiliar.add(d.getId());
            }
            TiposDeClasses escolha = TiposDeClasses.findById(tratarInputIntPlusCheckList(listaAuxiliar, "Classe"));
            System.out.print("Nome: ");
            String nome = teclado.next();
            System.out.print("Vida: ");
            int vida = tratarInputInt();
            System.out.print("Ataque: ");
            int ataque = tratarInputInt();
            System.out.print("Defesa: ");
            int defesa = tratarInputInt();


            switch (escolha) {
                case BARBARO:
                    listaCombatentes.add(new Barbaro(TiposDeClasses.BARBARO, nome, vida, ataque, defesa, null));
                    break;
                case CLERIGO:
                    System.out.print("Fé: ");
                    int fe = tratarInputInt();
                    listaCombatentes.add(new Clerigo(TiposDeClasses.CLERIGO, nome, vida, ataque, defesa, fe));
                    break;
                case DRUIDA:
                    System.out.print("Fé: ");
                    fe = tratarInputInt();
                    listaCombatentes.add(new Druida(TiposDeClasses.DRUIDA, nome, vida, ataque, defesa, fe));
                    break;
                case FEITICEIRO:
                    System.out.print("Mana: ");
                    int mana = tratarInputInt();
                    listaCombatentes.add(new Feiticeiro(TiposDeClasses.FEITICEIRO, nome, vida, ataque, defesa, mana));
                    break;
                case GUERREIRO:
                    listaCombatentes.add(new Guerreiro(TiposDeClasses.GUERREIRO, nome, vida, ataque, defesa, null));
                    break;
                case MAGO:
                    System.out.print("Mana: ");
                    mana = tratarInputInt();
                    listaCombatentes.add(new Mago(TiposDeClasses.MAGO, nome, vida, ataque, defesa, mana));
                    break;
            }
            System.out.println("--------------------------------------------------------------");
        }
    }

    public static void equipar() {
        List<Integer> listaAuxiliar = new ArrayList<>();
        System.out.println("Escolha o homem de arma do qual você deseja equipar alguma arma. Digite o número correspondente:");
        homensDeArmaEquipar(listaCombatentes);
        System.out.println("Escolha a arma para equipar:");
        for (int i = 0; i < listaArmas.size(); i++) {
            System.out.println((i + 1) + " - " + listaArmas.get(i).getNome());
            listaAuxiliar.add(i+1);

        }
        escolhaArma = tratarInputIntPlusCheckList(listaAuxiliar, "Arma") - 1;

        HomemDeArmas combatente = (HomemDeArmas) listaCombatentes.get(escolhaAtacante);
        combatente.setArmaEquipada(listaArmas.get(escolhaArma));
    }

    public static void homensDeArmaEquipar(List<Personagem> lista) {

        List<Integer> listaAuxiliar = new ArrayList<>();

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getVida() > 0 && lista.get(i) instanceof HomemDeArmas) {
                System.out.println((i + 1) + " - " + lista.get(i).getTipoClasse().getDescricao() + ": " + lista.get(i).getNome());
                listaAuxiliar.add(i + 1);
            }
        }
        escolhaAtacante = tratarInputIntPlusCheckList(listaAuxiliar, "Homem de TiposAtaque.Arma") - 1;
    }

    public static void personagensVivosAtacar(List<Personagem> lista) {
        List<Integer> listaAuxiliar = new ArrayList<>();
        System.out.println("Escolha o personagem atacante:");
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getVida() > 0) {
                System.out.println((i + 1) + " - " + lista.get(i).getTipoClasse().getDescricao() + ": " + lista.get(i).getNome());
                listaAuxiliar.add(i + 1);
            }
        }
        escolhaAtacante = tratarInputIntPlusCheckList(listaAuxiliar, "Personagem") - 1;
    }

    public static void personagensVivosAlvos(List<Personagem> lista, Personagem personagem, int escolhaHabilidade) {
        Scanner teclado = new Scanner(System.in);

        if ((personagem instanceof Arcano || personagem instanceof Sacerdote) && (listaMagias.get(escolhaHabilidade).isArea() || listaPoderesDivinos.get(escolhaHabilidade).isArea())) {

            List<Integer> listaAuxiliar = new ArrayList<>();
            System.out.println("Escolha os personagens alvos para o seu ataque. Digite algo como '1,3,5' correspondente aos personagens:");
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getVida() > 0 && lista.get(i) != personagem) {
                    System.out.println((i + 1) + " - " + lista.get(i).getTipoClasse().getDescricao() + ": " + lista.get(i).getNome());
                    listaAuxiliar.add(i + 1);
                    // listaAuxiliar = {0,2}

                }
            }
            boolean isValid;
            while (true) {
                listAtacados.clear();
                String escolhaAlvos = teclado.next();
                String[] listaStr = escolhaAlvos.split(",");

                //convertendo array string to array integer para adicionar na lista via Collections.addAll para validação posterior
                List<Integer> listEscolhaAlvos = new ArrayList<>();
                try {
                    Integer[] newArray = Arrays.stream(listaStr).map(Integer::parseInt).toArray(Integer[]::new);
                    Collections.addAll(listEscolhaAlvos, newArray);

                } catch (Exception e) {
                }

                isValid = listaAuxiliar.containsAll(listEscolhaAlvos) && listEscolhaAlvos.size() >= 2;
                if (isValid) {
                    for (int i = 0; i < listaStr.length; i++) {
                        listAtacados.add(lista.get(Integer.parseInt(listaStr[i]) - 1));
                    }
                    break;
                }
                System.out.println("Entrada inválida (apenas 1 alvo, alvos inválidos, caracteres inválidos). Digite novamente:");
            }
        } else {
            System.out.println("Escolha o personagem alvo do seu ataque. Digite o número correspondente:");
            List<Integer> listaAuxiliar = new ArrayList<>();
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getVida() > 0 && lista.get(i) != personagem) {
                    System.out.println((i + 1) + " - " + lista.get(i).getTipoClasse().getDescricao() + ": " + lista.get(i).getNome());
                    listaAuxiliar.add(i + 1);
                }
            }
            escolhaAlvo = tratarInputIntPlusCheckList(listaAuxiliar, "ClassesPersonagem.Personagem") - 1;
        }
    }

    public static void mostraHabilidades(Personagem personagem) {
        List<Integer> listaAuxiliar = new ArrayList<>();

        if (personagem instanceof Arcano) {
            Arcano combatente = (Arcano) personagem;
            System.out.println("Escolha a habilidade para usar:");

            for (int i = 0; i < listaMagias.size(); i++) {
                if (listaMagias.get(i).getCustoMana() < combatente.getMana()) {
                    System.out.println((i + 1) + " - " + listaMagias.get(i).getNome());
                    listaAuxiliar.add(i + 1);
                }
            }

            escolhaHabilidade = tratarInputIntPlusCheckList(listaAuxiliar, "Magia") - 1;


        } else if (personagem instanceof Sacerdote) {
            Sacerdote combatente = (Sacerdote) personagem;
            System.out.println("Escolha a habilidade para usar:");

            for (int i = 0; i < listaPoderesDivinos.size(); i++) {
                if (listaPoderesDivinos.get(i).getCustoFe() < combatente.getFe()) {
                    System.out.println((i + 1) + " - " + listaPoderesDivinos.get(i).getNome());
                    listaAuxiliar.add(i + 1);
                }
            }
            escolhaHabilidade = tratarInputIntPlusCheckList(listaAuxiliar, "Poder divino") - 1;
        }

    }

    public static void combate() {

        if (listaCombatentes.get(escolhaAtacante) instanceof HomemDeArmas) {
            HomemDeArmas combatente = (HomemDeArmas) listaCombatentes.get(escolhaAtacante);
            try {
                combatente.atacar(listaCombatentes.get(MenuMetodos.escolhaAlvo), combatente.getArmaEquipada());
            } catch (Exception e) {
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

    public static boolean checkFimDaBatalha() {
        boolean check = false;
        List<Personagem> listaAuxiliar = new ArrayList<>();
        for (int i = 0; i < listaCombatentes.size(); i++) {
            if (listaCombatentes.get(i).getVida() > 0) {
                listaAuxiliar.add(listaCombatentes.get(i));
            }
        }
        if (listaAuxiliar.size() == 1) {
            check = true;
            System.out.println("===========================================\n" +
                    "O último sobrevivente da batalha é: " + listaAuxiliar.get(0).getTipoClasse().getDescricao() + " - " + listaAuxiliar.get(0).getNome() + ".");
        }
        return check;


    }


}



