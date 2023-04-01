import java.util.*;
public class duplicate {
    public static boolean isdup(String str){
        Stack<Character> s = new Stack<>();
        for(int i=0; i<str.length();i++){
            char ch = str.charAt(i);
            //closing
            if(ch == ')'){
                int count=0;
                while(s.peek() !='('){
                    s.pop();
                    count++;


                }
                if(count<1){
                    return true;//duplicate
                }else{
                    s.pop(); //opening pair
                }
                

            }
            else{
                //opening
                s.push(ch);
            }
            //opening


        }
        return false;

    }

    public static void main(String args[]){
        //valid string never empty
        String str = "((a+b))";//true
        String str2 = "(a+b)";//false
        System.out.println(isdup(str2));
    }
    
}
