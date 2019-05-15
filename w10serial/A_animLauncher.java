package w10serial;

import java.io.*;

public class A_animLauncher  {
    // serializable --> must be instance var!!
    private static C_dog D1 = new C_dog("DOG1","F1","L1","S1");
    private static C_dog D2 = new C_dog("DOG2","F2","L2","S2");
    private static C_dog D3 = new C_dog("DOG3","F3","L3","S3");
    private static C_dog D4 = new C_dog("DOG4","F4","L4","S4");
    private static C_dog D5 = new C_dog("DOG5","F5","L5","S5");
    private static C_dog[] myDogs = new C_dog[5];

    public static void main(String[] args){
        // PUT DOG OBJECTS IN DOG ARRAY
        myDogs[0]=D1;
        myDogs[1]=D2;
        myDogs[2]=D3;
        myDogs[3]=D4;
        myDogs[4]=D5;

        // SAVE OBJECTS
        try {
            System.out.println("SAVED       : DOG OBJECTS");
            ObjectOutputStream OS = new ObjectOutputStream(new FileOutputStream("makeDog.txt"));

            // SAVE & PRINT DOG using FOR LOOP
            for (int i=0 ; i<myDogs.length ; i++){
                OS. writeObject(myDogs[i]);
                System.out.print("saved  "+myDogs[i].name+" : "+myDogs[i].food+", "+myDogs[i].location+", "+myDogs[i].status+"\n");
            }
            OS.close();
            
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("ERROR");
        }
        // RELOAD
        try {
            ObjectInputStream IS = new ObjectInputStream(new FileInputStream("makeDog.txt"));
            System.out.println("LOADED      : DOG OBJECTS");

            // LOAD & PRINT DOG using FOR LOOP
            for (int i=0 ; i<5 ; i++){
                C_dog tmpDog = (C_dog) IS.readObject();
                System.out.print("loaded "+tmpDog.name+" : "+tmpDog.food+", "+tmpDog.location+", "+tmpDog.status+"\n");
            }
            IS.close();         

        } catch (Exception e){
            e.printStackTrace();
            System.out.println("ERROR");
        }
    }
}