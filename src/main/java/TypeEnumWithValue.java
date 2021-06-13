import com.fasterxml.jackson.annotation.JsonValue;

public enum TypeEnumWithValue {

    TYPE1(1, "Type A"),
    TYPE2(2, "Type B");

    private int id;
    private String name;

    TypeEnumWithValue(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    @JsonValue
    public String getName() {
        return name;
    }
}
