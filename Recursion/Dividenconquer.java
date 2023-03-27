public class Dividenconquer {
    public static void printarr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");

        }
        System.out.println();
}
    public static void mergesort(int arr[],int si,int ei){
    if(si>=ei){
        return;
    }
//kaam
int mid=si +(ei-si)/2;
mergesort(arr,si,mid);//left part
mergesort(arr,mid+1,ei);//right part
merge(arr,si,mid,ei);
}
public static void merge(int arr[],int si,int mid,int ei){
int temp[]=new int[ei-si+1];
int i=si;//left part
int j=mid+1;// right part
int k=0;//iterator for temp arr

while(i<=mid&&j<=ei){
if (arr[i]<arr[j]){
    temp[k]=arr[i];
    i++;
}
else{
    temp[k]=arr[j];
    j++;

}
k++;
}          
            //left
        while(i<=mid){
            temp[k++]=arr[i++];

        }
        //right
        while(j<=ei){
            temp[k++]=arr[j++];

        }
        //copy temp to original
        for(k=0,i=si;k<temp.length;k++,i++){
            arr[i]=temp[k];

        }
}
public static void quicksort(int arr[],int si,int ei){
    if(si>=ei){
        return;
    }
    //last element
    int pIdx = partition(arr,si,ei);
    quicksort(arr,si,pIdx-1);//left
    quicksort(arr,pIdx+1,ei);//right
    }
    public static int partition(int arr[],int si,int ei){
        int piv=arr[ei];
        int i=si-1;//to make place elements smaller than pivot
        for(int j=si;j<ei;j++){
            if (arr[j]<=piv){
                i++;
                //swap
                int temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;


            }

        }
                i++;
                
                int temp=piv;
                arr[ei]=arr[i];
                arr[i]=temp;
                return i;

    }
public static void main(String args[]){
    int arr[]={6,3,9,5,2,8};
    quicksort(arr,0,arr.length-1);
    //mergesort(arr,0,arr.length-1);
    printarr(arr);

}
}
