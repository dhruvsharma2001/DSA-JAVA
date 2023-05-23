import java.util.*;
public class Insertion {
    static class heap{
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data){
            //add at last idx
            arr.add(data);

            int x = arr.size()-1;//x is child index
            int par = (x-1)/2; //parent index

            while(arr.get(x)<arr.get(par)){
                //swap
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);

                x=par;
                par =(x-1)/2;
            }
        }
        public int peek(){
            return arr.get(0);
        }
//-----------------HEAPIFY---------------------------
        private void heapify(int i){
            int left = 2*i+1;
            int right = 2*i+2;
            int minidx = i;

            if(left<arr.size() && arr.get(minidx)>arr.get(left)){
                minidx = left;
            }

            if(right<arr.size() && arr.get(minidx)>arr.get(right)){
                minidx = right;
            }

            if(minidx!=i){
                //swap
            int temp = arr.get(i);
            arr.set(i,arr.get(minidx));
            arr.set(minidx, temp);

            heapify(minidx);
            }

        }
//-------------------REMOVE--------------------------
        public int remove(){
            int data = arr.get(0);

            //step1 swap first and last
            int temp = arr.get(0);
            arr.set(0,arr.size()-1);
            arr.set(arr.size()-1, temp);

            //step 2 delete last node
            arr.remove(arr.size()-1);

            //step 3 heapify
            heapify(0);
            return data;
        }
        public boolean isEmpty(){
            return arr.size()==0;
        }
    }

    //-------------------MAIN FUNCTION-----------------
    public static void main(String args[]){
        heap h = new heap();
        h.add(3);
        h.add(4);
        h.add(1);
        h.add(5);

        while(!h.isEmpty()){
            System.out.println(h.peek());
            h.remove();
        }
        

    }
}
