package immutable;

//mutable class
public class Engine {
    String type;
    int horsePower;
    int volume;

    public Engine(String type, int horsePower, int volume){
        this.type = type;
        this.horsePower = horsePower;
        this.volume = volume;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public int getVolume() {
        return volume;
    }

    public String getType() {
        return type;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}

