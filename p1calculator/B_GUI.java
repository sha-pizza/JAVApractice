package p1calculator;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class B_GUI {
    /*
    ** instance var
    */
    private int posX = 0;
    private int posY = 0;
    Timer T = new Timer();

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
    void makeFrame(JFrame F, JPanel P) {
        F.setSize(300, 525); // calculator 크기 설정
        F.setUndecorated(true); // 창 테두리 안 보이도록 설정
        F.setBackground(new Color(0, 0, 0, 0)); // 창 테두리 없애고 남은 사각 배경을 투명으로 설정
                                                // Color(R, G, B, Transparency)
        // Frame의 기타 설정
        F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        F.setContentPane(P);
        F.setVisible(true);
    }

    // method makeNumbButton -> make Number Buttons
    void makeNumbButton(JPanel P, C_NumbButton[] NumB) {
        // init and add button0~9
        for (int i = 0; i < NumB.length; i++) {
            NumB[i] = new C_NumbButton();
            P.add(NumB[i]);
        }
        // set some values for button0~9
        // setvalue (image, value of button, positionX, positionY)
        NumB[0].setValue(new ImageIcon("project1/img/B0.png"), '0', 30, 411, new ImageIcon("project1/img/N0.png"));
        NumB[1].setValue(new ImageIcon("project1/img/B1.png"), '1', 30, 369, new ImageIcon("project1/img/N1.png"));
        NumB[2].setValue(new ImageIcon("project1/img/B2.png"), '2', 90, 369, new ImageIcon("project1/img/N2.png"));
        NumB[3].setValue(new ImageIcon("project1/img/B3.png"), '3', 150, 369, new ImageIcon("project1/img/N3.png"));
        NumB[4].setValue(new ImageIcon("project1/img/B4.png"), '4', 30, 327, new ImageIcon("project1/img/N4.png"));
        NumB[5].setValue(new ImageIcon("project1/img/B5.png"), '5', 90, 327, new ImageIcon("project1/img/N5.png"));
        NumB[6].setValue(new ImageIcon("project1/img/B6.png"), '6', 150, 327, new ImageIcon("project1/img/N6.png"));
        NumB[7].setValue(new ImageIcon("project1/img/B7.png"), '7', 30, 285, new ImageIcon("project1/img/N7.png"));
        NumB[8].setValue(new ImageIcon("project1/img/B8.png"), '8', 90, 285, new ImageIcon("project1/img/N8.png"));
        NumB[9].setValue(new ImageIcon("project1/img/B9.png"), '9', 150, 285, new ImageIcon("project1/img/N9.png"));
    }

    // method makeOperButton -> make Operator Buttons
    void makeOperButton(JPanel P, C_OperButton[] OpeB) {
        // init and add +-*/
        for (int i = 0; i < OpeB.length; i++) {
            OpeB[i] = new C_OperButton();
            P.add(OpeB[i]);
        }
        // set some values for +-*/
        // setvalue (image, value of button, positionX, positionY)
        OpeB[0].setValue(new ImageIcon("project1/img/Bplu.png"), '+', 210, 243, new ImageIcon("project1/img/Nplu.png"));
        OpeB[1].setValue(new ImageIcon("project1/img/Bmin.png"), '-', 210, 285, new ImageIcon("project1/img/Nmin.png"));
        OpeB[2].setValue(new ImageIcon("project1/img/Bmul.png"), '*', 210, 327, new ImageIcon("project1/img/Nmul.png"));
        OpeB[3].setValue(new ImageIcon("project1/img/Bdiv.png"), '/', 210, 369, new ImageIcon("project1/img/Ndiv.png"));
        OpeB[4].setValue(new ImageIcon("project1/img/Bdot.png"), '.', 90, 411, new ImageIcon("project1/img/Ndot.png"));
    }

    // method makeSpecButton -> make Special Buttons
    void makeSpecButton(JPanel P, C_SpecButton[] SpeB) {
        // init and add +-*/
        for (int i = 0; i < SpeB.length; i++) {
            SpeB[i] = new C_SpecButton();
            P.add(SpeB[i]);
        }
        // set some values for +-*/
        // setvalue (image, value of button, positionX, positionY)
        SpeB[0].setValue(new ImageIcon("project1/img/Bon.png"), 'p', 30, 243, 60, 42);
        SpeB[1].setValue(new ImageIcon("project1/img/Bc.png"), 'c', 90, 243, 60, 42);
        SpeB[2].setValue(new ImageIcon("project1/img/Bdel.png"), '<', 150, 243, 60, 42);
        SpeB[3].setValue(new ImageIcon("project1/img/Bis.png"), '=', 150, 411, 120, 42);

    }

    // method errorScreen --> screen flickers 2 times 
    void setErrorScreen(JLabel eScreen) {

        T.schedule(new TimerTask(){
            @Override
            public void run() { eScreen.setVisible(true); }}, 1);
            
        T.schedule(new TimerTask(){
            @Override
            public void run() { eScreen.setVisible(false); }}, 200);
        
        T.schedule(new TimerTask(){
            @Override
            public void run() { eScreen.setVisible(true); }}, 400);
            
        T.schedule(new TimerTask(){
            @Override
            public void run() { eScreen.setVisible(false); }}, 600);
    
    }

}