import java.util.*;
public class Climbingstairs {
    public static int countwaysDP(int n, int ways[]){
        if(n==0){
            return 1;
        }
        if(n < 0){
            return 0;
        }

        if(ways[n] != -1){ //already calculated
            return ways[n];
        }
        ways[n] = countwaysDP(n-1, ways) + countwaysDP(n-2, ways);
        return ways[n];
    }
    public static int countways(int n){
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }

        return countways(n-1) + countways(n-2);
    }

    public static int countwaysTab(int n){
        int dp[] = new int[n+1];
        dp[0] = 1;

        //tabulation loop
        for(int i=0;i<=n;i++){
            if(i == 1){
                dp[i] = dp[i-1];
            }else{
                dp[i] = dp[i-1] + dp[i-2];
            }
            
        }
        return dp[n];

    }
    public static void main(String args[]){
        int n=5;
        int ways[] = new int[n+1]; // from 0 to 1 (n+1 indices)
        Arrays.fill(ways,-1); //fill arrays with -1

        System.out.println(countways(5));
    }
}
