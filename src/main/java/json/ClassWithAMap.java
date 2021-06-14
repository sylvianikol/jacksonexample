package json;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.HashMap;
import java.util.Map;

public class ClassWithAMap {

    @JsonSerialize(using = MyPairSerializer.class)
    private Map<MyPair, String> map;

    public ClassWithAMap() {
        this.map = new HashMap<>();
    }

    public Map<MyPair, String> getMap() {
        return map;
    }

    public void setMap(Map<MyPair, String> map) {
        this.map = map;
    }
}
