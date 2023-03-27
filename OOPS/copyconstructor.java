public class copyconstructor {
    public static void main(String args[]){
    Student s1=new Student();
    s1.name="dhruv";
    s1.roll=123;
    s1.password="abcd";

    Student s2=new Student(s1);
    s2.password="fff";
}
    }
    class Student {
        String name;
        int roll;
        String password;
        Student(Student s1){
            this.name=s1.name;
            this.roll=s1.roll;
        }
        Student(){
            System.out.println("constructor");
        }
        Student(String name){
            this.name = name;
            }
            Student(int roll){
                this.roll = roll;
                }
    }
