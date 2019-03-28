public class A_animalLauncher{
    public static void main (String[] args){
        // Every constructor include ("food","location","status"=instance variables)
        //System.out.println("");

        // extended from B_Canine
        C_dog DOG = new C_dog("dog food", "house", "much cute"){};
        A_animalFunc.Introduce(DOG);
        DOG.makeNoise();
        DOG.eat();
        DOG.roam();
    }
}