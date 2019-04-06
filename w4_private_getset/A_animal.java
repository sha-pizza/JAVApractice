package w4_private_getset;

public class A_animal{
    // instance vars
    private String food; 
    public String location;
    public String status;
    // methods
    public void makeNoise(){};
    public void eat(){};
    public void roam(){};
    // getter and setter of 'private' food
    public void setFood(String F){
        food = F;
        System.out.println("food setter : "+F);
    }

    public String getFood(){
        System.out.println("food getter : "+food);
        return food;
    }


}