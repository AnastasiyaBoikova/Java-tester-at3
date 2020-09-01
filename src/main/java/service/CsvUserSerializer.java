package service;

import com.fasterxml.jackson.databind.ObjectWriter;
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
        CsvSchema schema = csvMapper.schemaFor(User.class).withoutHeader().sortedBy("id","name","email").withLineSeparator("\n").withColumnSeparator(',');
        csvMapper.writer(schema).writeValue(out,collections);

        //ObjectWriter writer = csvMapper.writerFor(User.class).with(schema);
//        for (User user : collections) {
//            writer.writeValue(out,user);
//        }

    }

}
