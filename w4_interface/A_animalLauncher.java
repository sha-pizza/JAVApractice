package w4_interface;

public class A_animalLauncher{
    public static void main (String[] args){

        Object[] ANIMS = new Object[5];

        ANIMS[0] = new C_tiger("fresh meat", "zoo", "strong"){};
        ANIMS[1] = new C_cat("tuna_can", "street", "cute"){};
        ANIMS[2] = new C_wolf("fresh meat", "somewhere", "hungry"){};
        ANIMS[3] = new C_dog("dog food", "house", "much cute"){};
        ANIMS[4] = new C_roboDog(){};

        for (Object O : ANIMS){
            A_animalFunc.Introduce(O);
        }

        System.out.println("");
        System.out.println("===== ===== ===== ===== ===== =====");
        System.out.println("");

    }
}