package w6gui;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Calculator implements ActionListener {

    public static void main(String[] args){
        JFrame F = new JFrame("CALCUL");
        JPanel P = new JPanel();
        JButton[] numB = new JButton[10];
        JButton[] operB = new JButton[10];
        JButton[] etcB = new JButton[4];        

        // make a gridlayout 4*6
        GridBagConstraints[] GBC = new GridBagConstraints[24];
        GridBagLayout GBL = new GridBagLayout();
        P.setLayout(GBL);

        // set number buttons
        setNumButtons(numB);
        // set operator buttons
        setOperatorButtons(operB);
        // set etc buttons
        setETCButtons(etcB);

        // arrange small buttons (0,0)~(5,3) in panel
        setGBC(GBC);
        arrangeButtons(P, GBC, numB, operB, etcB);

        // arrange final-calcul button (6,0-3) in panel
        JButton calculB = new JButton("CALCUL");
        GridBagConstraints calculG = new GridBagConstraints();
        calculG.gridx = 0;
        calculG.gridy = 6;
        calculG.gridwidth = 4;
        calculG.fill = GridBagConstraints.BOTH;
        P.add(calculB, calculG);

        // arrange a label to show result value
        int ResultValue = 0;
        JLabel ResultLabel = new JLabel("\nRESULT : "+ResultValue+"\n");
        GridBagConstraints LB = new GridBagConstraints();
        LB.gridx = 0;
        LB.gridy = 7;
        LB.gridwidth = 4;
        P.add(ResultLabel, LB);

        // imple panel on frame
        F.setContentPane(P);
        F.setSize(300,320);
        F.setVisible(true);
        F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    
    public static void setNumButtons(JButton[] B){
        for (int i=0 ; i<10 ; i++){
            B[i] = new JButton(Integer.toString(i));
        }
    }
    public static void setOperatorButtons(JButton[] B){
        B[0] = new JButton("ON");
        B[1] = new JButton("CA");
        B[2] = new JButton("=");
        B[3] = new JButton("+");
        B[4] = new JButton("-");
        B[5] = new JButton("*");
        B[6] = new JButton("/");
        B[7] = new JButton(".");
        B[8] = new JButton("%");
        B[9] = new JButton("+/-");
    }
    public static void setETCButtons(JButton[] B){
        B[0] = new JButton("R-CM");
        B[1] = new JButton("M-");
        B[2] = new JButton("M+");
        B[3] = new JButton("root");
    }
    public static void arrangeButtons(JPanel P, GridBagConstraints[] GBC, JButton[] numB, JButton[] operB, JButton[] etcB){
        // 1 line           ON  CA  =   +
        P.add(operB[0], GBC[0]);
        P.add(operB[1], GBC[1]);
        P.add(operB[2], GBC[2]);
        P.add(operB[3], GBC[3]);
        // 2 line           7   8   9   -
        P.add(numB[7], GBC[4]);
        P.add(numB[8], GBC[5]);
        P.add(numB[9], GBC[6]);
        P.add(operB[4], GBC[7]);
        // 3 line           4   5   6   *
        P.add(numB[4], GBC[8]);
        P.add(numB[5], GBC[9]);
        P.add(numB[6], GBC[10]);
        P.add(operB[5], GBC[11]);
        // 4 line           1   2   3   /
        P.add(numB[1], GBC[12]);
        P.add(numB[2], GBC[13]);
        P.add(numB[3], GBC[14]);
        P.add(operB[6], GBC[15]);
        // 5 line           0   .   %   +/-
        P.add(numB[0], GBC[16]);
        P.add(operB[7], GBC[17]);
        P.add(operB[8], GBC[18]);
        P.add(operB[9], GBC[19]);
        // 6 line           RCM M-  M+  ROOT
        P.add(etcB[0], GBC[20]);
        P.add(etcB[1], GBC[21]);
        P.add(etcB[2], GBC[22]);
        P.add(etcB[3], GBC[23]);
    }

    // set GBC to 6*4 layout
    public static void setGBC(GridBagConstraints[] GBC){
        for (int i=0 ; i<24 ; i++){
            int X = i%4;
            int Y = i/4;
            GBC[i]=new GridBagConstraints();
            GBC[i].gridx = X;
            GBC[i].gridy = Y;
            GBC[i].fill = GridBagConstraints.BOTH;
        }
    }

}