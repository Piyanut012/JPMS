
import java.util.*;
import java.io.*;

public abstract class Customer implements Serializable{
    private String name;
    private String phone_number;
    private String address;
    private String email;
    private String FB;
    private String IDline;
    private double principle;
    private double interest;
    private ArrayList<Pawn> itmes;

    public Customer(){
        this("", "", "", "", "", "", 0.0);
    }
    
    public Customer(String name, String phone_number, String address, String email, String FB, String IDline, double principle) {
        this.itmes = new ArrayList<>();
        Pawn item1 = new Appliance();
        item1.setID(1);
        Pawn item2 = new Appliance();
        item2.setID(2);
        this.itmes.add(item1);
        this.itmes.add(item2);
        this.name = name;
        this.phone_number = phone_number;
        this.address = address;
        this.email = email;
        this.FB = FB;
        this.IDline = IDline;
        this.principle = principle;
    }
    
    public ArrayList<Pawn> getItmes() {
        return itmes;
    }

    public void setItmes(ArrayList<Pawn> itmes) {
        this.itmes = itmes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFB() {
        return FB;
    }

    public void setFB(String FB) {
        this.FB = FB;
    }

    public String getIDline() {
        return IDline;
    }

    public void setIDline(String IDline) {
        this.IDline = IDline;
    }

    public double getPrinciple() {
        return principle;
    }

    public void setPrinciple(double principle) {
        this.principle = principle;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }
    
    public abstract void Promotion();
    public abstract boolean CheckLimit();
}
