import java.util.Calendar;
import java.time.LocalDate;
import java.time.Period;
import javax.swing.ImageIcon;
public abstract class Pawn extends Item implements Redeem, SendInterest{
    private int date;
    private int month;
    private int year;
    private int nowDate;
    private int nowMonth;
    private int nowYear;
    private double interest;

    public Pawn() {
       this(0, "", 0.0, null);
    }
    
    public Pawn(int ID, String name, double value) {
        super(ID, name, value);
        Calendar d = Calendar.getInstance();
        //oldtime
        this.nowDate = d.get(Calendar.DATE);
        this.nowMonth = d.get(Calendar.MONTH);
        this.nowYear = d.get(Calendar.YEAR);
        d.add(Calendar.MONTH, 5);
        // Add 5 months
        this.date = d.get(Calendar.DATE);
        this.month = d.get(Calendar.MONTH);
        this.year = d.get(Calendar.YEAR);
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
        this.nowDate = d.get(Calendar.DATE);
        this.nowMonth = d.get(Calendar.MONTH);
        this.nowYear = d.get(Calendar.YEAR);
        d.add(Calendar.MONTH, 5); // Add 5 months
        this.date = d.get(Calendar.DATE);
        this.month = d.get(Calendar.MONTH);
        this.year = d.get(Calendar.YEAR);
        if(value > 2000){
            this.interest = 1.25;
        }else{
            this.interest = 2;
        }
    }
    @Override
    public void Sell(){
        System.out.println("Sell Pawn");
    }
    public void SendInterest(){
        System.out.println(this.getName());
        Calendar d = Calendar.getInstance();
        d.add(Calendar.MONTH, 5); // Add 5 months
        this.date = d.get(Calendar.DATE);
        this.month = d.get(Calendar.MONTH);
        this.year = d.get(Calendar.YEAR);
    }
    public int monthTime(){
        Calendar d = Calendar.getInstance();
        LocalDate dueTime = LocalDate.of(year, month, date);
        LocalDate nowTime = LocalDate.of(nowYear, nowMonth, nowDate);
        
        Period period = Period.between(nowTime, dueTime);
        if (period.getMonths() == 0){
            return 1;
        }else{
            return period.getMonths();
        }
    }
    
    public double InterestPrice(){
        return this.getValue() * (this.interest / 100);
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

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }
    
    public String getStr_status(){
        return getDate() + "/" + getMonth() + "/" + getYear();
    }
}
