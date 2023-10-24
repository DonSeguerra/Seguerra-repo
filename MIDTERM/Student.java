import java.util.Scanner;
public class Student{
   String first_name, middle_name, last_name, suffix;
   
   public Student(String first_name, String middle_name, String last_name, String suffix){
   this.first_name = first_name; 
   this.middle_name = middle_name;
   this.last_name = last_name; 
   this.suffix = suffix;
   }
   
   public Student(){}
   public String getfirst_name(){
      return first_name;
   }
   public String getmiddle_name(){
      return middle_name;
   }
   public String getlast_name(){
      return last_name;
   }
   public String getsuffix(){
      return suffix;
   }
   public void setfirst_name(String first_name) {
      this.first_name = first_name;
  }
   public void setmiddle_name(String middle_name) {
      this.middle_name = middle_name;
  }
   public void setlast_name(String last_name) {
      this.last_name = last_name;
  }
   public void setsuffix(String suffix) {
      this.suffix = suffix;
  }
  public String getFullname(){
  return first_name + " " + middle_name + " " + last_name + " " + suffix;
  }
  public static void main(String[] args){
  Scanner scan = new Scanner(System.in);
  Student student = new Student();
  
  System.out.print("First Name: " );
  student.setfirst_name(scan.nextLine());
  
  System.out.print("Middle Name: " );
  student.setmiddle_name(scan.nextLine());
  
  System.out.print("Last Name: " );
  student.setlast_name(scan.nextLine());
  
  System.out.print("Suffix: " );
  student.setsuffix(scan.nextLine());
 
  System.out.println(student.getFullname());
   }
}