package consoleApp;

import management.UserManagement;
import objects.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class UserMenu {

    private UserManagement management;

    public UserMenu(UserManagement management) {
        this.management = management;
    }

    public void options() {
        Scanner teclado = new Scanner(System.in);
        int option = 0;

        while (option != 6) {
            System.out.println("\nSelecione uma opção:");
            System.out.println("[1] Criar");
            System.out.println("[2] Editar");
            System.out.println("[3] Listar");
            System.out.println("[4] Procurar");
            System.out.println("[5] Deletar");
            System.out.println("[6] Voltar");
            System.out.print("> ");
            option = teclado.nextInt();

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

    public User create(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Cadastro de usuário..");

        System.out.print("Nome: ");
        String name = teclado.nextLine();
        System.out.print("Data de nascimento (yyyy-MM-dd): ");
        String birthDate = teclado.nextLine();
        System.out.print("E-mail: ");
        String email = teclado.nextLine();
        System.out.print("Telefone:");
        String phone = teclado.nextLine();
        System.out.print("Bio:");
        String bio = teclado.nextLine();
        System.out.print("Localização..\nLatitude: ");
        double latitude = teclado.nextDouble();
        System.out.print("Longitude: ");
        double longitude = teclado.nextDouble();

        User userCreated = management.create(new User(name, email, phone, LocalDate.parse(birthDate),bio,latitude,longitude));
        return userCreated;

}

public List<User> list(){
    System.out.println("Lista de usuários..");
    List<User> users = management.list();
    for(User u :)
}





}
