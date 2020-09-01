package service;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import model.User;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class CsvUserDeserializer implements UserDeserializer {


    @Override
    public Collection<User> deserializer(String filename) throws IOException {
        CsvMapper objectMapper = new CsvMapper();
        File in = new File(filename);
       // CsvSchema schema = CsvSchema.emptySchema().withoutHeader();
        objectMapper.schemaFor(User.class).withoutHeader().withLineSeparator("\n").withColumnSeparator(',');
        Object o = objectMapper.readerFor(Collection.class).readValue(in);


//        for (User user : it) {
//            it.add();

        Collection<User> userCollection = (ArrayList<User>) o;
        System.out.println(userCollection);

        return userCollection;
    }

}
