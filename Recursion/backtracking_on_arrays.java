public class backtracking_on_arrays {
    public static void changearr(int arr[],int i,int val){
        //base case
        if(i==arr.length){
            printarr(arr);
            return;
        }
        //kaam
        arr[i] = val;
        changearr(arr,i+1,val+1);
        arr[i]=arr[i]-2;

    }
    public static void findsub(String str,String ans,int i){
        //base case
        if(i==str.length()){
            System.out.println(ans);
            return;
        }
        //yes choice
        findsub(str,ans+str.charAt(i),i+1);
        //no choice
        findsub(str,ans,i+1);


    }
    public static void findperm(String str,String ans){
        //base case
        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        //recursion
        for(int i=0; i<str.length();i++){
            char curr=str.charAt(i);
            //"abcde"=>"ad"+"de"="abde"
            String NewStr=str.substring(0, i) + str.substring(i+1);
            findperm(NewStr,ans+curr);



        }
    }
    public static void printarr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");

        }
        System.out.println();
    }

    public static void main(String args[]){
        String str="abc";
        //int arr[]=new int[5];
        //changearr(arr,0,1);
        //printarr(arr);
        //findsub(str,"",0);
        findperm(str,"");
        
    
    }
}