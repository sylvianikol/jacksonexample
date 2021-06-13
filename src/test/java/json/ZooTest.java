package json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import json.Zoo;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ZooTest {

    @Test
    void test_serializeUsingPolymorphic() throws JsonProcessingException {

        Zoo.Dog dog = new Zoo.Dog("rocky");
        Zoo zoo = new Zoo(dog);

        String result = new ObjectMapper().writeValueAsString(zoo);

        assertThat(result, containsString("type"));
        assertThat(result, containsString("dog"));
    }

    @Test
    void test_deserializeUsingPolymorphic() throws JsonProcessingException {

        String json = "{\"animal\":{\"name\":\"lacy\",\"type\":\"cat\"}}";

        Zoo zoo = new ObjectMapper().readerFor(Zoo.class).readValue(json);

        assertEquals("lacy", zoo.getAnimal().getName());
        assertEquals(Zoo.Cat.class, zoo.getAnimal().getClass());
    }
}