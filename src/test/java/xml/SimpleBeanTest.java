package xml;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SimpleBeanTest {

    @Test
    void test_serializeToXmlStr() throws JsonProcessingException {

        XmlMapper mapper = new XmlMapper();
        String xml = mapper.writeValueAsString(new SimpleBean(1, 2));
        assertNotNull(xml);
    }

    @Test
    void test_serializeToXmlFile() throws IOException {

        XmlMapper mapper = new XmlMapper();
        mapper.writeValue(new File("src/test/resources/files/output.xml"), new SimpleBean(1, 2));

        File file = new File("src/test/resources/files/output.xml");
        assertNotNull(file);
    }
}