package json;

import com.fasterxml.jackson.annotation.JsonRawValue;

public class RawBean {

    private String name;
    @JsonRawValue
    private String json;

    public RawBean() {
    }

    public RawBean(String name, String json) {
        this.name = name;
        this.json = json;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }
}
