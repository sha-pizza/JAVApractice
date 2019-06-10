import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class stage1 extends JPanel {
    String keyToCond2 = ""; // in stage 1, key to cond2 is "Y"
    VLabel title;
    VLabel VL;
    JButton JB;

    // set stage1
    public stage1() {
        // set label text
        setLayout(null);

        title= new VLabel(60);
        title.setBounds(0, 100, 400, 200);
        title.setHorizontalAlignment(JLabel.CENTER);
        
        VL = new VLabel("PRESS Y TO START",24);
        VL.setBounds(0, 300, 400, 100);
        VL.setHorizontalAlignment(JLabel.CENTER);
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
        this.add(JB);
        this.addKeyListener(new MyKeyListener());
    }
    // set background
    public void paintComponent(Graphics G) {
        ImageIcon icon = new ImageIcon("wall1.jpg");
        G.drawImage(icon.getImage(), 0, 0, null);
        setOpaque(false);
        super.paintComponent(G);
    }
    // set keylistener
    class MyKeyListener extends KeyAdapter {
        @Override 
        public void keyPressed(KeyEvent e) { 
            if (e.getKeyChar() == 'y' || e.getKeyChar() == 'Y') { 
                keyToCond2 = "Y";
                print(" : Y pressed");
            } 
        }   
    }

    // some useful methods -------------------------------------------------------------

    public void print (String printMessage){
        System.out.println("        stage1" + printMessage);
    }
    



    

}