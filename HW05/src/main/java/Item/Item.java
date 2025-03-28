package Item;

abstract public class Item {
    final String title;

    public Item(String title) {
        this.title = title;
        System.out.println("Item constructor called.");
    }

    public abstract void borrow();

    public abstract void returnItem();

    public abstract Item getItemDetails();

    public final String getIdentifier() {
        return "Item Identifier: " + title;
    }

    public final String getTitle() {
        return title;
    }
}

