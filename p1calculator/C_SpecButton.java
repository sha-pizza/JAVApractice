package p1calculator;

import javax.swing.*;
import java.awt.event.*;

public class C_SpecButton extends JButton{
    /*
     ** instance var
     */
    char Value;
    ImageIcon ICON;
    private static final long serialVersionUID = 1L;

	public void setValue(ImageIcon icon, char V, int posX, int posY, int width, int height) {
        // 파라미터를 통해 받은 정보들로 버튼 설정
        ICON = icon;                    // 아이콘을 인스턴스로 저장
        Value = V;                      // 버튼에 해당하는 값을 인스턴스로 저장
        setIcon(null);                  // 버튼의 디폴트 이미지는 배경 이미지에 박아두었다. project/img/Aback.png참고
        setBounds(posX, posY, width, height);  // 버튼의 위치 (posX, posY), 버튼의 크기(60,42로 고정) -> '='버튼만 예외로 크기(120,42)

        // 버튼의 테두리가 보이지 않도록 설정
        setBackground(null);
        setBorderPainted(false);
        setFocusPainted(false);
        setContentAreaFilled(false);

        // 마우스를 눌렀을 때 눌리는 이미지로 바뀌었다가, 손을 떼면 원상복구시기는 MouseListener
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {    setIcon(ICON);      }   // 눌렀을 때
            public void mouseReleased(MouseEvent e) {   setIcon(null);      }   // 떼었을 때
        });
	}
    
}