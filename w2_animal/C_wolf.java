package w2_animal;

public class C_wolf extends B_canine{
    // overrided method 
    public void makeNoise(){
        System.out.println("Wolf : howls");
    }
    public void eat(){
        System.out.println("Wolf want to eat fresh meat");
    }
    // constructor
    public C_wolf (String F, String L, String S){
        food = F;
        location = L;
        status = S;
    }
}