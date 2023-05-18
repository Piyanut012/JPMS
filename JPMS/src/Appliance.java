
import javax.swing.ImageIcon;


public class Appliance extends Pawn{

    public Appliance() {
    }

    public Appliance(int ID, String name, double value) {
        super(ID, name, value);
    }

    public Appliance(int ID, String name, double value, ImageIcon image) {
        super(ID, name, value, image);
    }
    
    
    @Override
    public void CheckValue(){
        System.out.println("50000");
    }
}
