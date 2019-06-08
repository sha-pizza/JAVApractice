

import java.io.*;
import java.net.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class guiClientFrame extends JFrame implements ActionListener {
    // init GUI objects
    Container C = new Container();
    JLabel JL = new JLabel("Received message...");
    JTextField JT = new JTextField("input your message...", 20);
    JButton JB = new JButton("Send");

    // create Socket objects
    guiClientObject CLNT = new guiClientObject();
    Socket C_socket;
         
    // Constructor
    public guiClientFrame(){
        // GUI setting
        JB.addActionListener(this);
        C.setLayout(new FlowLayout());
        C.add(JT);
        C.add(JB);
        C.add(JL);

        // Frame.this setting
        setContentPane(C);
        setSize(350, 100);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        
        // init socket
        try {                   C_socket = new Socket ("127.0.0.1", 4545); 
                                System.out.println("CLNT : OPEN ! ");       }
        catch (Exception e) {   e.printStackTrace();              }  
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String returnedSTR = CLNT.start(C_socket, JT.getText());  
        
        if (returnedSTR.equals("QUIT")){
            try{    C_socket.close(); 
                    System.exit(1);         }
            catch (Exception E){ E.printStackTrace(); }
        }
    }
}