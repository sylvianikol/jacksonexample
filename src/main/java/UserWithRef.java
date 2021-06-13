import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.ArrayList;
import java.util.List;

public class UserWithRef {

    private int id;
    private String name;
    @JsonBackReference
    private List<ItemWithRef> userItems;

    public UserWithRef() {
        this.userItems = new ArrayList<>();
    }

    public UserWithRef(int id, String name) {
        this();
        this.id = id;
        this.name = name;
    }

    public void addItem(ItemWithRef item) {
        userItems.add(item);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ItemWithRef> getUserItems() {
        return userItems;
    }

    public void setUserItems(List<ItemWithRef> userItems) {
        this.userItems = userItems;
    }
}
