import com.fasterxml.jackson.annotation.JsonView;

public class Item {

    @JsonView(Views.Public.class)
    private int id;
    @JsonView(Views.Public.class)
    private String itemName;
    @JsonView(Views.Internal.class)
    private String ownerName;

    public Item() {
    }

    public Item(int id, String itemName, String ownerName) {
        this.id = id;
        this.itemName = itemName;
        this.ownerName = ownerName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}
