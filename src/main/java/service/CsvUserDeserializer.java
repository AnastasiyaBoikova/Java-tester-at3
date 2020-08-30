package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import model.User;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class CsvUserDeserializer implements UserDeserializer {


    @Override
    public Collection<User> deserializer(String filename) throws IOException {
        ObjectMapper objectMapper = new CsvMapper();
        File in = new File(filename);
        Object o = objectMapper.readerFor(Collection.class).readValue(in);
        Collection<User> userCollection = (ArrayList<User>)o;

        return userCollection;
    }
}
