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
    private String category;

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    
    @Override
    public double Sell(){
        return  this.getValue() + this.InterestPrice();
    }
    @Override
    public void SendInterest_complete(){
        Calendar d = Calendar.getInstance();
        //oldtime
        this.date = d.get(Calendar.DATE);
        this.month = d.get(Calendar.MONTH);
        this.year = d.get(Calendar.YEAR);
        d.add(Calendar.MONTH, 5); // Add 5 months
        this.due_date = d.get(Calendar.DATE);
        this.due_month = d.get(Calendar.MONTH);
        this.due_year = d.get(Calendar.YEAR);
    }
    @Override
    public double monthTime(){
        Calendar d = Calendar.getInstance();
        LocalDate nowTime = LocalDate.of(d.get(Calendar.YEAR), d.get(Calendar.MONTH), d.get(Calendar.DATE));
        LocalDate Time = LocalDate.of(year, month, date);
        
        Period period = Period.between(nowTime, Time);
        double monthtime = period.getMonths();

        if (period.getDays() >= 15){
           monthtime += 1;
        }else{
           monthtime += 0.5;
        }
        
        System.out.println(monthtime);
        return monthtime;
    }
    
    @Override
    public double InterestPrice(){
        return this.monthTime() * this.getValue() * (this.interest / 100);
    }
    
    public double InterestPrice(double pro){
        return this.monthTime() * this.getValue() * ((this.interest - pro) / 100);
    }
    
    public abstract boolean CheckValue(double d);
    
    public void setTest(int day,int month){
        Calendar d = Calendar.getInstance();
        d.add(Calendar.DATE, day);
        d.add(Calendar.MONTH, month);
        this.date = d.get(Calendar.DATE);
        this.month = d.get(Calendar.MONTH);
        this.year = d.get(Calendar.YEAR);
        System.out.println(this.month);
    }
}
