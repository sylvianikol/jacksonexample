package xml;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SimpleBeanForCapitalizedFieldsTest {

    @Test
    void test_deserializeFromXmlStrWithCapitalElem() throws JsonProcessingException {

        XmlMapper mapper = new XmlMapper();
        SimpleBeanForCapitalizedFields bean = mapper.readValue(
                "<SimpleBeanForCapitalizedFields><X>1</X><y>2</y></SimpleBeanForCapitalizedFields>",
                SimpleBeanForCapitalizedFields.class
        );

        assertTrue(bean.getX() == 1 && bean.getY() == 2);
    }

    @Test
    void test_serializeToXmlFileWithCapitalizedField() throws IOException {

        XmlMapper mapper = new XmlMapper();
        mapper.writeValue(
                new File("src/test/resources/files/output.xml"),
                new SimpleBeanForCapitalizedFields(1, 2)
        );

        File file = new File("src/test/resources/files/output.xml");
        assertNotNull(file);
    }
}