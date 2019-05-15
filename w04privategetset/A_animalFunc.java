package w04privategetset;;

public class A_animalFunc{
    public static void Introduce(A_animal ANIM){
        System.out.println("");
        System.out.println("===== ===== ===== ===== ===== =====");
        System.out.println("");
        System.out.println("FOOD :            "+ANIM.getFood());
        System.out.println("LOCATION :        "+ANIM.location);
        System.out.println("STATUS :          "+ANIM.status);
    }
}