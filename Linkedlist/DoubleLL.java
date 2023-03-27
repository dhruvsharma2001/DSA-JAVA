public class DoubleLL {
    public  class Node{
        int data;
        Node next;
        Node prev;

        public Node(int data){
            this.data=data;
            this.next=null;
            this.prev = null;
        }
    }
        public static Node head;
        public static Node tail;
        public static int size;

        public void addfirst(int data){
            Node newnode = new Node(data);
            size++;
            if(head==null ){
                head = tail =newnode;
                return;
            }
            newnode.next = head;
            head.prev = newnode;
            head = newnode;

        }
        //print
        public void print(){
            
            Node temp=head;
            while(temp!=null){
                System.out.print(temp.data + "<->");
                temp=temp.next;
    
            }
            System.out.println("null");
    
        }
        //remove
        public int removefirst(){
            if(head==null){
                System.out.println("ll is empty");
                return Integer.MIN_VALUE;
            }
            else if(size==1){
                int val=head.data;
                head=tail=null;
                size--;
                return val;
    
    
            }
            int val=head.data;
            head=head.next;
            head.prev = null;
            size--;
            return val;
    
        }




    public static void main(String args[]){
        DoubleLL dll = new DoubleLL();

        dll.addfirst(3);
        dll.addfirst(2);
        dll.addfirst(1);

        dll.print();
        System.out.println(dll.size);
     }
}

