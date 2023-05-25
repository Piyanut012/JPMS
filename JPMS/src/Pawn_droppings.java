
import javax.swing.ImageIcon;


public class Pawn_droppings extends Item{

    public Pawn_droppings() {
    }

    public Pawn_droppings(int ID, String name, double value) {
        super(ID, name, value);
    }

    public Pawn_droppings(int ID, String name, double value, ImageIcon image) {
        super(ID, name, value, image);
    }
    
    @Override
    public double Sell(){
        return this.getValue();
    }
}
