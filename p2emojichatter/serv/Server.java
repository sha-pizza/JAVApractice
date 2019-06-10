import java.net.ServerSocket;
import java.net.Socket;

public class Server{
    static ServerSocket ServerSocket;

    static int userCount = 0;
    static UserThread[] User = new UserThread[100];       // user objects : waiting to play     
    
    public static void main(String[] args){
        // initialize serverSocket
        try {   ServerSocket = new ServerSocket(8080);
                System.out.println("SERV : server start! ");        } 
        catch (Exception e){    e.printStackTrace();                }
 
        // start to accept & take care of users
        // server create THREAD to every accepted user
        try{
            while (true){   
                // server will not end until terminal die / or exception occur  
                // COND2 : get appropriate IP address from userInput and connect to server                            
                Socket AcceptSocket = ServerSocket.accept();
                User[userCount] = new UserThread(AcceptSocket, userCount, User);
                userCount++;
                System.out.println("SERV : waitcount "+userCount);
            }
        }
        catch (Exception e){    e.printStackTrace();                }
    }
    

}