import java.util.Calendar;
import javax.swing.ImageIcon;
public abstract class Pawn extends Item implements Redeem, SendInterest{
    private int date;
    private int month;
    private int year;

    public Pawn() {
       this(0, "", 0.0, null);
    }

    public Pawn(int ID, String name, double value, ImageIcon image) {
        super(ID, name, value, image);
        Calendar d = Calendar.getInstance();
        this.date = d.get(Calendar.DATE);
        this.month = d.get(Calendar.MONTH);
        this.year = d.get(Calendar.YEAR);
    }
    @Override
    public void Sell(){
        System.out.println("Sell Pawn");
    }
    public void SendInterest(){
        Calendar d = Calendar.getInstance();
        this.date = d.get(Calendar.DATE);
        this.month = d.get(Calendar.MONTH);
        this.year = d.get(Calendar.YEAR);
    }
    public abstract void CheckValue();
    

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
}
