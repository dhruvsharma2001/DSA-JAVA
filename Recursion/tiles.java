public class tiles {
    public static int tilingproblem(int n){  //2*n
        //base case
        if(n==0 || n==1){
            return 1;
        }
        //kaam
        //vertical
        int vertical=tilingproblem(n-1);
        //horizontal
        int horizontal=tilingproblem(n-2);
        int totways=vertical+horizontal;
        return totways;

    }
    public static void removeduplicates(String str,int indx,StringBuilder newstr,boolean map[]){
        if(indx==str.length()){
            System.out.println(newstr);
            return;
        }
        char currChar=str.charAt(indx);
        if(map[currChar-'a']==true){
            //duplicate
            removeduplicates(str,indx+1,newstr,map);

        }else{
            map[currChar-'a']=true;
            removeduplicates(str,indx+1,newstr.append(currChar),map);

        }

    }
    public static int friendspair(int n){
        if(n==1||n==2){
            return n;
        }
        //choice 
        //single
        //int fnm1=friendspair(n-1);
        //pair
        //int fnm2=friendspair(n-2);
        //int pairways=(n-1)*fnm2;
        //int totways=fnm1+pairways;
        //return totways;
        return friendspair(n-1)+(n-1)*friendspair(n-2);

    }
    public static void printbinstrings(int n,int lastplace,String str){
        if(n==0){
            System.out.println(str);
            return;

        }
        printbinstrings(n-1,0,str + "0");
        if(lastplace==0){
            printbinstrings(n-1,1,str+"1");
        }
    }
    public static void main(String args[]){
       // String str="dhruvruchika";
        //removeduplicates(str,0,new StringBuilder(""),new boolean[26]);
        //System.out.println(friendspair(3));
        printbinstrings(3,0,"");

    }
}
