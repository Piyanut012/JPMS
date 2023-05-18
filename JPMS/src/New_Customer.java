
public class New_Customer extends Customer{

    public New_Customer() {
    }

    public New_Customer(int id, String name, String phone_number, String address, String email, String FB, String IDline) {
        super(id, name, phone_number, address, email, FB, IDline);
    }

    @Override
    public void Promotion(){
        System.out.println("ProNew");
    }

    @Override
    public boolean CheckLimit(double total) {
        if (total >= 500000){
            return true;
        }else{
            return false;
        }
    }
}
