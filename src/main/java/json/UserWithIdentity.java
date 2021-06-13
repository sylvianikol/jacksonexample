package json;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.ArrayList;
import java.util.List;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class UserWithIdentity {

    private int id;
    private String name;
    private List<ItemWithIdentity> userItems;

    public UserWithIdentity() {
        this.userItems = new ArrayList<>();
    }

    public UserWithIdentity(int id, String name) {
        this();
        this.id = id;
        this.name = name;
    }

    public void addItem(ItemWithIdentity item) {
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

    public List<ItemWithIdentity> getUserItems() {
        return userItems;
    }

    public void setUserItems(List<ItemWithIdentity> userItems) {
        this.userItems = userItems;
    }
}
