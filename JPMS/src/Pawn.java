import java.util.Calendar;
import java.time.LocalDate;
import java.time.Period;
import javax.swing.ImageIcon;
public abstract class Pawn extends Item implements Redeem, SendInterest{
    private int due_date;
    private int due_month;
    private int due_year;
    private int date;
    private int month;
    private int year;
    private double interest;

    public Pawn() {
       this(0, "", 0.0, null);
    }
    
    public Pawn(int ID, String name, double value) {
        super(ID, name, value);
        Calendar d = Calendar.getInstance();
        //oldtime
        this.date = d.get(Calendar.DATE);
        this.month = d.get(Calendar.MONTH);
        this.year = d.get(Calendar.YEAR);
        d.add(Calendar.MONTH, 5);
        // Add 5 months
        this.due_date = d.get(Calendar.DATE);
        this.due_month = d.get(Calendar.MONTH);
        this.due_year = d.get(Calendar.YEAR);
        if(value > 2000){
            this.interest = 1.25;
        }else{
            this.interest = 2;
        }
    }
    public Pawn(int ID, String name, double value, ImageIcon image) {
        super(ID, name, value, image);
        Calendar d = Calendar.getInstance();
        //oldtime
        this.date = d.get(Calendar.DATE);
        this.month = d.get(Calendar.MONTH);
        this.year = d.get(Calendar.YEAR);
        d.add(Calendar.MONTH, 5); // Add 5 months
        this.due_date = d.get(Calendar.DATE);
        this.due_month = d.get(Calendar.MONTH);
        this.due_year = d.get(Calendar.YEAR);
        if(value > 2000){
            this.interest = 1.25;
        }else{
            this.interest = 2;
        }
    }
    @Override
    public double Sell(){
        return  this.getValue() + this.InterestPrice();
    }
    public void SendInterest(){
        System.out.println(this.getName());
        Calendar d = Calendar.getInstance();
        d.add(Calendar.MONTH, 5); // Add 5 months
        this.due_date = d.get(Calendar.DATE);
        this.due_month = d.get(Calendar.MONTH);
        this.due_year = d.get(Calendar.YEAR);
    }
    public int monthTime(){
        Calendar d = Calendar.getInstance();
        LocalDate nowTime = LocalDate.of(d.get(Calendar.YEAR), d.get(Calendar.MONTH), d.get(Calendar.DATE));
//        LocalDate dueTime = LocalDate.of(due_year, due_month, due_date);
        LocalDate Time = LocalDate.of(year, month, date);
        
        Period period = Period.between(nowTime, nowTime);
        if (period.getMonths() == 0){
            return 1;
        }else{
            return period.getMonths();
        }
    }
    
    public double InterestPrice(){
        return this.monthTime() * this.getValue() * (this.interest / 100);
    }
    public abstract boolean CheckValue(double d);
    

    public int getDue_date() {
        return due_date;
    }

    public void setDue_date(int due_date) {
        this.due_date = due_date;
    }

    public int getDue_month() {
        return due_month;
    }

    public void setDue_month(int due_month) {
        this.due_month = due_month;
    }

    public int getDue_year() {
        return due_year;
    }

    public void setDue_year(int due_year) {
        this.due_year = due_year;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }
    
    public String getStr_status(){
        return getDue_date() + "/" + getDue_month() + "/" + getDue_year();
    }
    public void setTest(int year, int  month, int date){
        this.due_date = date;
        this.due_month = month;
        this.due_year = year;
    }
}
