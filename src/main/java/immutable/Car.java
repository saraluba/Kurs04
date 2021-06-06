package immutable;

import java.util.ArrayList;
import java.util.List;

public class Car { //don't provide setter methods
    private final String manufacturer; //make all fields final and private
    private final String model;
    private final Engine engine;
    private final List<Wheel> wheels;

    private Car(String manufacturer, String model, Engine engine, List<Wheel> wheels){ //don't allow subclasses to override methods
        this.manufacturer = manufacturer;
        this.model = model;
        this.engine = engine;
        this.wheels = wheels;
    }

    public static Car createCar(String manufacturer, String model, Engine engine, List<Wheel> wheels){
        return new Car(manufacturer, model, engine, wheels);
    }

    private Engine engineCopy(Engine engineToCopy){ //create copy of mutable object
        return new Engine(engineToCopy.getType(), engineToCopy.getHorsePower(), engineToCopy.getVolume());
    }

    private Wheel wheelCopy(Wheel wheelToCopy){
        return new Wheel(wheelToCopy.getRadius(), wheelToCopy.getWidth());
    }

    public List<Wheel> getWheels(){
        List<Wheel> wheelsCopy = new ArrayList<>();
        for (int i = 0; i < wheels.size(); i++) {
            wheelsCopy.add(wheelCopy(wheels.get(i)));
        }
        return wheelsCopy;
    }

    public Engine getEngine(){
        return engineCopy(engine);
    }
}
