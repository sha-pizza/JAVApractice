abstract public class B_human extends A_animal{
    // new method 'only' for B_human
    public void talking(){
        System.out.println("human : blah blah");
    }
    // overrided method
    public void roam(){
        System.out.println("this human : walking around the street");
    }
}