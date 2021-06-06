package generics;

public class BoxDemo {
    public static void main(String[] args) {
        Box<Integer> integerBox = new Box();
        integerBox.addItem(2);
        integerBox.addItem(5);
        integerBox.addItem(7);
        System.out.println(integerBox.getItems());
        Box<String> stringBox = new Box();
        stringBox.addItem("Hello");
        stringBox.addItem("world");
        System.out.println(stringBox.getItems());
        System.out.println("====================");
        Box<Toy> toyBox = new Box<>();
        Box<Food> foodBox = new Box<>();
        Box<Book> bookBox = new Box<>();
        Box<Fantasy> fantasyBox = new Box<>();
        Shelf<Toy> toyShelf = new Shelf<>();
        toyShelf.addBox(toyBox);
        Shelf<Book> bookShelf = new Shelf<>();
        bookShelf.addBox(fantasyBox);
        Shelf<Item> itemShelf = new Shelf<>();
        itemShelf.addBox(toyBox);
        itemShelf.addBox(foodBox);
        itemShelf.addBox(fantasyBox);
        itemShelf.addBox(bookBox);
        System.out.println(itemShelf.getBoxList());

    }
}
