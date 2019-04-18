package w4interface;

public class C_roboDog implements A_pet,A_robot{
    // implement A_pet
    public void isPet(){
        System.out.println("Robodog is cute");
    }
    // implement A_robot
    public void isRobot(){
        System.out.println("Robodog is robot");
    }


}