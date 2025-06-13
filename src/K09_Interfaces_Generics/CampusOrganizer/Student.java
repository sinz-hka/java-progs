package K09_Interfaces_Generics.CampusOrganizer;

public class Student implements Identifiable<Integer> {

    private final String name;
    private final Integer number;

    public Student(String name, Integer number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public Integer getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "\'number=" + number + '}';
    }

    @Override
    public Integer getID() {
        return number;
    }
}
