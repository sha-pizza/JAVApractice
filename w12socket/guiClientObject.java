import java.io.*;
import java.net.*;

public class guiClientObject{

    public String start(Socket C_socket, String Text){
        String C_send;
        String C_receive;

        try{            
            // stream to get input from server & read it
            InputStreamReader inFromServ_ = new InputStreamReader(C_socket.getInputStream());
            BufferedReader inFromServ = new BufferedReader(inFromServ_);

            // stream to send output to server
            DataOutputStream outToServ = new DataOutputStream(C_socket.getOutputStream());

            // get input-from-user
            C_send = Text;

            // send it to server
            outToServ.writeBytes(C_send+"\n");
            System.out.println("to SERV : "+C_send);

            // EXIT CASE : if input is Q
            if (C_send.equals("QUIT")){
                return "QUIT";
            }

            // wait for a short time to serverwork...
            try{                    Thread.sleep(1000);     }
            catch (Exception e){    e.printStackTrace();    }

            // receive from server
            C_receive = inFromServ.readLine();
            System.out.println("fr SERV : "+C_receive);
            System.out.println("");
        

        } catch (IOException ex){
            ex.printStackTrace();
            System.out.println("CLNT : connection error!");
            return "QUIT";
        }
        return " ";
    }
}