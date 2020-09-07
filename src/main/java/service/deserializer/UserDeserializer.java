package service.deserializer;

import model.User;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

public interface UserDeserializer {

    Collection<User> deserializer(String filename) throws IOException;
}
