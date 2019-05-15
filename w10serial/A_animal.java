package w10serial;

import java.io.Serializable;

public class A_animal implements Serializable{
    // define serial Version UID : Version Control
    private static final long serialVersionUID = 190516;
    // instance vars
    String name;
    String food;
    String location;
    String status;
    // methods
    public void makeNoise(){}
    public void eat(){}
    public void sleep(){}
    public void roam(){}

}