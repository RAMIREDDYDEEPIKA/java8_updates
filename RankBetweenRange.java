import java.util.*;
import java.util.stream.Collectors;

public class RankBetweenRange {

    public static void main(String[] args) {

        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1, "Rohit", 30, "Male", "Mechanical Engineering", "Mumbai", 122, Arrays.asList("+912632632782", "+1673434729929")));
        studentList.add(new Student(2, "Pulkit", 56, "Male", "Computer Engineering", "Delhi", 67, Arrays.asList("+912632632762", "+1673434723929")));
        studentList.add(new Student(3, "Ankit", 25, "Female", "Mechanical Engineering", "Kerala", 164, Arrays.asList("+912632633882", "+1673434709929")));
        studentList.add(new Student(4, "Satish Ray", 30, "Male", "Mechanical Engineering", "Kerala", 26, Arrays.asList("+9126325832782", "+1671434729929")));
        studentList.add(new Student(5, "Roshan", 23, "Male", "Biotech Engineering", "Mumbai", 12, Arrays.asList("+012632632782")));
        studentList.add(new Student(6, "Chetan", 24, "Male", "Mechanical Engineering", "Karnataka", 90, Arrays.asList("+9126254632782", "+16736784729929")));
        studentList.add(new Student(7, "Arun", 26, "Male", "Electronics Engineering", "Karnataka", 324, Arrays.asList("+912632632782", "+1671234729929")));
        studentList.add(new Student(8, "Nam", 31, "Male", "Computer Engineering", "Karnataka", 433, Arrays.asList("+9126326355782", "+1673434729929")));
        studentList.add(new Student(9, "Sonu", 27, "Female", "Computer Engineering", "Karnataka", 7, Arrays.asList("+9126398932782", "+16563434729929", "+5673434729929")));
        studentList.add(new Student(10, "Shubham", 26, "Male", "Instrumentation Engineering", "Mumbai", 98, Arrays.asList("+912632646482", "+16734323229929")));

        System.out.println("listing the students whose rank is in between 50 and 100:");
        studentList.stream()
                .filter(student -> student.rank >= 50 && student.rank <= 100)
                .collect(Collectors.toList()).forEach(System.out::println);


        System.out.println("\nStudents who stays in Karnataka and sort them by their names:");
        studentList.stream()
                .filter(student -> "Karnataka".equalsIgnoreCase(student.city))
                .sorted(Comparator.comparing(student -> student.name))
                .collect(Collectors.toList())
                .forEach(System.out::println);


        System.out.println("\nFinding all departments names:");
        studentList.stream()
                .map(student -> student.department)
                .distinct()
                .collect(Collectors.toList())
                .forEach(System.out::println);


        System.out.println("\nFinding all the contact numbers:");
        studentList.stream()
                .flatMap(student -> student.phoneNumbers.stream())
                .distinct()
                .collect(Collectors.toList())
                .forEach(System.out::println);


        System.out.println("\nGrouping The Student By Department Names:");
        studentList.stream()
                .collect(Collectors.groupingBy(student -> student.department))
                .forEach((department, students) -> {
                    System.out.println(department + ":");
                    students.forEach(System.out::println);
                });


        System.out.println("\nFinding the department who is having maximum number of students:");
        Map<String, Long> departmentCount = studentList.stream()
                .collect(Collectors.groupingBy(student -> student.department, Collectors.counting()));

        String departmentWithMaxStudents = departmentCount.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("No Departments Found");
        System.out.println("Department with Maximum Students: " + departmentWithMaxStudents);


        System.out.println("\nFinding the average age of male and female students:");
        studentList.stream()
                .collect(Collectors.groupingBy(student -> student.gender, Collectors.averagingInt(student -> student.age)))
                .forEach((gender, avgAge) -> System.out.println(gender + ": " + avgAge));


        System.out.println("\nFinding the highest rank in each department:");
         studentList.stream()
                .collect(Collectors.groupingBy(student -> student.department,
                        Collectors.mapping(student -> student.rank, Collectors.minBy(Integer::compareTo))))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().get()))
                .forEach((department, rank) ->
                        System.out.println(department + ": " + rank));


        System.out.println("\nFinding the student who has second rank:");
        studentList.stream()
                .sorted(Comparator.comparingInt(student -> student.rank))
                .skip(1)
                .findFirst()
                .ifPresent(student ->
                        System.out.println("Student with second rank: " + student.name + " with rank " + student.rank));;

    }
}