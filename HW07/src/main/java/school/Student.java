package school;

import java.util.Objects;

public class Student {
    private final int id;
    private final String name;
    private double score;
    private final String major;

    public Student(int id, String name, double score, String major) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.major = major;
    }

    public String getMajor() {
        return major;
    }

    public double getScore() {
        return score;
    }

    public int getId() {
        return id;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                ", major='" + major + '\'' +
                '}';
    }
}
