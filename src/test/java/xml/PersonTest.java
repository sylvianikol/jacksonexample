package xml;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonTest {

    private static final String XML = "<Person><firstName>Rohan</firstName><lastName>Daye</lastName><phoneNumbers><phoneNumbers>9911034731</phoneNumbers><phoneNumbers>9911033478</phoneNumbers></phoneNumbers><address><streetName>Name1</streetName><city>City1</city></address><address><streetName>Name2</streetName><city>City2</city></address></Person>";

    @Test
    void test_serializeFromXml() throws IOException {

        XmlMapper mapper = new XmlMapper();
        Person person = testData();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        mapper.writeValue(outputStream, person);

        String str = outputStream.toString();

        assertEquals(XML, outputStream.toString());
    }

    private Person testData() {
        List<Address> addresses = new ArrayList<>();
        addresses.add(new Address("Name1", "City1"));
        addresses.add(new Address("Name2", "City2"));

        List<String> phoneNumbers = new ArrayList<>();
        phoneNumbers.add("9911034731");
        phoneNumbers.add("9911033478");

        return new Person("Rohan", "Daye", phoneNumbers, addresses);
    }
}