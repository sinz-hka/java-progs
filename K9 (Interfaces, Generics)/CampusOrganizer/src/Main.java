public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("Harry Potter", 4);
        Student s2 = new Student("Carsten Sinz", 77);
        Student s3 = new Student("Petunia", 9);
        StudentRepository r = new StudentRepository();
        r.add(s1);
        r.add(s2);
        r.add(s3);
        System.out.println(r);
        System.out.println("found: " + r.search(9));
        r.delete(77);
        System.out.println(r);
    }
}