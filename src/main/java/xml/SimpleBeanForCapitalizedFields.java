package xml;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SimpleBeanForCapitalizedFields {

    @JsonProperty("X")
    private int x;
    private int y;

    public SimpleBeanForCapitalizedFields() {
    }

    public SimpleBeanForCapitalizedFields(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
