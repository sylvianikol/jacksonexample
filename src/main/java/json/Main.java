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
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        Car car = new Car("blue", "ford");
        mapper.writeValue(new File("src/main/resources/files/car.json"), car);

        String carAsString = mapper.writeValueAsString(car);

        System.out.println(carAsString);
        delimiter();

        String json01 = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
        Car carFromJson = mapper.readValue(json01, Car.class);
        Car carFromFile = mapper.readValue(new File("src/main/resources/files/car.json"), Car.class);
        Car carFromUrl = mapper.readValue(new URL("file:src/main/resources/files/car.json"), Car.class);

        System.out.println(carFromUrl);
        delimiter();

        String json02 = "{ \"color\" : \"Black\", \"type\" : \"Fiat\" }";
        JsonNode jsonNode = mapper.readTree(json02);
        String color = jsonNode.get("color").asText();

        System.out.println(color);
        delimiter();

        String jsonCarArray =
                "[{ \"color\" : \"Black\", \"type\" : \"BMW\" }, { \"color\" : \"Red\", \"type\" : \"FIAT\" }]";
        List<Car> cars = mapper.readValue(jsonCarArray, new TypeReference<List<Car>>() {});

        cars.forEach(System.out::println);
        delimiter();

        String jsonMap = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
        Map<String, Object> map = mapper.readValue(jsonMap, new TypeReference<Map<String, Object>>() {});

        map.forEach((key, value) -> System.out.println(key + " - " + value));
        delimiter();

        String json03 = "{ \"color\" : \"Black\", \"type\" : \"Fiat\", \"year\" : \"1970\" }";
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Car car1 = mapper.readValue(json03, Car.class);

        JsonNode jsonNodeRoot = mapper.readTree(json03);
        JsonNode jsonNodeYear = jsonNodeRoot.get("year");
        String year = jsonNodeYear.asText();

        System.out.println(year);
        delimiter();

        SimpleModule moduleSerializer = new SimpleModule("json.CustomCarSerializer",
                new Version(1, 0, 0, null, null, null));
        moduleSerializer.addSerializer(Car.class, new CustomCarSerializer());
        mapper.registerModule(moduleSerializer);
        Car car2 = new Car("yellow", "renault");
        String car2Json = mapper.writeValueAsString(car2);

        System.out.println(car2Json);
        delimiter();

        String json04 = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
        SimpleModule moduleDeserializer = new SimpleModule("json.CustomCarDeserializer",
                new Version(1, 0, 0, null, null, null));
        moduleDeserializer.addDeserializer(Car.class, new CustomCarDeserializer());
        mapper.registerModule(moduleDeserializer);
        Car car3 = mapper.readValue(json04, Car.class);

        System.out.println(car3);
        delimiter();

        Request request = new Request(car, new Date());
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm a z");
        mapper.setDateFormat(dateFormat);
        String requestAsString = mapper.writeValueAsString(request);

        System.out.println(requestAsString);
        delimiter();

        mapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);
        Car[] carArray = mapper.readValue(jsonCarArray, Car[].class);

        Arrays.stream(carArray).forEach(System.out::println);
        delimiter();

        List<Car> carList = mapper.readValue(jsonCarArray, new TypeReference<List<Car>>() {});

        carList.forEach(System.out::println);
        delimiter();

        MyPair pair = new MyPair("Abbott", "Costello");
        ClassWithAMap classWithAMap = new ClassWithAMap();
        classWithAMap.getMap().put(pair, "Comedy");

        String jsonResult = mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(classWithAMap.getMap());

        System.out.println(jsonResult);
        delimiter();

        MyPair mapKey = new MyPair("Abbott", "Costello");
        MyPair mapValue = new MyPair("Comedy", "1940s");
        classWithAMap.getPairMap().put(mapKey, mapValue);

        jsonResult = mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(classWithAMap.getPairMap());

        System.out.println(jsonResult);
        delimiter();

        String jsonInput = "{\"key\": \"value\"}";
        TypeReference<HashMap<String, String>> typeRef = new TypeReference<HashMap<String, String>>() {};
        Map<String, String> stringMap = mapper.readValue(jsonInput, typeRef);

        System.out.println(stringMap);
        delimiter();

        jsonInput = "{\"Abbott and Costello\" : \"Comedy\"}";
        TypeReference<HashMap<MyPair, String>> typeRef2 = new TypeReference<HashMap<MyPair, String>>() {};
        Map<MyPair,String> myPairStringMap = mapper.readValue(jsonInput, typeRef2);

        System.out.println(myPairStringMap);
        delimiter();

        classWithAMap = mapper.readValue(jsonInput, ClassWithAMap.class);

        System.out.println(classWithAMap.getMap());
        delimiter();

        jsonInput = "{\"Abbott and Costello\" : \"Comedy and 1940s\"}";
        TypeReference<HashMap<MyPair, MyPair>> typeRef3
                = new TypeReference<HashMap<MyPair, MyPair>>() {};
        Map<MyPair,MyPair> pairMap = mapper.readValue(jsonInput, typeRef3);

        System.out.println(pairMap);
        delimiter();
    }

    private static void delimiter() {
        System.out.println("-".repeat(20));
    }
}
