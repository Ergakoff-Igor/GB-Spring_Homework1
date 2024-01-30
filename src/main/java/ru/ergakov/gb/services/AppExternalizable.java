package ru.ergakov.gb.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import ru.ergakov.gb.models.Person;

import java.io.*;


public class AppExternalizable {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public void app(String FILE_JSON, Person person) {


        try {
            // Сериализация в файл 'students.json'
            objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            objectMapper.writeValue(new File(FILE_JSON), person);
            System.out.println("Сериализация в файл 'persons.json' выполнена успешно!");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        try {
            // Десериализация из файла 'students.json'
            File fileJSON = new File(FILE_JSON);
            person = objectMapper.readValue(fileJSON, Person.class);
            System.out.println("Десериализация из файла 'persons.json' выполнена успешно!");
            System.out.println(person);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
