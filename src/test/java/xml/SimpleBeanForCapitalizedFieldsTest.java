package xml;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SimpleBeanForCapitalizedFieldsTest {

    @Test
    void test_deserializeFromXmlStrWithCapitalElem() throws JsonProcessingException {

        XmlMapper xmlMapper = new XmlMapper();
        SimpleBeanForCapitalizedFields bean = xmlMapper.readValue(
                "<SimpleBeanForCapitalizedFields><X>1</X><y>2</y></SimpleBeanForCapitalizedFields>",
                SimpleBeanForCapitalizedFields.class
        );

        assertTrue(bean.getX() == 1 && bean.getY() == 2);
    }
}