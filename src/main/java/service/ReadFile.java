package service;

import model.User;
import model.UserCollection;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class ReadFile {


    public Collection<User> add (Path path) throws IOException {

        Stream<String> lines = Files.lines(path);
        Collection<User> userArray = new ArrayList<>();
        lines.forEach(s -> {

            List<String> parts = (Arrays.asList(s.split(";")));
            if (parts.size() == 3) {
                try {
                    User user = new User(Integer.valueOf(parts.get(0)), parts.get(1), parts.get(2));
                    userArray.add(user);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        lines.close();
        return userArray;
    }

}
