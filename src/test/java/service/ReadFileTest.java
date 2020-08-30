package service;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class ReadFileTest {

    @Test
    void add() throws IOException {

        Path path = Paths.get("primary.txt");
        ReadFile readFile = new ReadFile();

        System.out.println(readFile.add(path));




    }
}