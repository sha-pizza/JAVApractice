package w2_duringclass;

public class DoctorMain {
    public static void main (String[] args){
        // make -origin- objects!
        Doctor A = new Doctor();
        A.worksAtHospital = true;
        System.out.println("");
        System.out.println("Doctor :");
        A.treatPatient();   

        FamilyDoctor B = new FamilyDoctor();
        B.worksAtHospital = true;
        System.out.println("");
        System.out.println("FamilyDoctor :");
        B.treatPatient();
        B.makeHouseCall();
        B.giveAdvice();
        
        Surgeon C = new Surgeon();
        C.worksAtHospital = true;
        System.out.println("");
        System.out.println("Surgeon :");
        C.treatPatient();

        
        // polymorphism- on 0321 !
        Doctor D = new FamilyDoctor();
        System.out.println("");
        System.out.println("FamilyDoctor D :");
        D.treatPatient();
        //D.makeHouseCall();
 
 
    }

}