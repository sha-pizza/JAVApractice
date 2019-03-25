public class A_animalLauncher{
    public static void main (String[] args){
        // Every constructor include ("food","location","status"=instance variables)
        //System.out.println("");

        // extended from B_human
        C_vet VET = new C_vet("no lunch", "animal hospital", "take care of animals"){};
        A_animalFunc.Introduce(VET);
        VET.talking();
        VET.treatAnimal();
        VET.roam();

        C_petOwner PETO = new C_petOwner("ate pizza for lunch", "pizzashop", "waiting for treatment"){};
        A_animalFunc.Introduce(PETO);
        PETO.talking();
        PETO.thankYouVet();
        PETO.roam();

        // extended from B_feline
        C_tiger TIGER = new C_tiger("fresh meat", "zoo", "strong"){};
        A_animalFunc.Introduce(TIGER);
        TIGER.makeNoise();
        TIGER.eat();
        TIGER.roam();

        C_cat CAT = new C_cat("tuna_can", "street", "cute"){};
        A_animalFunc.Introduce(CAT);
        CAT.makeNoise();
        CAT.eat();
        CAT.roam();

        // extended from B_Canine
        C_wolf WOLF = new C_wolf("fresh meat", "somewhere", "hungry"){};
        A_animalFunc.Introduce(WOLF);
        WOLF.makeNoise();
        WOLF.eat();
        WOLF.roam();

        C_dog DOG = new C_dog("dog food", "house", "much cute"){};
        A_animalFunc.Introduce(DOG);
        DOG.makeNoise();
        DOG.eat();
        DOG.roam();

        // extended from A_animal
        C_hippo HIPPO = new C_hippo("watermelon", "river", "big"){};
        A_animalFunc.Introduce(HIPPO);
        HIPPO.makeNoise();
        HIPPO.eat();

        System.out.println("");
        System.out.println("===== ===== ===== ===== ===== =====");
        System.out.println("");
        
    }
}