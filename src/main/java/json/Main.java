package json;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        Car car = new Car("blue", "ford");
        objectMapper.writeValue(new File("src/main/resources/files/car.json"), car);

        String carAsString = objectMapper.writeValueAsString(car);

        System.out.println(carAsString);
        delimiter();

        String json01 = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
        Car carFromJson = objectMapper.readValue(json01, Car.class);
        Car carFromFile = objectMapper.readValue(new File("src/main/resources/files/car.json"), Car.class);
        Car carFromUrl = objectMapper.readValue(new URL("file:src/main/resources/files/car.json"), Car.class);

        System.out.println(carFromUrl);
        delimiter();

        String json02 = "{ \"color\" : \"Black\", \"type\" : \"Fiat\" }";
        JsonNode jsonNode = objectMapper.readTree(json02);
        String color = jsonNode.get("color").asText();

        System.out.println(color);
        delimiter();

        String jsonCarArray =
                "[{ \"color\" : \"Black\", \"type\" : \"BMW\" }, { \"color\" : \"Red\", \"type\" : \"FIAT\" }]";
        List<Car> cars = objectMapper.readValue(jsonCarArray, new TypeReference<List<Car>>() {});

        cars.forEach(System.out::println);
        delimiter();

        String jsonMap = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
        Map<String, Object> map = objectMapper.readValue(jsonMap, new TypeReference<Map<String, Object>>() {});

        map.forEach((key, value) -> System.out.println(key + " - " + value));
        delimiter();

        String json03 = "{ \"color\" : \"Black\", \"type\" : \"Fiat\", \"year\" : \"1970\" }";
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Car car1 = objectMapper.readValue(json03, Car.class);

        JsonNode jsonNodeRoot = objectMapper.readTree(json03);
        JsonNode jsonNodeYear = jsonNodeRoot.get("year");
        String year = jsonNodeYear.asText();

        System.out.println(year);
        delimiter();

        SimpleModule moduleSerializer = new SimpleModule("json.CustomCarSerializer",
                new Version(1, 0, 0, null, null, null));
        moduleSerializer.addSerializer(Car.class, new CustomCarSerializer());
        objectMapper.registerModule(moduleSerializer);
        Car car2 = new Car("yellow", "renault");
        String car2Json = objectMapper.writeValueAsString(car2);

        System.out.println(car2Json);
        delimiter();

        String json04 = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
        SimpleModule moduleDeserializer = new SimpleModule("json.CustomCarDeserializer",
                new Version(1, 0, 0, null, null, null));
        moduleDeserializer.addDeserializer(Car.class, new CustomCarDeserializer());
        objectMapper.registerModule(moduleDeserializer);
        Car car3 = objectMapper.readValue(json04, Car.class);

        System.out.println(car3);
        delimiter();

        Request request = new Request(car, new Date());
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm a z");
        objectMapper.setDateFormat(dateFormat);
        String requestAsString = objectMapper.writeValueAsString(request);

        System.out.println(requestAsString);
        delimiter();

        objectMapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);
        Car[] carArray = objectMapper.readValue(jsonCarArray, Car[].class);

        Arrays.stream(carArray).forEach(System.out::println);
        delimiter();

        List<Car> carList = objectMapper.readValue(jsonCarArray, new TypeReference<List<Car>>() {});

        carList.forEach(System.out::println);
        delimiter();
    }

    private static void delimiter() {
        System.out.println("-".repeat(20));
    }
}
