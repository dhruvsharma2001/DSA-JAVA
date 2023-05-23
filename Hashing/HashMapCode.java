import java.util.*;
public class HashMapCode {
    static class HashMap<K,V>{ //generic
        private class Node{
            K key;
            V value;

            public Node(K key, V value){
                this.key = key;
                this.value = value;
            }
        }

            private int n; //n
            private int N;
            //private int arr[];
            private LinkedList<Node> buckets[]; //N
            //N = buckets.length LinkedList is the type of array

            @SuppressWarnings("uncheked")
            public HashMap(){
                this.N = 4;
                this.buckets = new LinkedList[4];
                for(int i=0;i<4;i++){
                    this.buckets[i] = new LinkedList<>();
                }
            }
            private int hashfunction(K key){
                int hc = key.hashCode();
                return Math.abs(hc) % N;

            }
            private int searchinLL(K key, int bi){
                LinkedList<Node> ll = buckets[bi];
                int di = 0;

                for(int i=0; i<ll.size();i++){
                    Node node = ll.get(i);
                    if(node.key == key){
                        return di;
                    }
                    di++;
                }
                return -1;

            }
            @SuppressWarnings("uncheked")
            private void rehash(){
                LinkedList<Node> oldbuck[] = buckets;
                buckets = new LinkedList[N*2];
                N = N*2;
                for(int i =0;i<buckets.length; i++){
                    buckets[i] = new LinkedList<>();
                }

                //nodes ->add in bucket
                for(int i=0;i<oldbuck.length;i++){
                    LinkedList<Node> ll = oldbuck[i];
                    for(int j=0;j<ll.size();j++){
                        Node node = ll.remove();
                        put(node.key , node.value);
                    }
                }

            }

        
        public void put(K key, V value){
            int bi = hashfunction(key);//gives the bucket index 0 to 3
            int di = searchinLL(key, bi);// gives the linked list index inside the bucket //valid or -1

            if(di!=-1){
                Node node = buckets[bi].get(di);
                node.value = value;
            }else{
                buckets[bi].add(new Node(key, value));
                n++;
            }

            double lambda = (double)n/N;
            if(lambda>2.0){
                rehash();
            }

        }

        public boolean containsKey(K key){
            int bi = hashfunction(key);//gives the bucket index 0 to 3
            int di = searchinLL(key, bi);// gives the linked list index inside the bucket //valid or -1

            if(di!=-1){
               return true;
            }else{
                return false;
            }
        }

        public  V remove(K key){
            int bi = hashfunction(key);//gives the bucket index 0 to 3
            int di = searchinLL(key, bi);// gives the linked list index inside the bucket //valid or -1

            if(di!=-1){
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            }else{
                return null;
            }
        }

        public  V get(K key){
            int bi = hashfunction(key);//gives the bucket index 0 to 3
            int di = searchinLL(key, bi);// gives the linked list index inside the bucket //valid or -1

            if(di!=-1){
                Node node = buckets[bi].get(di);
                return node.value;
            }else{
                return null;
            }
        }

        public ArrayList<K> keySet(){
            ArrayList<K> keys = new ArrayList<>();
            for(int i =0;i<buckets.length; i++){
                LinkedList<Node> ll = buckets[i];
                for (Node node:ll){
                    keys.add(node.key);
                
                }
            }
            return keys;
        }

        public boolean isEmpty(){
            return n==0;
        }
    }
    public static void main(String args[]){
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("india", 100);
        hm.put("china", 150);
        hm.put("us", 50);
        hm.put("nepal", 5);

        ArrayList<String> keys = hm.keySet();
        for (String key:keys){
            System.out.println(key);
        
        }
            
        }
}
