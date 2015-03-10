/**
 * Created by esso on 10.03.15.
 */
public class DataPoint {
    private char name;
    private Double value;

    public DataPoint(char name, Double value){
        this.name = name;
        this.value = value;
    }


    public char getName() {
        return name;
    }

    public long getValue() {
        return Math.round(value);
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String toString(){
        return name + " " + value.toString();
    }
}
