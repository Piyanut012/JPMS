
import java.util.LinkedHashMap;


public class Old_Customer extends Customer{
    private double sentinterest_amount;
    
    public Old_Customer() {
    }

    public Old_Customer(int id, String name, String phone_number, String address, String email, String FB, String IDline, double loan,
            LinkedHashMap<Integer, Pawn> itmes_data, int date, int month, int year) {
        this.sentinterest_amount = 0;
        setId(id);
        setName(name);
        setPhone_number(phone_number);
        setAddress(address);
        setEmail(email);
        setFB(FB);
        setIDline(IDline);
        setLoan(loan);
        setItmes_data(itmes_data);
        setDate(date);
        setMonth(month);
        setYear(year);
    }

    public double getSentinterest_amount() {
        return sentinterest_amount;
    }

    public void setSentinterest_amount(double sentinterest_amount) {
        this.sentinterest_amount += sentinterest_amount;
    }
    
    
    @Override
    public double Promotion(){
        if (this.sentinterest_amount >= 50000){
            return 0.25;
        }
        else{
            return 0;
        }
    }

    @Override
    public boolean CheckLimit(double total) {
        if (total >= 1000000){
            return true;
        }else{
            return false;
        }
    }
}
