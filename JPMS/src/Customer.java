
import java.util.*;
import java.io.*;

public abstract class Customer implements Serializable{
    private int id;
    private String name;
    private String phone_number;
    private String address;
    private String email;
    private String FB;
    private String IDline;
    private double principle;
//    private double interest;
    private LinkedHashMap<Integer, Pawn> itmes_data;

    public Customer(){
        this(0,"", "", "", "", "", "");
    }
    
    public Customer(int id,String name, String phone_number, String address, String email, String FB, String IDline) {
        this.id = id;
        this.name = name;
        this.phone_number = phone_number;
        this.address = address;
        this.email = email;
        this.FB = FB;
        this.IDline = IDline;
        this.principle = 0;
        this.itmes_data = new LinkedHashMap<>();
    }

    public LinkedHashMap<Integer, Pawn> getItmes_data() {
        return itmes_data;
    }

    public void setItmes_data(LinkedHashMap<Integer, Pawn> itmes_data) {
        this.itmes_data = itmes_data;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public abstract void Promotion();
    public abstract boolean CheckLimit();
}
