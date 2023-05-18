
public class Old_Customer extends Customer{
    
    
    @Override
    public void Promotion(){
        System.out.println("ProOld");
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
