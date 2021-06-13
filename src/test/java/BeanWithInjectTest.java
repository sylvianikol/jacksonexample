import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BeanWithInjectTest {

    @Test
    void test_deserializeUsingJacksonInject() throws JsonProcessingException {

        String json = "{\"name\":\"My bean\"}";

        InjectableValues inject = new InjectableValues.Std().addValue(int.class, 1);

        BeanWithInject bean = new ObjectMapper().reader(inject)
                .forType(BeanWithInject.class)
                .readValue(json);

        assertEquals("My bean", bean.getName());
        assertEquals(1, bean.getId());
    }
}