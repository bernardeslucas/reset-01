package consoleApp;

import management.SportManagement;
import objects.Sport;

import java.util.List;

public class SportMenu {

    private SportManagement management;
    private CustomScanner scanner;

    public SportMenu() {
        this.management = new SportManagement();
        this.scanner = new CustomScanner();
    }

    public void options() {
        int option = 0;

        while (option != 6) {
            System.out.println("\nSelecione uma opção:");
            System.out.println("[1] Criar");
            System.out.println("[2] Editar");
            System.out.println("[3] Listar");
            System.out.println("[4] Procurar");
            System.out.println("[5] Deletar");
            System.out.println("[6] Voltar");

            option = scanner.nextInt("> ");

            switch (option) {
                case 1:
                    create();
                    break;
                case 2:
                    edit();
                    break;
                case 3:
                    list();
                    break;
                case 4:
                    search();
                    break;
                case 5:
                    delete();
                    break;
                case 6:
                    System.out.println("...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }

    }

    public Sport info() {

        String name = scanner.nextLine("Nome: ");
        return new Sport(name);
    }

    public Sport create() {
        System.out.println("Criação de esporte..");
        Sport sport = info();
        Sport sportCreated = management.create(sport);

        return sportCreated;
    }

    public List<Sport> list(){
        System.out.println("Lista de esportes..");
        List<Sport> sports = management.list();
        for (Sport m : sports){
            System.out.println(m);
        }
        return sports;
    }

    public Sport edit() {
        System.out.println("\nEditar esporte..\nQual esporte deseja editar?");


        List<Sport> sports = management.list();
        for (Sport m : sports) {
            System.out.println("[" + m.getId() + "] - " + m.getName());
        }

        int id = scanner.nextInt("> ");
        if (management.search(id) == null) {
            System.out.println("Esporte não encontrado.");
            return null;
        }
        Sport sport = info();

        Sport sportUpdated = management.edit(id, sport);

        return sportUpdated;
    }

    public void search() {
        int id = scanner.nextInt("Pesquisa de esporte..\nQual o id do esporte?\n> ");
        Sport sport = management.search(id);

        if (sport == null) {
            System.out.println("Esporte não encontrado.");
        } else {
            System.out.println(sport);
        }

    }

    private void delete() {
        System.out.println("\nExclusão de esporte..\nQual esporte deseja deletar (digite o id)?");
        List<Sport> sports = management.list();
        for (Sport sport : sports) {
            System.out.println("[" + sport.getId() + "] - " + sport.getName());
        }
        int id = scanner.nextInt("> ");

        if (management.delete(id)) {
            System.out.println("Esporte deletado.");
        } else {
            System.out.println("Esporte não encontrado.");
        }
    }
}
