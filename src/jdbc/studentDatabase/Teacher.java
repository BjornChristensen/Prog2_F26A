package jdbc.studentDatabase;

public class Teacher {
    int teacher_id;
    String name;

    Teacher(int teacher_id, String name) {
        this.teacher_id = teacher_id;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
