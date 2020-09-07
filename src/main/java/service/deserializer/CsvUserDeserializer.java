package service.deserializer;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import model.User;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CsvUserDeserializer implements UserDeserializer {


    @Override
    public Collection<User> deserializer(String filename) throws IOException {
        CsvMapper objectMapper = new CsvMapper();
        objectMapper.disable(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY);
        File in = new File(filename);
        CsvSchema columns = objectMapper.schemaFor(User.class).withoutHeader().withLineSeparator("\n").withColumnSeparator(',');
        MappingIterator<User> objectMappingIterator = objectMapper.reader(columns).forType(User.class).readValues(in);
        System.out.println(objectMappingIterator);
        List<User> users = objectMappingIterator.readAll();
        return users;


    }

}
