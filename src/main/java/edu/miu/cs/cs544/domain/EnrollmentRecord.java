package edu.miu.cs.cs544.domain;


import javax.persistence.*;
import java.util.List;

@Entity
public class EnrollmentRecord {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    private Section section;

    @ManyToOne
    private Student student;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
