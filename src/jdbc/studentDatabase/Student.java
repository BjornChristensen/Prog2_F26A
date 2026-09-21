package jdbc.studentDatabase;

public class Student {
  String mail;
  String name;
  String class_name;

  Student(String mail, String name, String class_name){
    this.mail=mail;
    this.name=name;
    this.class_name=class_name;
  }

  @Override
  public String toString() {
    return name;
  }
}
