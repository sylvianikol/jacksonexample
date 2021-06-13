import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

class ItemWithMixinTest {

    @Test
    void test_serializeUsingMixInAnnotation() throws JsonProcessingException {

        ItemWithMixin item = new ItemWithMixin(1, "book", null);

        String result = new ObjectMapper().writeValueAsString(item);
        assertThat(result, containsString("owner"));

        ObjectMapper mapper = new ObjectMapper();
        mapper.addMixIn(User.class, MyMixInForIgnoreType.class);

        result = mapper.writeValueAsString(item);
        assertThat(result, not(containsString("owner")));
    }
}