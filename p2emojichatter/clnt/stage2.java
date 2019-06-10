import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


  
public class stage2 extends JPanel implements ActionListener {
    String keyToCond3="eee"; // in stage 2, key to cond3 is valid IP
    VLabel title;
    VLabel VL;
    JTextField JT;
    JButton JB;
 
    // set stage2
    public stage2 (){
        // set label text
        setLayout(null);

        title= new VLabel(60);
        title.setBounds(0, 100, 400, 200);
        title.setHorizontalAlignment(JLabel.CENTER);

        VL = new VLabel("INPUT IP AND PRESS ENTER", 24);
        VL.setBounds(0, 300, 400, 50);
        VL.setHorizontalAlignment(JLabel.CENTER);
        // set textfield
        JT = new JTextField("...", 20);
        JT.setBackground(new Color(0, 0, 0, 255));
        JT.setForeground(new Color(0, 255, 150, 255));
        JT.setFont(Client.OCR24);
        JT.setBorder(null);
        JT.setBounds(10, 350, 380, 50);
        JT.setHorizontalAlignment(JTextField.CENTER);
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
        // MAKE IT FOCUSABLE
        this.setFocusable(true);
        this.add(title);
        this.add(VL);
        this.add(JT);
        this.add(JB);
        JT.addActionListener(this);
        
    }
    // set background
    public void paintComponent(Graphics G) {
        ImageIcon icon = new ImageIcon("wall1.jpg");
        G.drawImage(icon.getImage(), 0, 0, null);
        setOpaque(false);
        super.paintComponent(G);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        keyToCond3 = JT.getText();
        print(" : " + keyToCond3);
    }

    // some useful methods -------------------------------------------------------------

    public void print (String printMessage){
        System.out.println("        stage2" + printMessage);
    }
}    