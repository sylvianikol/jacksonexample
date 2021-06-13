import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

class TypeEnumWithValueTest {

    @Test
    void test_serializeUsingJsonValue() throws JsonProcessingException {

        String enumAsString = new ObjectMapper().writeValueAsString(TypeEnumWithValue.TYPE1);

        assertThat(enumAsString, is("\"Type A\""));
    }
}