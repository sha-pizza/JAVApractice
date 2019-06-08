
import java.io.*;
import java.net.*;

public class aSmallClient{

    public static void main (String[] args){
        String C_send;
        String C_receive;

        try{
            // init a new socket & connect it
            Socket C_socket = new Socket ("127.0.0.1", 4545);
            System.out.println("CLNT : OPEN ! ");

            while(true){
                // buffered reader to get input-from-user
                InputStreamReader inFromUser_ = new InputStreamReader(System.in);
                BufferedReader inFromUser = new BufferedReader(inFromUser_);

                // stream to get input from server & read it
                InputStreamReader inFromServ_ = new InputStreamReader(C_socket.getInputStream());
                BufferedReader inFromServ = new BufferedReader(inFromServ_);

                // stream to send output to server
                DataOutputStream outToServ = new DataOutputStream(C_socket.getOutputStream());

                // get input-from-user
                System.out.print("input ---> ");
                C_send = inFromUser.readLine();

                // send it to server
                outToServ.writeBytes(C_send+"\n");
                System.out.println("to SERV : "+C_send);

                // EXIT CASE : if input is Q
                if (C_send.equals("QUIT")){
                    outToServ.writeBytes("QUIT");
                    break;
                }

                // wait for a short time to serverwork...
                try{                    Thread.sleep(1000);     }
                catch (Exception e){    e.printStackTrace();    }

                // receive from server
                C_receive = inFromServ.readLine();
                System.out.println("fr SERV : "+C_receive);
                System.out.println("");
            }

            // close 
            System.out.println("CLNT : CLOSE ! ");
            C_socket.close();

        } catch (IOException ex){
            ex.printStackTrace();
            System.out.println("CLNT : connection error!");
        }
    }
}
