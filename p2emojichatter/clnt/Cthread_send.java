import java.io.DataOutputStream;

// Tread Read : continue to read
public class Cthread_send extends Thread{
    String send = "";
    String prevsend = "";
    DataOutputStream outToServ;
    stage3 S3;
    public Cthread_send(stage3 S3, DataOutputStream outToServ){
        this.S3 = S3;
        this.outToServ = outToServ;
        //start();
    }
    public void run(){
        print("3 : start send thread");
        while (true){
            try {   Thread.sleep(1000);     } 
            catch (InterruptedException es) {} 
            
            send = S3.sendMessage;
            if (!send.equals(prevsend)){
                write(send);
                prevsend = send;
            }
        }
    }



    public void print (String printMessage){
        System.out.println("    cond" + printMessage);
    }
    public void write (String sendMessage){
        try{    
            outToServ.writeUTF(sendMessage); 
            print(" : success to write : "+sendMessage);                   }
        catch (Exception e) { 
            print(" : fail to write"); e.printStackTrace(); }
    }
}