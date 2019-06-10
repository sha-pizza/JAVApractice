import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import javax.swing.JFrame;


public class User_basic {
    // set variableds
    final String userType = "User";
    JFrame F;
    Socket socket;
    DataInputStream inFromServ; // this thing must be used after con3
    DataOutputStream outToServ; // this thing must be used after con3

    // empty constructor
    public User_basic() {};
    // basic constructor
    public User_basic(JFrame F, Socket socket, DataInputStream inFromServ, DataOutputStream outToServ) {
        this.F = F;
        this.socket = socket;
        this.inFromServ = inFromServ;
        this.outToServ = outToServ;

        this.makeFrame(F);
        this.makeFrameMove(F);
    };

    // COND1 : get "Y" if user want to enter chat
    public String cond1() {
        String userMode = "";               // --> keyToCond2 
        // set stage(JPanel) object and JFrame
        stage1 S1 = new stage1();
        F.setContentPane(S1);
        F.setVisible(true);
        F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // get keyinput until get "Y" or "S"
        while (!S1.keyToCond2.equals("Y") && !S1.keyToCond2.equals("S")) {
            print("1 : wait for user Mode ");
            try {   Thread.sleep(100);     } 
            catch (InterruptedException e) {}
        }
        print("1 : get userInput : "+S1.keyToCond2);

        if (S1.keyToCond2.equals("Y")){         userMode = "Y";            }
        else if (S1.keyToCond2.equals("S")){    userMode = "S";            }            
        return userMode;
    }

    // COND2 : get appropriate IP address from userInput and connect to server
    public String cond2(){
        String userIP = "errorip";          // --> keyToCond3
        boolean connected = false;
        // set stage(JPanel) object and JFrame
        stage2 S2 = new stage2();
        F.setContentPane(S2);
        F.revalidate();
        F.repaint();
        // get userinput until get valid IP and success to connect
        while(!connected){
            print("2 : wait for user valid IP ");
            userIP = S2.keyToCond3;

            try{                
                socket = new Socket (userIP, 8080);  
                print("2 : success to connect socket");
                connected=true;
            }catch(Exception e){ 
                print("2 : invalid ip input"); 
                try {   Thread.sleep(100);     } 
                catch (InterruptedException es) {}   
            }
        }
        print("2 : valid ip input");

        // init streams
        try{    inFromServ = new DataInputStream(socket.getInputStream());
                outToServ = new DataOutputStream(socket.getOutputStream());
                print("2 : success to make input output stream");
        } catch (Exception e){
                print("2 : fail to make input output stream");
                e.printStackTrace();
        }
        return userIP;
    }

    // COND3 : start chatting
    public void cond3(){
        // set stage(JPanel) object and JFrame
        stage3 S3 = new stage3();
        F.setContentPane(S3);
        F.revalidate();
        F.repaint();
        // chatting while true
        print("3 : start chatting");
        
        Cthread_send SendTHR = new Cthread_send(S3, outToServ);
        Cthread_recv RecvTHR = new Cthread_recv(S3, inFromServ, F);
        print("success to create 2 thread");
        SendTHR.start();
        RecvTHR.start();
        print("success to start 2 thread");
    }

    // some useful methods -------------------------------------------------------------

    public void print (String printMessage){
        System.out.println("    cond" + printMessage);
    }
    public void write (String sendMessage){
        try{    
            outToServ.writeUTF(sendMessage); 
            print(" : success to write");                   }
        catch (Exception e) { 
            print(" : fail to write"); e.printStackTrace(); }
    }
    public String read (){
        String receiveMessage = ""; 
        try{    
            receiveMessage = inFromServ.readUTF();  
            print(" : success to read");                   }
        catch (Exception e) { 
            print(" : fail to read");                       }
        return receiveMessage;
    }

    // movable frame -------------------------------------------------------------

    private int posX = 0;
    private int posY = 0;

    // method makeFrameMove -> make calculatorGUI Frame draggable
    void makeFrameMove(JFrame F) {
        F.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                posX = e.getX();
                posY = e.getY();
            }
        });

        F.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                F.setLocation(e.getXOnScreen() - posX, e.getYOnScreen() - posY);
            }
        });
    }

    // method makeFrame -> set opntion for Frame, and make it Visible
    void makeFrame(JFrame F) {
        F.setSize(400,500); // calculator 크기 설정
        F.setUndecorated(true); // 창 테두리 안 보이도록 설정
        F.setBackground(new Color(0, 0, 0, 0)); // 창 테두리 없애고 남은 사각 배경을 투명으로 설정
                                                // Color(R, G, B, Transparency)

    }
}