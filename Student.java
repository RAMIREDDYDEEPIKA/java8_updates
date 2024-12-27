import java.util.List;

class Student {
    int id;
    String name;
    int age;
    String gender;
    String department;
    String city;
    int rank;
    List<String> phoneNumbers;

    public Student(int id, String name, int age, String gender, String department, String city, int rank, List<String> phoneNumbers) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.city = city;
        this.rank = rank;
        this.phoneNumbers = phoneNumbers;
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + '\'' + ", rank=" + rank + '}';
    }
}