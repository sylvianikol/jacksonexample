import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        Car car = new Car("blue", "ford");
        objectMapper.writeValue(new File("src/main/resources/files/car.json"), car);

        String carAsString = objectMapper.writeValueAsString(car);

        System.out.println(carAsString);

        String jsonBmw = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
        Car carFromJson = objectMapper.readValue(jsonBmw, Car.class);
        Car carFromFile = objectMapper.readValue(new File("src/main/resources/files/car.json"), Car.class);
        Car carFromUrl = objectMapper.readValue(new URL("file:src/main/resources/files/car.json"), Car.class);

        System.out.println(carFromUrl);

        String jsonFiat = "{ \"color\" : \"Black\", \"type\" : \"Fiat\" }";
        JsonNode jsonNode = objectMapper.readTree(jsonFiat);
        String color = jsonNode.get("color").asText();

        System.out.println(color);
    }
}
