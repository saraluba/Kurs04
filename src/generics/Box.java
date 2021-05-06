package generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Box<T> {
    List<T> listofT;
    T item;

    public Box(){
        this.listofT = new ArrayList<>();
    }

    public void addItem(T item){
        listofT.add(item);
    }

    public Collection<T> getItems(){
        return listofT;
    }
}
