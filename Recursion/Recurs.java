public class Recurs {
    public static void printdec(int n){
        if(n==1){
            System.out.print(n);
            return;
        }
        System.out.print(n + " ");
        printdec(n-1);
}
public static void printinc(int n){
    if(n==1){
        System.out.print(n+" ");
        return;
    }
    printinc(n-1);
    System.out.print(n + " ");
}
public static int fact(int n){
    if(n==0){
        return 1;
    }
    int fnm1=fact(n-1);
    int fn=n*fact(n-1);
    return fn;
}
public static int calcsum(int n){
    if(n==1){
        return 1;
    }
    int snm1=calcsum(n-1);
    int sn=n+calcsum(n-1);
    return sn;

}
public static int fib(int n){
    if(n==0 || n==1){
        return n;
    }
    int fnm1=fib(n-1);
    int fnm2=fib(n-2);
    int fn=fnm1+fnm2;
    return fn;

}
public static boolean isSorted(int arr[],int i){
    if(i==arr.length-1){
        return true;
    }
    if(arr[i]>arr[i+1]){
        return false;
    }
    return isSorted(arr,i+1);

}
public static int firstOccurence(int arr[],int key,int i){
    if(i==arr.length){
        return -1;
    }
if(arr[i]==key){
    return i;
}
return firstOccurence(arr,key,i+1);
}
public static int lastOccurence(int arr[],int key,int i){
    int isFound=lastOccurence(arr,key,i+1);
    if(i==arr.length){
        return -1;
    }
    if(isFound != -1){
        return isFound;
    }
    //check with self 
    if(arr[i]==key){
        return i;

    }
    return isFound;
}
public static int power(int x,int n){
    if(n==0){
        return 1;
    }
    //int xnm1=power(x,n-1)
    return x*power(x,n-1);

}
public static int optimizedpower(int a,int n){

if(n==0){
    return 1;
}
int halfpower=optimizedpower(a,n/2);
int halfpowersq=halfpower * halfpower;//optimized TC=O(logn)
//int halfpowersq=optimizedpower(a,n/2)*optimizedpower(a,n/2);
//n is odd
if(n%2 !=0){
    halfpowersq=a *halfpowersq; 
}
return halfpowersq;
}
public static void main(String args[]){
        //int n=5;
        //int arr[]={8,3,6,9,5,10,2,5,3};
        System.out.print(power(2,10));
    }
}
