package xml;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.jupiter.api.Test;

import java.io.*;

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

    @Test
    void test_deserializeFromXmlString() throws JsonProcessingException {

        XmlMapper mapper = new XmlMapper();
        SimpleBean bean = mapper.readValue("<SimpleBean><x>1</x><y>2</y></SimpleBean>", SimpleBean.class);

        assertTrue(bean.getX() == 1 && bean.getY() == 2);
    }

    @Test
    void test_deserializeFromXmlFile() throws IOException {

        File file = new File("src/test/resources/files/output.xml");
        XmlMapper mapper = new XmlMapper();

        String xml = inputStreamToString(new FileInputStream(file));

        SimpleBean bean = mapper.readValue(xml, SimpleBean.class);
        assertTrue(bean.getX() == 1 && bean.getY() == 2);
    }

    private String inputStreamToString(InputStream is) throws IOException {

        StringBuilder sb = new StringBuilder();
        String line;

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }

        reader.close();

        return sb.toString();
    }
}