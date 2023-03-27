import java.util.*;
public class pairsum {
    public static boolean sum2(ArrayList<Integer>list,int target){
        int bp=-1;
        int n=list.size();

        for(int i=0;i<list.size();i++){

            if (list.get(i)>list.get(i+1)){//breaking point
                bp=i;
                break;
            }
        }
        int lp=bp+1;
        int rp=bp;
        while(lp!=rp){
            if(list.get(lp)+list.get(rp)==target){
                return true;
            }
            //case 2
            if(list.get(lp)+list.get(rp)<target){
                 lp=(lp+1)%n;
            }
            else{
                 rp=(n+rp-1)%n;
            }
        }
        return false;

    }
    public static boolean sum(ArrayList<Integer>list,int target){
        int lp=0;
        int rp=list.size()-1;

        while(lp!=rp){
            if(list.get(lp)+list.get(rp)==target){
                return true;
            }

            if(list.get(lp)+list.get(rp)<target){
                lp++;
            }
            else{
                rp--;
            }
        }
        return false;
    }
    public static void main(String args[]){
        ArrayList<Integer> list= new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        int target=16;

        System.out.println(sum2(list,target));
    }
    
}
