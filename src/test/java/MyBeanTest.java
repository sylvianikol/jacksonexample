import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

class MyBeanTest {

    @Test
    void test_serializeUsingJsonGetter() throws JsonProcessingException {

        MyBean bean = new MyBean(1, "My bean");

        String result = new ObjectMapper().writeValueAsString(bean);

        assertThat(result, containsString("My bean"));
        assertThat(result, containsString("1"));
    }

    @Test
    void test_serializeUsingJsonPropertyOrder() throws JsonProcessingException {

        MyBean bean = new MyBean(1, "My bean");

        String result = new ObjectMapper().writeValueAsString(bean);

        assertThat(result, containsString("My bean"));
        assertThat(result, containsString("1"));
    }

    @Test
    void test_serializeUsingJsonInclude() throws JsonProcessingException {

        MyBean bean = new MyBean(1, null);

        String result = new ObjectMapper().writeValueAsString(bean);

        assertThat(result, containsString("1"));
        assertThat(result, not(containsString("name")));
    }

    @Test
    void test_disableAllAnnotations() throws JsonProcessingException {

        MyBean bean = new MyBean(1, null);

        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(MapperFeature.USE_ANNOTATIONS);

        String result = mapper.writeValueAsString(bean);

        assertThat(result, containsString("1"));
        assertThat(result, containsString("name"));
    }
}