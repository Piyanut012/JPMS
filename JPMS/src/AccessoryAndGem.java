
import javax.swing.ImageIcon;

public class AccessoryAndGem extends Pawn{

    public AccessoryAndGem() {
    }

    public AccessoryAndGem(int ID, String name, double value) {
        super(ID, name, value);
    }

    public AccessoryAndGem(int ID, String name, double value, ImageIcon image) {
        super(ID, name, value, image);
    }
    
    
    @Override
    public void CheckValue(){
        System.out.println("100000");
    }
}
