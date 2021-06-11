import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        Car car = new Car("blue", "ford");
        objectMapper.writeValue(new File("src/main/resources/files/car.json"), car);

        
    }
}
