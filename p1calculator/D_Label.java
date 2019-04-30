package p1calculator;

import javax.swing.*;

public class D_Label extends JLabel{
    /*
    ** instance vars
    */
    private static final long serialVersionUID = 1L;
    char Value = 'n';
    ImageIcon default_Icon = new ImageIcon();

    // 라벨을 최초 배치하기 위한 method
    public void initLabel(int posX, int posY){
        setIcon(default_Icon);
        setBounds(posX, posY, 15, 24);
    }
    // 라벨의 값과 아이콘 재설정
    public void setLabel(char V, ImageIcon Icon){
        this.setIcon(Icon);
        this.Value = V;
    }
    // 라벨의 값과 아이콘 삭제
    public void deleteLabel(){
        setIcon(default_Icon);
        Value = 'n';

    }
    
}