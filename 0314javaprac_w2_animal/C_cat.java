public class C_cat extends B_feline{
    // overrided method 
    @Override
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
}