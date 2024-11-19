package item.base;

public abstract class BaseItem {

    private String name;

    public BaseItem(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        if (name.isBlank()) {
            this.name = "Unnamed Item";
        }
    }

}
