package service;

import model.User;
import model.UserCollection;

import java.io.File;
import java.io.IOException;
import java.util.Collection;


public interface UserSerializer {

    void serializer (Collection<User> collections, String filename) throws IOException;


}
