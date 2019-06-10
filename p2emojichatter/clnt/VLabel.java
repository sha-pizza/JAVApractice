import java.awt.Color;


import javax.swing.JLabel;

public class VLabel extends JLabel {
    int textsize;

    public VLabel(String text, int textsize) {
        this.setForeground(new Color(0, 255, 150, 255));        // green
        this.setText(text);
        switch (textsize){
            case 18 : this.setFont(Client.OCR18); break;
            case 24 : this.setFont(Client.OCR24); break;
            case 60 : this.setFont(Client.OCR60); break;
        }
    }

    // if input only textsize, you will get some cute imojis
    public VLabel(int textsize){
        this.setForeground(new Color(0, 255, 150, 255)); 
        int randNum = (int) (Math.random() * 10);
        switch(randNum){
            case 0 : this.setText(";[^m^];"); break;
            case 1 : this.setText("/(^A^)/"); break;
            case 2 : this.setText("*(;-;)*"); break;
            case 3 : this.setText("<[^o^]>"); break;
            case 4 : this.setText(";(YAY);"); break;
            case 5 : this.setText("/{^p^}/"); break;
            case 6 : this.setText("/{^p^}/"); break;
            case 7 : this.setText("V(ToT)V"); break;
            case 8 : this.setText("Y{OmO}Y"); break;
            case 9 : this.setText("<(6_6)>"); break;
        }
        switch (textsize){
            case 18 : this.setFont(Client.OCR18); break;
            case 24 : this.setFont(Client.OCR24); break;
            case 60 : this.setFont(Client.OCR60); break;
        }

    }

    public void SUPER(){
        this.setForeground(new Color(180, 0, 255, 255));        // purple
    }

    public void SUPERtrsp(){
        this.setForeground(new Color(180, 0, 255, 150));        // purple
    }

    public void BASIC(){
        this.setForeground(new Color(0, 255, 150, 255));        // green
    }

    public void BASICtrsp(){
        this.setForeground(new Color(0, 255, 150, 150));        // green
    }
}