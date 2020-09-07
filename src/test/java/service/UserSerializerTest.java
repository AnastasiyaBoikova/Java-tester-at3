package service;

import model.User;
import org.junit.jupiter.api.Assertions;
import service.deserializer.CsvUserDeserializer;
import service.deserializer.JsonUserDeserializer;
import service.serializer.CsvUserSerializer;
import service.serializer.JsonUserSerializer;
import service.serializer.XmlUserSerializer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;


class UserSerializerTest {

    @org.junit.jupiter.api.Test
    void jsonSerializer() throws IOException {

        JsonUserSerializer jsonUserSerializer = new JsonUserSerializer();
        Path path = Paths.get("primary.txt");
        ReadFile readFile = new ReadFile();
        Collection<User> userPrimary = readFile.add(path);
        jsonUserSerializer.serializer(userPrimary, "User.json");
        Assertions.assertTrue(new File("User.json").exists());
        Assertions.assertTrue(new File("User.json").length()!=0);
        //Assertions.assertNotNull();


    }

    @org.junit.jupiter.api.Test
    void xmlSerializer() throws IOException {

        XmlUserSerializer XmlUserSerializer = new XmlUserSerializer();
        Path path = Paths.get("primary.txt");
        ReadFile readFile = new ReadFile();
        Collection<User> userPrimary = readFile.add(path);
        XmlUserSerializer.serializer(userPrimary, "User.xml");
        Assertions.assertTrue(new File("User.xml").exists());
        Assertions.assertTrue(new File("User.xml").length()!=0);



    }

    @org.junit.jupiter.api.Test
    void csvSerializer() throws IOException {

        CsvUserSerializer csvUserSerializer = new CsvUserSerializer();
        Path path = Paths.get("primary.txt");
        ReadFile readFile = new ReadFile();
        Collection<User> userPrimary = readFile.add(path);
        csvUserSerializer.serializer( userPrimary,"User.csv");

        Assertions.assertTrue(new File("User.csv").exists());
        Assertions.assertTrue(new File("User.csv").length()!=0);



    }


    @org.junit.jupiter.api.Test
    void deserializer() throws IOException {
        JsonUserDeserializer jsonUserDeserializer = new JsonUserDeserializer();
        Collection<User> userDeserializer = jsonUserDeserializer.deserializer("User.json");
        Path path = Paths.get("primary.txt");
        ReadFile readFile = new ReadFile();
        Collection<User> userPrimary = readFile.add(path);
        Assertions.assertEquals(userDeserializer.size(),userPrimary.size());


    }

    @org.junit.jupiter.api.Test
    void csvDeserializer() throws IOException {
        Path path = Paths.get("User.csv");
//        List<String> strings = Files.readAllLines(path);
//        System.out.println(strings);
        CsvUserDeserializer csvUserDeserializer = new CsvUserDeserializer();

        Collection<User> userDeserializer = csvUserDeserializer.deserializer("User.csv");

       // System.out.println(userDeserializer);

       // Assertions.assertTrue(userDeserializer.size()==3);



    }

}