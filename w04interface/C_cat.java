package w04interface;

public class C_cat extends B_feline implements A_pet{
    // overrided method 
    public void makeNoise(){
        System.out.println("Cat : meow-meow-");
    }
    public void eat(){
        System.out.println("Cat eats tuna-can");
    }
    // constructor
    public C_cat (String F, String L, String S){
        food = F;
        location = L;
        status = S;
    }
    // implement A_pet
    public void isPet(){
        System.out.println("Cat is cute");
    }
}