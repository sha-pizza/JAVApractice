package w3abstracted;

public class C_vet extends B_human{
    // overrided method from B_human
    public void talking(){
        System.out.println("Vet : *says something*");
    }
    // new method 'only' for C_vet
    public void treatAnimal(){
        System.out.println("Vet is now taking care of animal...");
    }
    public void eat(){}
    public void makeNoise(){}
    
    // constructor
    public C_vet (String F, String L, String S){
        food = F;
        location = L;
        status = S;
    }   
    
}