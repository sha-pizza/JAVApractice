
import java.io.*;
import java.net.*;

public class aSmallServer{

    public static void main (String[] args){
        String S_send;
        String S_receive;

        try{
            // init a new socket & connect it
            ServerSocket S_socket = new ServerSocket (4545);
            System.out.println("SERV : wait for client ");
            Socket connect_socket = S_socket.accept();
            System.out.println("SERV : OPEN ! ");

            while(true){

                // stream to get input from client & read it
                InputStreamReader inFromClnt_ = new InputStreamReader(connect_socket.getInputStream());
                BufferedReader inFromClnt = new BufferedReader(inFromClnt_);

                // stream to send output to socket
                DataOutputStream outToClnt = new DataOutputStream(connect_socket.getOutputStream());

                System.out.println("SERV : wait for input");

                // get input from client
                S_receive = inFromClnt.readLine();
                System.out.println("fr CLNT : "+S_receive);

                // TODO : server's work
                // in this case, server transfer string to UPPERSTRING
                S_send = S_receive.toUpperCase();


                // EXIT CASE : if input is Q
                if (S_receive.equals("QUIT")){
                    break;
                }

                // send it to server
                outToClnt.writeBytes(S_send+"\n");
                System.out.println("to CLNT : "+S_send);  
                System.out.println("");
            }
            // close 
            System.out.println("SERV : CLOSE ! ");
            connect_socket.close();
            S_socket.close();

        } catch (IOException ex){
            ex.printStackTrace();
            System.out.println("SERV : connection error!");
        }
    }
}
