package p1calculator;

import javax.swing.*;

public class B_Screen{
    /*
    ** instance var
    */
    D_Label[] ScreenValue = new D_Label[48];        // 결과 스크린의 맨 위 4줄은 수식 입력을 위한 공간이다
                                                    // input은 48자 까지만 받는다
    D_Label[] ResultValue = new D_Label[12];        // 결과 스크린의 맨 아래 한 줄은 결과 표출을 위한 공간이다.
                                                    // result는 12자까지만 표시한다
    int inputTail = 0;                              // ScreenValue의 입력된 가장 마지막 부분을 기록


    /*
    ** init Screen : set default icons on screen
    */
    void initScreen (JPanel P){
        // init ScreenValue
        int k1=0;
        for (int i=63 ; i<=153 ; i=i+30){           // 4행
            for (int j=42 ; j<=240 ; j=j+18){       // 12열로 표시한다!   
                ScreenValue[k1] = new D_Label();
                ScreenValue[k1].initLabel(j, i);                                              
                k1++;                               }   }
            
        // add ScreenValue particles on Panel
        for (int i=0 ; i<ScreenValue.length ; i++ ){
            P.add(ScreenValue[i]);                  }
    
        // init ResultValue
        int k2=0;
        for (int i=42 ; i<=240 ; i=i+18){           // 1행 12열로 표시한다
            ResultValue[k2] = new D_Label();   
            ResultValue[k2].initLabel(i, 192);;
            k2++;                                   }   

        // add ResultValue particles on Panel
        for (int i=0 ; i<ResultValue.length ; i++ ){
            P.add(ResultValue[i]);                  }

    }
    
    
    /*
    ** get Input
    */
    // get Input from Number Button
    void getInput(C_NumbButton NB){
        ScreenValue[inputTail].setLabel(NB.Value, NB.Label_Icon);
        //ScreenValue[inputTail].setIcon(NB.Label_Icon);
        //ScreenValue[inputTail].Value = NB.Value;
        inputTail++;
    }

    // get Input from Operator Button
    void getInput(C_OperButton OB){
        ScreenValue[inputTail].setLabel(OB.Value, OB.Label_Icon);
        //ScreenValue[inputTail].setIcon(OB.Label_Icon);
        //ScreenValue[inputTail].Value = OB.Value;
        inputTail++;
    }

    // get Input from Special Button
    void getInput(C_SpecButton SP){
        if(SP.Value == 'p'){                                // Power Button
            System.exit(0);                                 }

        else if (SP.Value == 'c'){                          // Clear Button 
            for (int i=0 ; i<ScreenValue.length ; i++){
                ScreenValue[i].deleteLabel();   }
            for (int i=0 ; i<ResultValue.length ; i++){
                ResultValue[i].deleteLabel();   }
            inputTail=0;                                    }

        else if (SP.Value == '<'){                          // Delete Button
            if (inputTail>0){                          
                ScreenValue[inputTail-1].deleteLabel();
                inputTail--;                        }       }

        else if (SP.Value == '='){                          // is Button
            if (inputTail==0){
                // 아무것도 입력되지 않았을 경우 그냥 지나간다
                System.out.println("Nothing to calcal");
                return;
            }
            else if (ScreenValue[inputTail-1].Value=='+' || ScreenValue[inputTail-1].Value=='-' ||
                     ScreenValue[inputTail-1].Value=='*' || ScreenValue[inputTail-1].Value=='/' ){
                 // ==바로 전에 부호가 입력되었을 경우 지우기
                ScreenValue[inputTail-1].deleteLabel();
                inputTail--;
            }
            char[] result = B_Function.calculValue(ScreenValue);
            showResult(result);
        }
        else {
            System.out.println("nonkind SpecButton");       }
    }

    /*
    ** check Input
    */
    // check invalid NUMBER BUTTON input
    boolean checkInput(C_NumbButton NB){                           
                                                                /* 모든 Number Button에 대해 */
        if (inputTail==0 && NB.Value=='0')  {return false;}     // 아무것도 없을 때 0 입력할 경우 에러  
        if (inputTail>47)                   {return false;}     // 48자리 이상 입력할 경우 에러
        if (inputTail>1 && ScreenValue[inputTail-1].Value=='/' && NB.Value=='0') {return false;} // / 뒤에 0 올 경우 에러
        
        return true;    }

