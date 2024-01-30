package ru.ergakov.gb;

import ru.ergakov.gb.models.Person;
import ru.ergakov.gb.services.AppExternalizable;

public class Program {
    public static final String FILE_JSON = "persons.json";
    public static void main(String[] args) {
        Person person1 = new Person("Igor", "Ergakov", 31);
        System.out.println("Создан экземпляр -> " + person1);

        new AppExternalizable().app(FILE_JSON, person1);
    }
}