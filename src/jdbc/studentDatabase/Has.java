package jdbc.studentDatabase;

public class Has {
    int teacher_id;
    String class_name;

    Has(int teacher_id, String class_name) {
        this.teacher_id = teacher_id;
        this.class_name = class_name;
    }

    @Override
    public String toString() {
        return "(" + teacher_id + "," + class_name + ")";
    }
}
