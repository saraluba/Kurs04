package generics;

import java.util.ArrayList;
import java.util.List;

public class Shelf<I> {
    Item I;
    List<Box> boxList;

    public Shelf(){
        this.boxList = new ArrayList<>();
    }

    public void addBox(Box<? extends I> box){
        boxList.add(box);
    }

    public List<Box> getBoxList(){
        return boxList;
    }
}
