import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;

import static org.junit.Assert.assertThat;

class MyDtoTest {

    @Test
    public void test_fieldIsIgnoredOnClassLevel() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        MyDto dto = new MyDto();

        String dtoAsString = mapper.writeValueAsString(dto);

        assertThat(dtoAsString, not(containsString("intValue")));
    }

    @Test
    public void test_fieldIsIgnoredDirectly() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        MyDto dto = new MyDto();

        String dtoAsString = mapper.writeValueAsString(dto);

        assertThat(dtoAsString, not(containsString("stringValue")));
    }
}