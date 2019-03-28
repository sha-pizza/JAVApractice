public class A_animalLauncher{
    public static void main (String[] args){
        // Every constructor include ("food","location","status"=instance variables)
        //System.out.println("");

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
        CAT.isPet();

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
        DOG.isPet();

        // robodog implement A_pet and A_robot
        C_roboDog ROBODOG = new C_roboDog(){};
        System.out.println("");
        System.out.println("===== ===== ===== ===== ===== =====");
        System.out.println("");
        ROBODOG.isPet();
        ROBODOG.isRobot();

    }
}