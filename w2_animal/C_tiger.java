package w2_animal;

public class C_tiger extends B_feline{
    // overrided method 
    public void makeNoise(){
        System.out.println("Tiger : growls");
    }
    public void eat(){
        System.out.println("Tiger eats fresh meat");
    }
    // constructor
    public C_tiger (String F, String L, String S){
        food = F;
        location = L;
        status = S;
    }
}