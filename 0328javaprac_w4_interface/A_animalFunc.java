public class A_animalFunc{
    public static void Introduce(Object ANIM){
        System.out.println("");
        System.out.println("===== ===== ===== ===== ===== =====");
        System.out.println("");

        if (ANIM instanceof A_animal){
            Introduce_A_animal((A_animal) ANIM);
        }

        if (ANIM instanceof A_pet){
            Introduce_A_pet((A_pet)ANIM);
        }

        if (ANIM instanceof A_robot){
            Introduce_A_robot((A_robot)ANIM);
        }
    }

    public static void Introduce_A_animal(A_animal ANIM){
        System.out.println("FOOD :            "+ANIM.food);
        System.out.println("LOCATION :        "+ANIM.location);
        System.out.println("STATUS :          "+ANIM.status);

        ANIM.makeNoise();
        ANIM.eat();
        ANIM.roam();
    }

    public static void Introduce_A_pet(A_pet PET){
        PET.isPet();
    }

    public static void Introduce_A_robot(A_robot ROBOT){
        ROBOT.isRobot();
    }
}