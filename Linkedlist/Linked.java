public class Linked {
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;


    public void addfirst(int data){
        //step1=create new node
        Node newnode =  new Node(data);
        size++;
        if(head==null){
            head=tail=newnode;
            return;
        }

        //step 2
        newnode.next= head;//link

        //step 3
        head=newnode;

    }
    public void addlast(int data){
        Node newnode=new Node(data);
        size++;
        if(head==tail){
            head=tail=newnode;
            return;


        }
        tail.next=newnode;
        tail=newnode;
    }
    public void print(){
        if(head==null){
            System.out.println("ll is empty");
            return;
        }
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data + "->");
            temp=temp.next;

        }
        System.out.println("null");

    }
    public void add(int idx,int data){
        if(idx==0){
            addfirst(data);

        }
        Node newnode=new Node(data);
        size++;
        Node temp=head;
        int i=0;

        while(i<idx-1){
            temp =temp.next;
            i++;
        }

        //i=idx-1; temp ->prev
        newnode.next=temp.next;
        temp.next=newnode;
}    

    public int removefirst(){
        if(size==0){
            System.out.println("ll is empty");
            return Integer.MIN_VALUE;
        }
        else if(size==1){
            int val=head.data;
            head=tail=null;
            size=0;
            return val;


        }
        int val=head.data;
        head=head.next;
        size--;
        return val;

    }
    public int helper(Node head,int key){
        if(head==null){
            return-1;
        }
        if(head.data==key){
            return 0;
        }
        int idx=helper(head.next,key);
        if (idx==-1){
            return -1;
        }
        return idx+1;

    }
    
    public int recsearch(int key){
        return helper(head,key);

    }
public void reverse(){
    Node prev=null;
    Node curr=tail=head;
    Node next;

    while(curr!=null){
        next=curr.next;
        curr.next=prev;
        prev = curr;
        curr = next;

    }
    head = prev;

}
public void deleteNthfromend(int n){
    //calculate size

    int sz=0;
    Node temp = head;
    while(temp!=null){
        temp=temp.next;
        sz++;
    }
    
    if(n==size){
        head=head.next;
        return;
            
    }
    //sz-n
    int i=1;
    int itofind=sz-n;
    Node prev = head;
    while(i<itofind){
        prev = prev.next;
        i++;
    }

    prev.next = prev.next.next;
    return;

}
//slow fast

public Node findmid(Node head){
    Node slow=head;
    Node fast=head;

    while(fast!=null && fast.next!=null){
        slow = slow.next; //+1
        fast = fast.next.next;// +2
    }

    return slow; //slow is mid
}
    public boolean checkpalindrome(){
        if(head == null || head.next == null){
            return true;
        }
        //step 1 fimd mid
        Node midnode = findmid(head);

        //step 2 reverse 2nd half
        Node prev = null;
        Node curr = midnode;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev = curr;
            curr = next;

        }
        Node right = prev; //right half head
        Node left = head; //left half head

        //step 3 compare left and right half
        while(right!=null){
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;

    }
    public static boolean iscycle(){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null ){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;//cycle exist
            }

        }
        return false;//cycle doesnt
    }
    public static void removecycle(){
        //detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;

        while(fast != null && fast.next != null ){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                cycle = true;
                break;//cycle exist
            }
}
            if(cycle==false){
                return;
            }
            //find meeting point
            
            slow=head;
            Node prev = null;//last node
            while(slow!=fast){
                prev = fast;
                slow = slow.next;
                fast = fast.next;
              }
               //remove cycle last.next =null
            prev.next=null;
    }
    private Node getmid(Node head){
        Node slow = head;
        Node fast = head.next;

        while(fast!= null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;//mid node

    }
    private Node merge(Node head1,Node head2){
        Node mergedll = new Node(-1);
        Node temp = mergedll;

        while(head1!=null && head2!= null){
            if(head1.data<=head2.data){
                temp.next=head1;
                head1 = head1.next;
                temp = temp.next;
            }
            else{
                temp.next = head2;
                head2 = head.next;
                temp = temp.next;
            }
        }
        while(head1!=null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;

        }
        while(head2!=null){
            temp.next = head2;
            head2 = head.next;
            temp = temp.next;
        }
        return mergedll.next;

    }

    public Node mergesort(Node head){
        if(head==null || head.next ==null){
            return head;
        }


        //find mid
        Node mid = getmid(head);
        //left and right MS
        Node righthead = mid.next;
        mid.next =null;
        Node newleft = mergesort(head);
        Node newright= mergesort(righthead);

        //merge
        return merge(newleft,newright);
}

    public void zigzag(){
        //find mid
        Node slow = head;
        Node fast = head.next;
        while(fast!= null && fast.next!=null){
            slow = slow.next;
            fast= fast.next.next;
        }
        Node mid = slow;

        //2nd half reverse
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;

        while(curr!=null){
        next=curr.next;
        curr.next=prev;
        prev = curr;
        curr = next;
         }

         Node left = head;
         Node right = prev;
         Node nextl,nextr;

         //alt merge-zig-zag
         while(left!=null && right!=null){
            nextl=left.next;
            left.next=right;
            nextr=right.next;
            right.next=nextl;

            left = nextl;
            right = nextr;

         }

    }
    public static void main(String args[]){
        Linked ll=new Linked();
        //ll.head = new Node(1);
        //ll.head.next = new Node(2);
        ll.print();
        ll.addfirst(2);
        ll.print();
        ll.addfirst(1);
        ll.print();
        ll.addlast(4);
        ll.print();
        ll.addlast(5);
        ll.add(2,3);
        ll.print(); //1->2->3->4->5
        //ll.reverse();
        //ll.deleteNthfromend(3);
        //ll.print();
        System.out.println(ll.checkpalindrome());


        //System.out.println(ll.size);
        //System.out.println(ll.recsearch(3));
        //System.out.println(ll.recsearch(10));
        removecycle();
        ll.head = ll.mergesort(ll.head);
        ll.print();
}
    
}
