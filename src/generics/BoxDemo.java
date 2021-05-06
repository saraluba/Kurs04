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
    }
}
