import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.awt.Font;
import java.io.DataInputStream;
import java.net.Socket;
import javax.swing.JFrame;

public class Client{
    // instance var : to connect
    static Socket socket;
    static User_basic user;
    static DataInputStream inFromServ;
    static DataOutputStream outToServ;

    // instance var : to struct gui
    static JFrame F = new JFrame();

    // set font
    static Font OCRA;
    static Font OCR18;
    static Font OCR24;
    static Font OCR60;

    public static void main (String[] args){
        print(" : start CLNT!");
        user = new User_basic(F, socket, inFromServ, outToServ);

        // set fonts
        File f = new File("OCRAEXT.TTF");
        try{
            FileInputStream in = new FileInputStream(f);
            OCRA = Font.createFont(Font.TRUETYPE_FONT, in);
            System.out.println("success to get font");
        } catch (Exception e){
            System.out.println("fail to get font");         }
        OCR18 = OCRA.deriveFont(20f);
        OCR24 = OCRA.deriveFont(24f);
        OCR60 = OCRA.deriveFont(60f);

        // COND1 : get "Y" if user want to enter chat
        print(" >> COND1");
        String userMode = user.cond1();
        print(" : get userMode : " + userMode);

        // COND2 : get appropriate IP address from userInput
        print(" >> COND2");
        String IP = user.cond2();
        print(" : get IP : " + IP);

        // COND3 : start to chatting
        print(" >> COND3");
        user.cond3();

    }


    // some useful methods -------------------------------------------------------------

    public static void print (String printMessage){
        System.out.println("CLNT" + printMessage);
    }
    public static void write (String sendMessage){
        try{    outToServ.writeUTF(sendMessage); }
        catch (Exception e) { e.printStackTrace(); }
    }
    

}