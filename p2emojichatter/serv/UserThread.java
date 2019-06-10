import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class UserThread extends Thread {

    Socket socket;
    int socketNumber;
    UserThread[] User;
    String userType;

    DataInputStream inFromClnt;
    DataOutputStream outToClnt;

    // Constructor
    public UserThread(Socket socket, int userCount, UserThread[] User ) throws Exception
    {
        this.socket = socket;
        this.socketNumber = userCount;
        this.User = User;

        inFromClnt = new DataInputStream(socket.getInputStream());
        outToClnt = new DataOutputStream(socket.getOutputStream());
        System.out.println("SERV" + socketNumber + " : wait for input");
        start();
    }

    public void run(){
        // COND3 : start chatting
        try{
            print(">> cond3");
            String MSG="";
            // get SendMessage and REsend it to Every User
            while(true){
                /*ServerWork(MSG);
                if (MSG.equals("CONNECTION ERROR")){
                    print(" : cond3 CONNECTION ERROR"); 
                    stop();
                }*/
                synchronized (MSG){
                MSG = read();
                if (MSG.equals("CONNECTION ERROR")){
                    return;
                }
                MSG = socketNumber+":"+MSG;

                for (UserThread U : User){
                    if(U == null){  break;  }
                    U.write(MSG);           }             
                
                // if sendmessage contains word 'emoji', 
                // server feel happy and send random emoji to everyone
                if (MSG.contains("emoji")){
                    String happyEmoji = ">>>  server says " + getRandEmoji();
                    for (UserThread U : User){
                        if(U == null){  break;  }
                        U.write(happyEmoji);           
                    } 
                }
            }
            }
        }
        catch(Exception e) { 
            print(" : cond3 errorwork"); 
        }  
    }
    public synchronized void ServerWork(String MSG) {
        MSG = read();
        if (MSG.equals("CONNECTION ERROR")){
            return;
        }
        MSG = socketNumber+":"+MSG;

        for (UserThread U : User){
            if(U == null){  break;  }
            U.write(MSG);           }             
                
        // if sendmessage contains word 'emoji', 
        // server feel happy and send random emoji to everyone
        if (MSG.contains("emoji")){
            String happyEmoji = ">>>  server says " + getRandEmoji();
            for (UserThread U : User){
                if(U == null){  break;  }
                U.write(happyEmoji);           
            } 
        }
    }


    public String getRandEmoji(){
        int randNum = (int) (Math.random() * 10);
        switch(randNum){
            case 0 : return(";[^m^];");
            case 1 : return("/(^A^)/"); 
            case 2 : return("*(;-;)*"); 
            case 3 : return("<[^o^]>"); 
            case 4 : return(";(YAY);");
            case 5 : return("/{^p^}/"); 
            case 6 : return("/{^p^}/");
            case 7 : return("V(ToT)V"); 
            case 8 : return("Y{OmO}Y"); 
            case 9 : return("<(6_6)>");
            default : return("<(6_6)>");
        }
    }

   


    



    // some useful methods -------------------------------------------------------------

    public void print (String printMessage){
        System.out.println("SERV" + socketNumber + printMessage);
    }
    public void write (String sendMessage){
        try{ 
            Thread.sleep(100);   
            outToClnt.writeUTF(sendMessage); 
            print(" : success to write : " + sendMessage);}
        catch (Exception e) {
            print(" : fail to write - connection reset by peer"); }
    }
    public String read (){
        String receiveMessage = ""; 
        try{    
            Thread.sleep(100);
            receiveMessage = inFromClnt.readUTF();  
            print(" : success to read : " + receiveMessage); }
        catch (Exception e) { 
            print(" : fail to read"); 
            return "CONNECTION ERROR";
        }
        return receiveMessage;
    }
}