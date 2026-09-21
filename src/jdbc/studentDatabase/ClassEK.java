package jdbc.studentDatabase;

public class ClassEK {
    String name;
    String class_room;

    ClassEK(String name, String class_room) {
        this.name = name;
        this.class_room = class_room;
    }

    @Override
    public String toString() {
        return name;
    }
}
