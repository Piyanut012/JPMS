
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
    public boolean CheckValue(double d){
        if (d > 50000){
            return true;
        }
        else{
            return false;
        }
    }
}
