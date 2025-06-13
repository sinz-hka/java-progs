package K09_Interfaces_Generics.CampusOrganizer;

public class Course implements Identifiable<String> {

    private final String name;
    private final String shortName; // key

    public Course(String name, String shortName) {
        this.name = name;
        this.shortName = shortName;
    }

    public String getName() {
        return name;
    }

    public String getShortName() {
        return shortName;
    }

    @Override
    public String toString() {
        return "Course{" +  "name='" + name + '\'' + ", shortName='" + shortName + '\'' + '}';
    }

    @Override
    public String getID() {
        return shortName;
    }
}