
import java.io.DataInputStream;

import javax.swing.JFrame;

// Thread Receive : continue to receive and set frame
public class Cthread_recv extends Thread{
    String recv;
    DataInputStream inFromServ;
    JFrame F;
    stage3 S3;
    public Cthread_recv(stage3 S3, DataInputStream inFromServ, JFrame F){
        this.S3 = S3;
        this.inFromServ = inFromServ;
        this.F = F;
        //start();
    }
    public void run(){
        print("3 : start recv thread");
        while (true){
            try {   Thread.sleep(1000);     } 
            catch (InterruptedException es) {} 

            recv = read();
            for (int i=0 ; i<17 ; i++){
                S3.log[i].setText(S3.log[i+1].getText());   
            }
            S3.log[17].setText(recv);
            F.revalidate();
            F.repaint();
        }
    }

    public void print (String printMessage){
        System.out.println("    cond" + printMessage);
    }
    public String read (){
        String receiveMessage = ""; 
        try{    
            receiveMessage = inFromServ.readUTF();  
            print(" : success to read : " + receiveMessage);                   }
        catch (Exception e) { 
            print(" : fail to read");                       }
        return receiveMessage;
    }
}
