package p1calculator;

import javax.swing.*;
import java.awt.event.*;

public class C_NumbButton extends JButton{
    /*
    ** instance var
    */
    char Value;
    ImageIcon Icon;
    ImageIcon Label_Icon;
    private static final long serialVersionUID = 1L;

	public void setValue(ImageIcon icon, char V, int posX, int posY, ImageIcon L_Icon) {
        // 파라미터를 통해 받은 정보들로 버튼 설정
        Icon = icon;                    // 아이콘을 인스턴스로 저장
        Value = V;                      // 버튼에 해당하는 값을 인스턴스로 저장
        setIcon(null);                  // 버튼의 디폴트 이미지는 배경 이미지에 박아두었다. project/img/Aback.png참고
        setBounds(posX, posY, 60, 42);  // 버튼의 위치 (posX, posY), 버튼의 크기(60,42로 고정)
        
        Label_Icon=L_Icon;              // 해당 버튼을 눌렀을 때 스크린에 띄울 라벨의 아이콘 저장
        

        // 버튼의 테두리가 보이지 않도록 설정
        setBackground(null);
        setBorderPainted(false);
        setFocusPainted(false);
        setContentAreaFilled(false);

        // 마우스를 눌렀을 때 눌리는 이미지로 바뀌었다가, 손을 떼면 원상복구시기는 MouseListener
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {    setIcon(Icon);      }   // 눌렀을 때
            public void mouseReleased(MouseEvent e) {   setIcon(null);      }   // 떼었을 때
        });
	}
    
}