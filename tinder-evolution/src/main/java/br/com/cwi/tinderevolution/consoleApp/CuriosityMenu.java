package br.com.cwi.tinderevolution.consoleApp;

import br.com.cwi.tinderevolution.domain.curiosity.Curiosity;
import br.com.cwi.tinderevolution.domain.curiosity.CuriosityCategories;
import br.com.cwi.tinderevolution.management.CuriosityManagement;

import java.util.List;

public class CuriosityMenu {

    private CuriosityManagement management;
    private CustomScanner scanner;

    public CuriosityMenu() {
        this.management = new CuriosityManagement();
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

    public Curiosity info() {

        String description = scanner.nextLine("Descrição: ");
        System.out.println("Categoria:");
        int cont = 1;
        for (CuriosityCategories categorie : CuriosityCategories.values()) {
            System.out.println("[" + cont + "] " + categorie.getDescription());
            cont++;
        }
        int curiosityOption = scanner.nextInt("> ");
        CuriosityCategories curiosityCategorie = null;

        switch(curiosityOption){
            case 1:
                curiosityCategorie = CuriosityCategories.ALIMENTACAO;
                break;
            case 2:
                curiosityCategorie = CuriosityCategories.APARENCIA;
                break;
            case 3:
                curiosityCategorie = CuriosityCategories.COMPORTAMENTO;
                break;
            case 4:
                curiosityCategorie = CuriosityCategories.EVENTO;
                break;
        }

        return new Curiosity(description, curiosityCategorie);
    }

    public Curiosity create() {
        System.out.println("Criação de curiosidade..");
        Curiosity curiosity = info();
        Curiosity sportCreated = management.create(curiosity);

        return sportCreated;
    }

    public List<Curiosity> list() {
        System.out.println("Lista de esportes..");
        List<Curiosity> curiosities = management.list();
        for (Curiosity m : curiosities) {
            System.out.println(m);
        }
        return curiosities;
    }

    public Curiosity edit() {
        System.out.println("\nEditar curiosidade..\nQual curiosidade deseja editar?");


        List<Curiosity> curiosities = management.list();
        for (Curiosity m : curiosities) {
            System.out.println("[" + m.getId() + "] - " + m.getDescription());
        }

        int id = scanner.nextInt("> ");
        if (management.search(id) == null) {
            System.out.println("Curiosidade não encontrada.");
            return null;
        }
        Curiosity curiosity = info();

        Curiosity sportUpdated = management.edit(id, curiosity);

        return sportUpdated;
    }

    public void search() {
        int id = scanner.nextInt("Pesquisa de curiosidade..\nQual o id do curiosidade?\n> ");
        Curiosity curiosity = management.search(id);

        if (curiosity == null) {
            System.out.println("Curiosidade não encontrada.");
        } else {
            System.out.println(curiosity);
        }

    }

    private void delete() {
        System.out.println("\nExclusão de curiosidade..\nQual curiosidade deseja deletar (digite o id)?");
        List<Curiosity> curiosities = management.list();
        for (Curiosity curiosity : curiosities) {
            System.out.println("[" + curiosity.getId() + "] - " + curiosity.getDescription());
        }
        int id = scanner.nextInt("> ");

        if (management.delete(id)) {
            System.out.println("Curiosidade deletada.");
        } else {
            System.out.println("Curiosidade não encontrada.");
        }
    }

}
