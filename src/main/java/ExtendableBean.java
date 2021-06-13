import com.fasterxml.jackson.annotation.JsonAnyGetter;

import java.util.HashMap;
import java.util.Map;

public class ExtendableBean {

    private String name;
    private Map<String, String> properties;

    public ExtendableBean() {
        this.properties = new HashMap<>();
    }

    public ExtendableBean(String name) {
        this();
        this.name = name;
    }

    public void add(String attr, String value) {
        properties.put(attr, value);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonAnyGetter
    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }
}
