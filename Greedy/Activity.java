import java.util.*;
public class Activity {
    public static void main(String args[]){
        int start[]={1, 3, 0, 5, 8, 5};
        int end[]={2, 4, 6, 7, 9, 9};

        //end time basis sorted
        int maxact=0;
        ArrayList<Integer> ans = new ArrayList<>();

        //1st activity
        maxact = 1;
        ans.add(0);
        int lastend= end[0];
        for(int i=1;i<end.length;i++){
            if(start[i]>=lastend){
                //activity select
                maxact++;
                ans.add(i);
                lastend = end[i];

            }
        }
        System.out.println("max activities ="+ maxact);
        for(int i=0;i<ans.size();i++){
            System.out.println("A"+ ans.get(i) + "");
        }
        
        
    }
   
    }

