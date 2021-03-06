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
    // mouselistener을 사용하여, 마우스가 눌렸을 때의 좌표를 기록하고
    // 마우스를 드래그할 때 (눌린 순간의 좌표)를 기준으로 창을 움직일 수 있도록 합니다
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
        NumB[0].setValue(new ImageIcon("p1calculator/img/B0.png"), '0', 30, 411,  new ImageIcon("p1calculator/img/N0.png"));
        NumB[1].setValue(new ImageIcon("p1calculator/img/B1.png"), '1', 30, 369,  new ImageIcon("p1calculator/img/N1.png"));
        NumB[2].setValue(new ImageIcon("p1calculator/img/B2.png"), '2', 90, 369,  new ImageIcon("p1calculator/img/N2.png"));
        NumB[3].setValue(new ImageIcon("p1calculator/img/B3.png"), '3', 150, 369, new ImageIcon("p1calculator/img/N3.png"));
        NumB[4].setValue(new ImageIcon("p1calculator/img/B4.png"), '4', 30, 327,  new ImageIcon("p1calculator/img/N4.png"));
        NumB[5].setValue(new ImageIcon("p1calculator/img/B5.png"), '5', 90, 327,  new ImageIcon("p1calculator/img/N5.png"));
        NumB[6].setValue(new ImageIcon("p1calculator/img/B6.png"), '6', 150, 327, new ImageIcon("p1calculator/img/N6.png"));
        NumB[7].setValue(new ImageIcon("p1calculator/img/B7.png"), '7', 30, 285,  new ImageIcon("p1calculator/img/N7.png"));
        NumB[8].setValue(new ImageIcon("p1calculator/img/B8.png"), '8', 90, 285,  new ImageIcon("p1calculator/img/N8.png"));
        NumB[9].setValue(new ImageIcon("p1calculator/img/B9.png"), '9', 150, 285, new ImageIcon("p1calculator/img/N9.png"));
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
        OpeB[0].setValue(new ImageIcon("p1calculator/img/Bplu.png"), '+', 210, 243, new ImageIcon("p1calculator/img/Nplu.png"));
        OpeB[1].setValue(new ImageIcon("p1calculator/img/Bmin.png"), '-', 210, 285, new ImageIcon("p1calculator/img/Nmin.png"));
        OpeB[2].setValue(new ImageIcon("p1calculator/img/Bmul.png"), '*', 210, 327, new ImageIcon("p1calculator/img/Nmul.png"));
        OpeB[3].setValue(new ImageIcon("p1calculator/img/Bdiv.png"), '/', 210, 369, new ImageIcon("p1calculator/img/Ndiv.png"));
        OpeB[4].setValue(new ImageIcon("p1calculator/img/Bdot.png"), '.', 90, 411,  new ImageIcon("p1calculator/img/Ndot.png"));
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
        SpeB[0].setValue(new ImageIcon("p1calculator/img/Bon.png"), 'p', 30, 243, 60, 42);
        SpeB[1].setValue(new ImageIcon("p1calculator/img/Bc.png"), 'c', 90, 243, 60, 42);
        SpeB[2].setValue(new ImageIcon("p1calculator/img/Bdel.png"), '<', 150, 243, 60, 42);
        SpeB[3].setValue(new ImageIcon("p1calculator/img/Bis.png"), '=', 150, 411, 120, 42);

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