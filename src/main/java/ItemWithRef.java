import com.fasterxml.jackson.annotation.JsonManagedReference;

public class ItemWithRef {

    private int id;
    private String itemName;
    @JsonManagedReference
    private UserWithRef ownerName;

    public ItemWithRef() {
    }

    public ItemWithRef(int id, String itemName, UserWithRef ownerName) {
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

    public UserWithRef getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(UserWithRef ownerName) {
        this.ownerName = ownerName;
    }
}
