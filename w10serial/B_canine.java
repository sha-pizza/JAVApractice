package w10serial;

import java.io.Serializable;

public class B_canine extends A_animal implements Serializable{
    // define serial Version UID : Version Control
    private static final long serialVersionUID = 190516;
    // overrided method 
    public void roam(){
        System.out.println("this canine : tend to move in packs");
    }
}