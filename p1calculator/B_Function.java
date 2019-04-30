package p1calculator;

import java.util.ArrayList;

public class B_Function{

    static char[] calculValue(D_Label[] SV){
        
        // step 1       D_Label로부터 char array형태의 받은 식 추출
        ArrayList<Character> CH = new ArrayList<Character>();
        
        for (int i=0 ; i<SV.length ; i++){
            // 값을 다 읽어내고 더미n값만 남은 경우 break
            if (SV[i].Value=='n'){  break;  }
            CH.add (SV[i].Value);
        }
        System.out.print("CH : ");
        System.out.println(CH);
        
        // step 2       char array 형태의 받은 식에서 수와 부호를 구분해 string arrayList로 저장
        ArrayList<String> ST = new ArrayList<String>();
        String preV="";
        for (int i=0 ; i<CH.size() ; i++){
            char now = CH.get(i); // 현재값
            
            if( now=='+' || now=='-' || now=='*' || now=='/' ){         // step 2-1 부호일 경우 바로 string arraylist로 넣는다
                ST.add(preV);
                System.out.println("ST added : "+preV);
                preV="";
                ST.add( Character.toString(now) );
                System.out.println("ST added : "+ Character.toString(now));
            }

            else if (i==CH.size()-1){                                   // step 2-2 맨 끝값일 경우  prev에 붙이고 add 한다
                preV = preV + Character.toString(now) ;
                ST.add(preV);
                System.out.println("ST added : "+preV);
            }
            
            else{                                                       // step 2-3 '.' 또는 숫자일경우 이전에 가져오던 값에 붙인다.
                preV = preV + Character.toString(now) ;
            }
        }
        System.out.print("ST : "+ST);
        System.out.println(ST.size());

        // step 3       수집한 string arraylist의 처음부터 검사하며 계산한다
        double resultV = 0;
        try{
            for (int i=0 ; i<ST.size() ; i++){
                String nowS = ST.get(i);
                char nowC = ST.get(i).charAt(0);
                 
                if (nowC=='+' || nowC=='-' || nowC=='*' || nowC=='/' ){ // step 3-1 부호일 경우 일단 넘김
                    System.out.println("it is +-*/");
                }
                
                else if (i==0){                                         // step 3-2 첫 번째 수일 경우 resultV에 저장하고 넘김
                    resultV = Double.parseDouble(nowS);
                    System.out.println("first number!");
                }
                
                else{                                                   // step 3-3 부호 아닌 수일 경우 계산한다
                    char pre = ST.get(i-1).charAt(0);
                    // (계산해오던 resultV 값) (바로 전 연산자) (현재 값) 하여 계산한다
                    if      (pre=='+')  { resultV = resultV + Double.parseDouble(nowS);}
                    else if (pre=='-')  { resultV = resultV - Double.parseDouble(nowS);}
                    else if (pre=='*')  { resultV = resultV * Double.parseDouble(nowS);}
                    else if (pre=='/')  { resultV = resultV / Double.parseDouble(nowS);}
                    else {  System.out.println("it wasn't divided..."); }
                }
                System.out.println(i+" = "+nowS+" -> "+resultV);
            }
        }catch(Exception e){
            System.out.println("can't calculate! press Clear button and try it again.");
        }

        // step 4       계산에 성공한 값을 char array로 변형
        System.out.println("success : "+resultV);
        String tmpresult = Double.toString(resultV);
        char[] result = tmpresult.toCharArray();

        // step 5       결과 리턴
        return result;
    }
}