package service;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import model.User;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

public class CsvUserSerializer implements UserSerializer {

    @Override
    public void serializer(Collection<User> collections, String filename) throws IOException {

        CsvMapper csvMapper = new CsvMapper();
        File out = new File(filename);
        csvMapper.writerFor(Collection.class).writeValue(out, collections);
        CsvSchema schema = csvMapper.schemaFor(Collection.class).withoutHeader().withLineSeparator("\n").withColumnSeparator(';');


    }

}
