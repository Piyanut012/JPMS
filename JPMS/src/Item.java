
import javax.swing.*;
import java.io.*;

public abstract class Item implements Serializable{
    private int ID;
    private String name;
    private double value;
    private ImageIcon image;
    
    public Item(){
        this(0, "", 0.0, null);
    }
    
    public Item(int ID, String name, double value) {
        this.ID = ID;
        this.name = name;
        this.value = value;
        this.image = null;

    }
    public Item(int ID, String name, double value, ImageIcon image) {
        this.ID = ID;
        this.name = name;
        this.value = value;
        this.image = image;

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }
    
    public abstract double Sell();
    
}