    // check invalid OPERATOR BUTTON input
    boolean checkInput(C_OperButton OP){                        
                                                                /* 모든 Operator Button에 대해 */
        if (inputTail>47)                   {return false;}     // 48자리 이상 입력할 경우 에러
        
        else if (OP.Value =='.'){                               /* '.' Operator에 대해 */
            if (inputTail==0)               {return false;}     // 아무것도 없을 때 0 입력할 경우 에러

            char preV = ScreenValue[inputTail-1].Value;         // 바로 이전에 입력된 값을 확인해서
            if (preV=='+' || preV=='-' ||
                preV=='*' || preV=='/')     {return false;}     // 앞에 +-*/있으면 에러
    
            for (int i=inputTail-1 ; i>0 ; i--){
                char tmpV = ScreenValue[i].Value;               //한 수 안에 소수점'.'이 두개 들어갈 수 없음
                if (tmpV == '.')            {return false;}
                else if (tmpV=='+' || tmpV=='-' || tmpV=='*' || tmpV=='/'){break;}
            }
        }

        else {                                                  /* +,-,*,/ Operator에 대해 */
            if (inputTail==0)               {return false;}     // 아무것도 없을 때  입력할 경우 에러
            char preV = ScreenValue[inputTail-1].Value;         // 바로 이전에 입력된 값 확인해서
            if (preV=='+' || preV=='-' ||
                preV=='*' || preV=='/')     {return false;}     // 앞에 +-*/ 가 있을 경우 에러
        }
        return true;
    }


    /*
    ** showResult   
    */
    // showResult   -> 계산한 정답을 보여준다
    void showResult (char[] result){
        int strlen = result.length;

        // 답이 12자보다 긴 경우 나머지는 ...로 표시한다
        if (strlen>=12){
            for (int i=0 ; i<11 ; i++){
                ImageIcon icon = findIcon(result[i]);
                ResultValue[i].setLabel('n', icon);
            }
            ResultValue[11].setLabel('n', new ImageIcon("p1calculator/img/Ndts.png")); 
        }
        else{
            for (int i=0 ; i<strlen ; i++){
                ImageIcon icon = findIcon(result[i]);
                ResultValue[i].setLabel('n', icon);
            }
        }
    }
    // findIcon     -> 계산한 정답 표시를 위한 아이콘을 찾는다
    ImageIcon findIcon(char C){
        ImageIcon icon = new ImageIcon();
        if (C=='0')         {icon= new ImageIcon("p1calculator/img/N0.png");}
        else if (C=='1')    {icon= new ImageIcon("p1calculator/img/N1.png");}
        else if (C=='2')    {icon= new ImageIcon("p1calculator/img/N2.png");}
        else if (C=='3')    {icon= new ImageIcon("p1calculator/img/N3.png");}
        else if (C=='4')    {icon= new ImageIcon("p1calculator/img/N4.png");}
        else if (C=='5')    {icon= new ImageIcon("p1calculator/img/N5.png");}
        else if (C=='6')    {icon= new ImageIcon("p1calculator/img/N6.png");}
        else if (C=='7')    {icon= new ImageIcon("p1calculator/img/N7.png");}
        else if (C=='8')    {icon= new ImageIcon("p1calculator/img/N8.png");}
        else if (C=='9')    {icon= new ImageIcon("p1calculator/img/N9.png");}
        else if (C=='.')    {icon= new ImageIcon("p1calculator/img/Ndot.png");}
        else if (C=='d')    {icon= new ImageIcon("p1calculator/img/Ndts.png");}
        else if (C=='E')    {icon= new ImageIcon("p1calculator/img/NE.png");}
        else if (C=='-')    {icon= new ImageIcon("p1calculator/img/Nmin.png");}
        else {
            System.out.println("wrong input");  }  
        return icon;
    }
}