public class oop {
    public static void main(String args[]){
        PEN p1=new PEN();//created a pen object
        p1.setcolor("blue");
        System.out.println(p1.getcolor());

        Bankaccount myacc= new Bankaccount();
        myacc.username="dhruv";
       
        myacc.setpassword("ruchikajan");
}
    }
    class Bankaccount{
        public String username;
        private String password;
        public void setpassword(String pwd){
            password = pwd;

        }
}
class PEN{
    private String color;
    int tip;
     String getcolor(){
        return this.color;
     }
void setcolor(String newcolor){ //function
        color = newcolor;
}
    void setip(int newtip){
tip=newtip;
}
}
class Student{
    String name;
    int age;
    float percentage;

    void calculatepercentage(int phy,int chem){
        percentage=((phy + chem)/2)*100;
}
}
