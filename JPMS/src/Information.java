
import java.util.*;
import java.io.*;

public final class Information implements Serializable{
    private double capital;
    private double current_money;
    private double loan;
    private double pawn;
    private double pawn_droppings;
    private double pawn_sale;
    private int id_item;
    private int id_customer;
    private LinkedHashMap<Integer ,Pawn_droppings> Pawn_droppings_data;
    private LinkedHashMap<Integer ,Customer> Customers_Data;
    
    public Information(){
        this(0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
    }

    public Information(double capital, double current_money, double loan, double pawn, double pawn_droppings, double pawn_sale) {
        this.capital = capital;
        this.current_money = current_money;
        this.loan = loan;
        this.pawn = pawn;
        this.pawn_droppings = pawn_droppings;
        this.pawn_sale = pawn_sale;
        this.id_item = 0;
        this.id_customer = 0;
        this.Pawn_droppings_data = new LinkedHashMap<>();
        this.Customers_Data =  new LinkedHashMap<>();
    }

    public double getCapital() {
        return capital;
    }

    public void setCapital(double capital) {
        this.capital = capital;
    }

    public double getCurrent_money() {
        return current_money;
    }

    public void setCurrent_money(double current_money) {
        this.current_money = current_money;
    }

    public double getLoan() {
        return loan;
    }

    public void setLoan(double loan) {
        this.loan = loan;
    }

    public double getPawn() {
        return pawn;
    }

    public void setPawn(double pawn) {
        this.pawn = pawn;
    }

    public double getPawn_droppings() {
        return pawn_droppings;
    }

    public void setPawn_droppings(double pawn_droppings) {
        this.pawn_droppings = pawn_droppings;
    }

    public double getPawn_sale() {
        return pawn_sale;
    }

    public void setPawn_sale(double pawn_sale) {
        this.pawn_sale = pawn_sale;
    }

    public int getId_item() {
        return id_item++;
    }

    public void setId_item(int id_item) {
        this.id_item = id_item;
    }

    public int getId_customer() {
        return id_customer++;
    }

    public void setId_customer(int id_customer) {
        this.id_customer = id_customer;
    }

    

    public LinkedHashMap<Integer, Pawn_droppings> getPawn_droppings_data() {
        return Pawn_droppings_data;
    }

    public void setPawn_droppings_data(LinkedHashMap<Integer, Pawn_droppings> Pawn_droppings_data) {
        this.Pawn_droppings_data = Pawn_droppings_data;
    }

    public LinkedHashMap<Integer, Customer> getCustomers_Data() {
        return Customers_Data;
    }

    public void setCustomers_Data(LinkedHashMap<Integer, Customer> Customers_Data) {
        this.Customers_Data = Customers_Data;
    }


    
}
