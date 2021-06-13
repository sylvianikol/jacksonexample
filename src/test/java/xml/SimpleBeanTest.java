package xml;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleBeanTest {

    @Test
    void test_serializeToXmlStr() throws JsonProcessingException {

        XmlMapper mapper = new XmlMapper();
        String xml = mapper.writeValueAsString(new SimpleBean(1, 2));
        assertNotNull(xml);
    }
}