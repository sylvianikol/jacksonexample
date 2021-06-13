import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void test_serializeUsingJsonView() throws JsonProcessingException {

        Item item = new Item(2, "book", "John");

        String result = new ObjectMapper()
                .writerWithView(Views.Public.class)
                .writeValueAsString(item);

        assertThat(result, containsString("book"));
        assertThat(result, containsString("2"));
        assertThat(result, not(containsString("John")));
    }
}