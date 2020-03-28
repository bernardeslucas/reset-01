package consoleApp;

import management.UserManagement;
import objects.User;

import java.time.LocalDate;
import java.util.List;

public class UserMenu {

    private UserManagement management;
    private CustomScanner scanner;

    protected UserMenu() {
        this.management = new UserManagement();
        this.scanner = new CustomScanner();
    }

    protected void options() {

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

    private User info(){
        String name = scanner.nextLine("Nome: ");
        String birthDate = scanner.nextLine("Data de nascimento (yyyy-MM-dd): \"");
        String email = scanner.nextLine("E-mail: ");
        String phone = scanner.nextLine("Telefone: ");
        String bio = scanner.nextLine("Bio: ");
        double latitude = scanner.nextDouble("Localização..\nLatitude: ");
        double longitude = scanner.nextDouble("Longitude: ");

        User user = new User(name, email, phone, LocalDate.parse(birthDate), bio, latitude, longitude);
        return user;
    }

    private User create() {

        System.out.println("Cadastro de usuário..");

        User userInfo = info();
        User userCreated = management.create(userInfo);

        return userCreated;
    }

    private User edit() {
        System.out.println("Editar usuário..\nQual usuário deseja editar?");
        List<User> listUsers = management.list();
        for (User u : listUsers) {
            System.out.println("[" + u.getId() + "] - " + u.getName());
        }
        int id = scanner.nextInt(">");

        User userInfo = info();
        User userUpdated = management.edit(id, userInfo);

        return userUpdated;

    }

    private List<User> list() {
        System.out.println("Lista de usuários..");
        List<User> users = management.list();
        for (User u : users) {
            System.out.println(u);
        }
        return users;
    }

    private void search() {
        System.out.println("Pesquisa de Usuário..\nQual o id do usuário?");
        int id = scanner.nextInt(">");

        User user = management.search(id);

        if (user == null) {
            System.out.println("Usuário não encontrado.");
        } else {
            System.out.println(user);
        }
    }

    private void delete() {
        System.out.println("Exclusão de usuário..\nQual o id do usuário");
        List<User> listUsers = management.list();
        for (User u : listUsers) {
            System.out.println("[" + u.getId() + "] - " + u.getName());
        }
        int id = scanner.nextInt(">");

        if (management.delete(id)) {
            System.out.println("Usuário deletado.");
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }

}
