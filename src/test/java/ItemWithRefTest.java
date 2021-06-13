import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

class ItemWithRefTest {

    @Test
    void test_serializeUsingJacksonReferenceAnnotation() throws JsonProcessingException {

        UserWithRef user = new UserWithRef(1, "John");
        ItemWithRef item = new ItemWithRef(2, "book", user);
        user.addItem(item);

        String result = new ObjectMapper().writeValueAsString(item);

        assertThat(result, containsString("book"));
        assertThat(result, containsString("John"));
        assertThat(result, not(containsString("userItems")));

    }

}