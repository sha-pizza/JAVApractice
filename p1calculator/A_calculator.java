package p1calculator;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class A_calculator implements ActionListener  {
    
    public static void main (String args[]){
        /*
        ** make (+init) static objects
        */
        JFrame F = new JFrame();          // Frame for whole GUI
        JPanel P;                         // Panel for whoel GUI

        B_GUI GUI = new B_GUI();          // GUI object
        B_Screen SCR = new B_Screen();    // Screen object

        C_NumbButton[] NumB = new C_NumbButton[10];     // Number Button objects array
        C_OperButton[] OpeB = new C_OperButton[5];      // Operator Button objects array
        C_SpecButton[] SpeB = new C_SpecButton[4];      // Special Button objects array


        /*
        ** set Panel
        */
        // init panel & put bachground image on
        ImageIcon icon = new ImageIcon("project1/img/Aback.png");
        P = new JPanel(){
            // default serialversionUID
            private static final long serialVersionUID = 1L;

            public void paintComponent(Graphics G) {
                G.drawImage(icon.getImage(), 0, 0, null);
                setOpaque(false);
                super.paintComponent(G);
            }
        };
        P.setLayout(null);


        /*
        ** set errorScreen
        */
        JLabel errorScreen = new JLabel();
        errorScreen.setIcon(new ImageIcon("project1/img/Aback_wrong.png"));
        errorScreen.setBounds(0, 0, 300, 525);
        errorScreen.setVisible(false);
        P.add(errorScreen);


        /*
        ** set Buttons
        */
        GUI.makeNumbButton(P, NumB);                                // set Number Buttons
        for (int i=0; i<NumB.length; i++){                          // add & set ActionListioner
            int ii = i;
            NumB[i].addActionListener( e -> {                       // ActionListener of NumberButton
                System.out.print("NumB in : " + NumB[ii].Value);
                
                if (SCR.checkInput(NumB[ii])){                      // check if Number Input is invalid
                    SCR.getInput(NumB[ii]);                         // if Number Input is valid, get Input
                    System.out.println(" -> is done");      }

                else {
                    GUI.setErrorScreen(errorScreen);                // else Number Input is invalid, show ErrorScreen
                    System.out.println(" -> is errorwork"); }
            });     
        }

        GUI.makeOperButton(P, OpeB);                                // set Operator Buttons
        for (int i=0; i<OpeB.length; i++){                          // add & set ActionListioner
            int ii = i;
            OpeB[i].addActionListener( e -> {                       // ActionListener of OperatorButton
                System.out.print("OpeB in : " + OpeB[ii].Value);

                if (SCR.checkInput(OpeB[ii])){                      // check if Operator Input is invalid
                    SCR.getInput(OpeB[ii]);                         // if Operator Input is valid, get Input
                    System.out.println(" -> is done");  }
                else {
                    GUI.setErrorScreen(errorScreen);                // else Operator Input is invalid, show ErrorScreen             
                    System.out.println(" -> is errorwork"); }
            });     
        }

        GUI.makeSpecButton(P, SpeB);                                // set Special Buttons
        for (int i=0; i<SpeB.length; i++){                          // add & set ActionListioner
            int ii = i;
            SpeB[i].addActionListener( e -> {                       // ActionListener of SpecialButton
                System.out.print("SpeB in : " + SpeB[ii].Value);
                SCR.getInput(SpeB[ii]);
                System.out.println(" -> is done");  
            });     
        }


        /*
        ** set Screen
        */
        SCR.initScreen(P);


        /*
        ** set Frame
        */
        GUI.makeFrameMove(F);
        GUI.makeFrame(F, P);
        
    }

    @Override
	public void actionPerformed(ActionEvent e) {
        // empty
    }
}