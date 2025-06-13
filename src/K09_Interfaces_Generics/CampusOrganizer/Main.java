package K09_Interfaces_Generics.CampusOrganizer;

public class Main {
    public static void main(String[] args) {

        // Test the StudentRepository...
        Student s1 = new Student("Harry Potter", 4);
        Student s2 = new Student("Friedrich Merz", 77);
        Student s3 = new Student("Petunia", 9);
        StudentRepository studentRepository = new StudentRepository();
        studentRepository.add(s1);
        studentRepository.add(s2);
        studentRepository.add(s3);
        System.out.println("Generated 3 students and added them to the repository:");
        System.out.println(studentRepository);

        System.out.println("Searching for student with ID 9:");
        System.out.println("Found: " + studentRepository.search(9) + "\n");

        System.out.println("Deleting student with id 77. Repository is now:");
        studentRepository.delete(77);
        System.out.println(studentRepository);

        // ...and now the CourseRepository.
        Course c1 = new Course("Java Programming", "JAVA");
        Course c2 = new Course("Mathematics", "MATH");
        CourseRepository courseRepository = new CourseRepository();
        courseRepository.add(c1);
        courseRepository.add(c2);
        System.out.println("Generated 2 courses and added them to the repository:");
        System.out.println(courseRepository);

        System.out.println("Deleting course with id 'JAVA'. Repository is now:");
        courseRepository.delete("JAVA");
        System.out.println(courseRepository);
    }
}