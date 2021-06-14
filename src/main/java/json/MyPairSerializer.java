package json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.io.StringWriter;

public class MyPairSerializer extends JsonSerializer<MyPair> {

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public void serialize(MyPair myPair, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {

        StringWriter writer = new StringWriter();
        mapper.writeValue(writer, myPair);
        jsonGenerator.writeFieldName(writer.toString());
    }
}
