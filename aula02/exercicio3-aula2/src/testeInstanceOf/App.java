package testeInstanceOf;

import java.util.ArrayList;

public class App {

    public static void main(String[] args) {

        ArrayList<Animal> AnimalList = new ArrayList<Animal>();

        Dog dog = new Dog();
        Gato gato = new Gato();

        AnimalList.add(dog);
        AnimalList.add(gato);
        AnimalList.get(0).noise();
        AnimalList.get(1).noise();



    }
}
