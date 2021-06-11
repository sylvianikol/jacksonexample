import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        Car car = new Car("blue", "ford");
        objectMapper.writeValue(new File("src/main/resources/files/car.json"), car);

        String carAsString = objectMapper.writeValueAsString(car);

        System.out.println(carAsString);
        System.out.println("-".repeat(20));

        String jsonBmw = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
        Car carFromJson = objectMapper.readValue(jsonBmw, Car.class);
        Car carFromFile = objectMapper.readValue(new File("src/main/resources/files/car.json"), Car.class);
        Car carFromUrl = objectMapper.readValue(new URL("file:src/main/resources/files/car.json"), Car.class);

        System.out.println(carFromUrl);
        System.out.println("-".repeat(20));

        String jsonFiat = "{ \"color\" : \"Black\", \"type\" : \"Fiat\" }";
        JsonNode jsonNode = objectMapper.readTree(jsonFiat);
        String color = jsonNode.get("color").asText();

        System.out.println(color);
        System.out.println("-".repeat(20));

        String jsonCarArray =
                "[{ \"color\" : \"Black\", \"type\" : \"BMW\" }, { \"color\" : \"Red\", \"type\" : \"FIAT\" }]";
        List<Car> cars = objectMapper.readValue(jsonCarArray, new TypeReference<List<Car>>() {});

        cars.forEach(System.out::println);
        System.out.println("-".repeat(20));

        String jsonMap = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
        Map<String, Object> map = objectMapper.readValue(jsonMap, new TypeReference<Map<String, Object>>() {});

        map.forEach((key, value) -> System.out.println(key + " - " + value));
        System.out.println("-".repeat(20));

        String jsonString = "{ \"color\" : \"Black\", \"type\" : \"Fiat\", \"year\" : \"1970\" }";
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Car car1 = objectMapper.readValue(jsonString, Car.class);

        JsonNode jsonNodeRoot = objectMapper.readTree(jsonString);
        JsonNode jsonNodeYear = jsonNodeRoot.get("year");
        String year = jsonNodeYear.asText();

        System.out.println(year);
        System.out.println("-".repeat(20));
    }
}
