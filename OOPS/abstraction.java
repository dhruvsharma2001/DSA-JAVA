public class abstraction {
    public static void main(String args[]){
        Horse h= new Horse();
        h.eat();
        h.walk();
        Chicken c= new Chicken();
        c.eat();
        c.walk();

    }
}

abstract class Animal{
    void eat(){
        System.out.println("eats");
    }

    abstract void walk();//no implementation only idea

}
class Horse extends Animal{
    void walk(){
        System.out.println("walks");//implement acc to horse
    }
}
class Chicken extends Animal{
    void walk(){
        System.out.println("walks on 2 legs");//implement acc to chicken
    }

}
