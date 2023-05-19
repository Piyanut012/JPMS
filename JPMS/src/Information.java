import java.util.Calendar;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;
import java.io.*;
import java.time.LocalDate;
import java.time.Period;

public final class Information implements Serializable{
    private double capital;
    private double current_money;
    private double loan;
    private double profit;
    private int pawn_goods;
    private int pawn_droppings;
    private int sold;
    private int id_item_all;
    private int id_customer_all;
    private int add_id_item;
    private int add_id_customer;
    private LinkedHashMap<Integer ,Pawn_droppings> Pawn_droppings_data;
    private LinkedHashMap<Integer ,Customer> Customers_Data;
    
    public Information(){
        this(0.0, 0.0, 0.0, 0, 0, 0);
    }

    public Information(double capital, double current_money, double loan, int pawn, int pawn_droppings, int sold) {
        this.capital = capital;
        this.current_money = current_money;
        this.loan = loan;
        this.pawn_goods = pawn;
        this.profit = current_money - capital;
        this.pawn_droppings = pawn_droppings;
        this.sold = sold;
        this.add_id_item = 0;
        this.add_id_customer = 0;
        this.id_item_all = 0;
        this.id_customer_all = 0;
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

    public int getPawn_goods() {
        return pawn_goods;
    }
    public void setPawn_goods(int pawn_goods) {
        this.pawn_goods = pawn_goods;
    }

    public int getPawn_droppings() {
        return pawn_droppings;
    }

    public void setPawn_droppings(int pawn_droppings) {
        this.pawn_droppings = pawn_droppings;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public int getAdd_id_item() {
        return ++add_id_item;
    }

    public void setAdd_id_item(int add_id_item) {
        this.add_id_item = add_id_item;
    }

    public int getAdd_id_customer() {
        return ++add_id_customer;
    }

    public void setAdd_id_customer(int add_id_customer) {
        this.add_id_customer = add_id_customer;
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
    
    public int getId_item_all() {
        id_item_all = add_id_item;
        return id_item_all;
    }

    public void setId_item_all(int id_item_all) {
        this.id_item_all = id_item_all;
    }

    public int getId_customer_all() {
        id_customer_all = add_id_customer;
        return id_customer_all;
    }

    public void setId_customer_all(int id_customer_all) {
        this.id_customer_all = id_customer_all;
    }
    
    public double getProfit() {
        this.profit = current_money - capital;
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public void update_pawngoods(){
        LocalDateTime currentDateTime = LocalDateTime.now();
        for (Customer cus : Customers_Data.values()) {
            LinkedHashMap<Integer, Pawn> itemsData = cus.getItmes_data();
            LinkedHashMap<Integer, Pawn> itemsToRemove = new LinkedHashMap<>();

            for (Pawn itemss : itemsData.values()) {
                LocalDateTime itemTime = LocalDateTime.of(itemss.getDue_year(), itemss.getDue_month(), itemss.getDue_date(), 0, 0);
                //test
                if (currentDateTime.isAfter(itemTime)) {
                    Pawn_droppings newPawnDrop = new Pawn_droppings(itemss.getID(), itemss.getName(),
                            itemss.getValue(), itemss.getImage());
                    Pawn_droppings_data.put(newPawnDrop.getID(), newPawnDrop);
                    cus.setLoan(cus.getLoan()-itemss.getValue());
                    itemsToRemove.put(itemss.getID(), itemss);
                }
            }
            itemsData.keySet().removeAll(itemsToRemove.keySet());
        }
    }
    
    public void update_customer(){
    LocalDateTime currentDateTime = LocalDateTime.now();
    for (Customer cus : Customers_Data.values()) {
        if (cus instanceof Old_Customer){
            continue;
        }
        LocalDateTime CustomerTime = LocalDateTime.of(cus.getYear(), cus.getMonth(), cus.getDate(), 0, 0);
        Period period = Period.between(CustomerTime.toLocalDate(), currentDateTime.toLocalDate());
        int monthDifference = period.getMonths();
        
        if (monthDifference >= 5) {
            System.out.println("Old");
            Customer old_customer = new Old_Customer(cus.getId(), cus.getName(), cus.getPhone_number(), cus.getAddress(), cus.getEmail() ,cus.getFB(),
                cus.getIDline(), cus.getLoan(), cus.getItmes_data(), cus.getDate(), cus.getMonth(), cus.getYear());
            
            Customers_Data.put(cus.getId(), old_customer);
        }
    }
}

    public boolean checkloan(double total){
        if (current_money-total < 0){
            return true;
        }else{
            return false;
        }
    }
    public void addcustomer(int id, Customer c, double total){
        this.Customers_Data.put(id, c);
        addpawngoods(c.getItmes_data().size(),total);   
    }
    
    public void addpawngoods(int amount,double total){
        this.current_money -= total;
        this.loan += total;
        this.pawn_goods += amount;
    }
    
    public void sellpawndroppings(int amount, double total){
        this.current_money += total;
        this.loan -= total;
        this.pawn_droppings -= amount;
        this.sold += amount;
    }
    
    public void redeem(int amount, double total){
        this.current_money += total;
        this.loan -= total;
        this.pawn_goods -= amount;
    }
    
    public void sentinterest(double total){
        this.current_money += total;
    }
}
