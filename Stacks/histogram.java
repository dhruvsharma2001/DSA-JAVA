import java.util.*;
public class histogram {
    public static void maxArea(int arr[]){
        int maxarea = 0;
        int nsr[] = new int[arr.length];//next smaller right
        int nsl[] = new int[arr.length];//next smaller left

        //next smaller right
        Stack<Integer> s = new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            //while
            while(!s.isEmpty() && arr[s.peek()]>=arr[i]){
                s.pop();
               }
            //ifelse
            if(s.isEmpty()){
                nsr[i] = arr.length;
            }else{
                nsr[i] = s.peek();
            }

            //push in s
            s.push(i);
        }
        //next smaller left
        for(int i=0;i<arr.length;i++){
            //while
            while(!s.isEmpty() && arr[s.peek()]>=arr[i]){
                s.pop();
               }
            //ifelse
            if(s.isEmpty()){
                nsl[i] = -1;
            }else{
                nsl[i] = s.peek();
            }

            //push in s
            s.push(i);
        }
        //calculate area: width = j-i-1=nsr[i]-nsl[i]-1
        for(int i=0;i<arr.length;i++){
            int height = arr[i];
            int width = nsr[i]-nsl[i]-1;
            int currarea = height * width;
            maxarea = Math.max(currarea,maxarea);

        }
        System.out.println("max area in histogram = " + maxarea);


    }
    public static void main(String args[]){
        int arr[] = {2, 1, 5, 6, 2, 3};//heights
        maxArea(arr);
    }
}
