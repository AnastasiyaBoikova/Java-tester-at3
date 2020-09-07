package service.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.User;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

public class JsonUserSerializer implements UserSerializer {


    @Override
    public void serializer(Collection<User> collections, String filename) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        File out = new File(filename);
        objectMapper.writerFor(User.class).writeValue(out, collections);


    }
}
