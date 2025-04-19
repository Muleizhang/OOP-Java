package school;


import java.util.*;

public class Manager {
    public static List<Student> students = Arrays.asList(
            new Student(1, "Alice", 85.0, "Computer Science"),
            new Student(2, "Bob", 45.0, "Mathematics"),
            new Student(3, "Charlie", 78.5, "Physics"),
            new Student(4, "David", 59.0, "Computer Science"),
            new Student(5, "Eve", 93.0, "Mathematics"),
            new Student(6, "Frank", 70.0, "Physics"),
            new Student(2, "Duplicate Bob", 45.0, "Mathematics"),
            new Student(7, "Grace", 88.5, "Computer Science")
    );
    static List<Student> uniqueStudents = new ArrayList<>(new HashSet<>(students));


    static void updateScore(int id) {
        Map<Integer, Student> studentMap = new HashMap<>();
        for (Student student : uniqueStudents) {
            studentMap.put(student.getId(), student);
        }
        Student found = studentMap.get(id);
        if (found == null) {
            System.out.println("id: " + id + " Not Found");
        } else {
            found.setScore(95.0);
        }
    }

    public static void main(String[] args) {
        System.out.println("Initial List of Students:");
        for (Student i : students) {
            System.out.println(i);
        }
        System.out.println();

        System.out.println("Passed Students (After Removing Duplicates):");
        int passedNum = 0;
        for (Student i : uniqueStudents) {
            if (i.getScore() >= 60) {
                System.out.println(i);
                passedNum += 1;
            }
        }
        System.out.println();

        HashMap<String, List<Student>> studentsByMajor = new HashMap<>();
        for (Student i : uniqueStudents) {
            String major = i.getMajor();
            if (!studentsByMajor.containsKey(major)) {
                studentsByMajor.put(major, new ArrayList<>());
            }
            studentsByMajor.get(major).add(i);
        }

        System.out.println("Students Grouped by Major:");
        studentsByMajor.forEach((major, studentList) -> {
            System.out.println("Major: " + major);
            studentList.forEach(System.out::println);
        });
        System.out.println();

        System.out.println("Average Score by Major:");
        studentsByMajor.forEach((major, studentList) -> {
            double scoreSum = 0;
            for (Student i : studentList) {
                scoreSum += i.getScore();
            }
            System.out.println("Major: " + major + ", Average Score: " + scoreSum / studentList.size());
        });
        System.out.println();

        System.out.println("Students Sorted by Score (Descending):");
        uniqueStudents.sort((u1, u2) -> Double.compare(u2.getScore(), u1.getScore()));
        uniqueStudents.forEach(System.out::println);
        System.out.println();

        System.out.println("Global Statistics:");
        System.out.println("Highest Scoring Student: " + uniqueStudents.getFirst());
        System.out.println("Number of Passed Students: " + passedNum);
        System.out.println("Number of Failed Students: " + (uniqueStudents.size() - passedNum));
    }

}
