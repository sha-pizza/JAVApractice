package w03abstracted;

public class C_dog extends B_canine{
    // overrided method 
    public void makeNoise(){
        System.out.println("Dog : bark! bark!");
    }
    public void eat(){
        System.out.println("Dog eats royal canin");
    }
    // constructor
    public C_dog (String F, String L, String S){
        food = F;
        location = L;
        status = S;
    }
}