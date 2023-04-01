import java.util.*;
public class indiancoiins {
    public static void main(String args[]){
         //not int(primitive) Integer is class
        Integer coins[]={1, 2, 5, 10, 20, 50, 100, 500, 2000};

        Arrays.sort(coins,Comparator.reverseOrder());

        int countofcoins = 0;
        int amount = 590;
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=0;i<coins.length;i++){

            if(coins[i]<=amount){
                while(coins[i]<=amount){
                    countofcoins++;
                    ans.add(coins[i]);
                    amount -= coins[i];
                }
            }
        }
        System.out.println("countofcoins ="+ countofcoins);

        
        for(int i=0;i<ans.size();i++){
            System.out.println(ans.get(i)+ " ");

    }
    
}
}
