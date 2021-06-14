package json;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.MapSerializer;

import java.util.HashMap;
import java.util.Map;

public class ClassWithAMap {

    @JsonSerialize(using = MyPairSerializer.class)
    private Map<MyPair, String> map;
    @JsonSerialize(keyUsing = MapSerializer.class)
    private Map<MyPair, MyPair> pairMap;
    @JsonSerialize(keyUsing = MyPairSerializer.class)
    private MyPair mapKey;
    @JsonSerialize(keyUsing = MyPairSerializer.class)
    private MyPair mapValue;

    public ClassWithAMap() {
        this.map = new HashMap<>();
        this.pairMap = new HashMap<>();
    }

    public Map<MyPair, String> getMap() {
        return map;
    }

    public void setMap(Map<MyPair, String> map) {
        this.map = map;
    }

    public Map<MyPair, MyPair> getPairMap() {
        return pairMap;
    }

    public void setPairMap(Map<MyPair, MyPair> pairMap) {
        this.pairMap = pairMap;
    }

    public MyPair getMapKey() {
        return mapKey;
    }

    public void setMapKey(MyPair mapKey) {
        this.mapKey = mapKey;
    }

    public MyPair getMapValue() {
        return mapValue;
    }

    public void setMapValue(MyPair mapValue) {
        this.mapValue = mapValue;
    }
}
