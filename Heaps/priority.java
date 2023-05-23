import java.util.*;
public class priority {
    static class student implements Comparable<student>{ 
        //overriding child class implements parent class interface
        //interface comparable classes can compare their objects
          String name;
          int rollno;

          public student(String name, int rollno){
            this.name = name;
            this.rollno = rollno;
          } 

          @Override 
          public int compareTo(student s2){
            return this.rollno-s2.rollno;

          }


    }
    public static void main(String args[]){
        PriorityQueue<student> pq = new PriorityQueue<>();

        pq.add(new student("A", 4));
        pq.add(new student("B", 5));
        pq.add(new student("C", 2));
        pq.add(new student("D", 12));

        while(!pq.isEmpty()){
            System.out.println(pq.peek().name+ "->" + pq.peek().rollno);
            pq.remove();
        }

    }
}
