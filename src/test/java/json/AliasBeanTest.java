package json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import json.AliasBean;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AliasBeanTest {

    @Test
    void test_deserializeUsingJsonAlias() throws JsonProcessingException {

        String json = "{\"fName\": \"John\", \"lastName\": \"Green\"}";

        AliasBean bean = new ObjectMapper()
                .readerFor(AliasBean.class)
                .readValue(json);

        assertEquals("John", bean.getFirstName());
    }
}