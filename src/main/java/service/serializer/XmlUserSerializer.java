package service.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import model.User;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

public class XmlUserSerializer implements UserSerializer{


    @Override
    public void serializer(Collection<User> collections, String filename) throws IOException {

        ObjectMapper xmlMapper = new XmlMapper();
        File out = new File(filename);
        xmlMapper.writerFor(Collection.class).writeValue(out, collections);


    }
}
