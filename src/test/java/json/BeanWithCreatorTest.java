package json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import json.BeanWithCreator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BeanWithCreatorTest {

    @Test
    void test_deserializeUsingJsonCreator() throws JsonProcessingException {

        String json = "{ \"id\":1,\"theName\":\"My bean\" }";

        BeanWithCreator bean = new ObjectMapper()
                .readerFor(BeanWithCreator.class)
                .readValue(json);

        assertEquals("My bean", bean.getName());
    }
}