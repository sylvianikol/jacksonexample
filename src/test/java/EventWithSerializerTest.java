import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class EventWithSerializerTest {

    @Test
    void test_serializeUsingJsonSerialize() throws ParseException, JsonProcessingException {

        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

        String toParse = "20-12-2014 02:30:00";
        Date date = df.parse(toParse);

        EventWithSerializer event = new EventWithSerializer("party", date);

        String result = new ObjectMapper().writeValueAsString(event);

        assertThat(result, containsString(toParse));
    }

    @Test
    void test_deserializeUsingJsonAnySetter() throws JsonProcessingException {

        String json = "{\"name\":\"My bean\",\"attr2\":\"val2\",\"attr1\":\"val1\"}";

        ExtendableBean bean = new ObjectMapper()
                .readerFor(ExtendableBean.class)
                .readValue(json);

        assertEquals("My bean", bean.getName());
        assertEquals("val2", bean.getProperties().get("attr2"));
    }
}