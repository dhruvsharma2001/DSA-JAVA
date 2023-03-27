public class comstructors {
    Student s1=new Student();
    Student s2=new Student("tumhari to gaand tod ke jaunga");
    Student s3=new Student(123);
}

class Student{
    String name;
    int roll;
    Student(){
        System.out.print("constructor");
    }
    Student(String name){
        this.name = name;
        }
        Student(int roll){
            this.roll = roll;
            }
    
    
}

