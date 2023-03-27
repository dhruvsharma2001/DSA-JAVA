public class inheritance {
    public static void main(String args[]){
        fish shark=new fish();
        shark.eat();

    }
}
//base class
class Animal{
    String color;
    void eat(){
        System.out.println("eat");
    }
    void breathe(){
        System.out.println("breathe");
}
}
//derived class
class fish extends Animal{
    int fins;

    void swim(){
        System.out.println("swim");
    }
}
