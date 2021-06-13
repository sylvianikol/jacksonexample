package json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import json.BeanWithFilter;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

class BeanWithFilterTest {

    @Test
    void test_serializeUsingJsonFilter() throws JsonProcessingException {

        BeanWithFilter bean = new BeanWithFilter(1, "My bean");

        FilterProvider filters = new SimpleFilterProvider().addFilter(
                "myFilter", SimpleBeanPropertyFilter.filterOutAllExcept("name")
        );

        String result = new ObjectMapper()
                .writer(filters)
                .writeValueAsString(bean);

        assertThat(result, containsString("My bean"));
        assertThat(result, not(containsString("id")));
    }
}