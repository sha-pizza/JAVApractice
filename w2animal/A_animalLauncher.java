package w2animal;

public class A_animalLauncher{
    public static void main (String[] args){
        // Every constructor include ("food","location","status")
        System.out.println("");

        // extended from B_human
        C_vet VET = new C_vet("no lunch", "animal hospital", "take care of animals"){};
        VET.talking();
        VET.treatAnimal();
        System.out.println("");

        C_petOwner PETO = new C_petOwner("ate pizza for lunch", "pizzashop", "waiting for treatment"){};
        PETO.talking();
        PETO.thankYouVet();
        System.out.println("");

        // extended from B_feline
        C_tiger TIGER = new C_tiger("fresh meat", "zoo", "strong"){};
        TIGER.makeNoise();
        TIGER.eat();
        TIGER.roam();
        System.out.println("");

        C_cat CAT = new C_cat("tuna_can", "street", "cute"){};
        CAT.makeNoise();
        CAT.eat();
        CAT.roam();
        System.out.println("");

        // extended from B_Canine
        C_wolf WOLF = new C_wolf("fresh meat", "somewhere", "hungry"){};
        WOLF.makeNoise();
        WOLF.eat();
        WOLF.roam();
        System.out.println("");

        C_dog DOG = new C_dog("dog food", "house", "much cute"){};
        DOG.makeNoise();
        DOG.eat();
        DOG.roam();
        System.out.println("");

        // extended from A_animal
        C_hippo HIPPO = new C_hippo("watermelon", "river", "big"){};
        HIPPO.makeNoise();
        HIPPO.eat();
        System.out.println("");

    }
}