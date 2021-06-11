import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        Car car = new Car("blue", "ford");
        objectMapper.writeValue(new File("src/main/resources/files/car.json"), car);

        String carAsString = objectMapper.writeValueAsString(car);

        System.out.println(carAsString);

        String json = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
        Car car1 = objectMapper.readValue(json, Car.class);

        System.out.println(car1);
    }
}
