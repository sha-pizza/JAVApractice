package w10serial;

import java.io.Serializable;

public class C_dog extends B_canine implements Serializable {
    // define serial Version UID : Version Control
    private static final long serialVersionUID = 190516;

    // overrided method
    public void makeNoise(){
        System.out.println("Dog : bark! bark!");
    }
    public void eat(){
        System.out.println("Dog eats royal canin");
    }
    // constructor
    public C_dog (String N, String F, String L, String S){
        name = N;
        food = F;
        location = L;
        status = S;
    }
}