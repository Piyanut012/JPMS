
public class New_Customer extends Customer{
    
    @Override
    public void Promotion(){
        System.out.println("ProNew");
    }

    @Override
    public boolean CheckLimit() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
