package w2animal;

public class C_petOwner extends B_human{
    // overrided method from B_human
    public void talking(){
        System.out.println("PetOwner : *says something*");
    }
    // new method 'only' for C_petOwner
    public void thankYouVet(){
        System.out.println("PetOwner says ... thank you Vet!");
    }
    // constructor
    public C_petOwner (String F, String L, String S){
        food = F;
        location = L;
        status = S;
    }
}