import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class stage3 extends JPanel implements ActionListener{
    String keyToCond4 = ""; // in stage 3, key to cond4 is "start game" message from server
    VLabel[] log;
    JButton JB;
    JTextField JT;
    String sendMessage = "";

    // set stage2
    public stage3 (){
        // set label text
        setLayout(null);

        log = new VLabel[18];
        for (int i=0 ; i<18 ; i++){
            log[i]=new VLabel("", 18);
            log[i].setBounds(20, (i*21)+30, 360, 21);
            this.add(log[i]);
        }
        // set exit button
        JB = new JButton();
        JB.setBounds(360, 0, 40, 40);
        JB.setBorder(null);
        JB.setBackground(new Color(0,0,0,0));
        JB.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) { 
                print(" : exit button pressed!");
                System.exit(0); }
        });
        
        // set textfield
        JT = new JTextField("press enter to send message...", 40);
        JT.setBackground(new Color(0, 0, 0, 255));
        JT.setForeground(new Color(0, 255, 150, 255));
        JT.setFont(Client.OCR18);
        JT.setBorder(null);
        JT.setBounds(20, 440, 360, 50);
        
        // MAKE IT FOCUSABLE
        this.setFocusable(true);
        this.add(JT);
        this.add(JB);
        JT.addActionListener(this);
    }
    // set background
    public void paintComponent(Graphics G) {
        ImageIcon icon = new ImageIcon("wall2.jpg");
        G.drawImage(icon.getImage(), 0, 0, null);
        setOpaque(false);
        super.paintComponent(G);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        sendMessage = JT.getText();
        print(" : " + sendMessage);
        JT.setText("");
    }

    // some useful methods -------------------------------------------------------------

    public void print (String printMessage){
        System.out.println("        stage3" + printMessage);
    }
}