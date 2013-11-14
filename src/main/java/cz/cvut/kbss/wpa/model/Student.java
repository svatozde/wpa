package cz.cvut.kbss.wpa.model;

import cz.cvut.kbss.wpa.dto.StudentDTO;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("student")
public class Student extends Person {

    @ManyToMany
    @JoinTable(name="student_courses")
    private List<Course> enrolledInCourses;

    @ManyToOne
    private Teacher supervisor;


    public Student() {
        super();
        enrolledInCourses = new LinkedList();
    }

    public Student(StudentDTO dto, String password) {
        super(dto, password);
    }
    
    

    public List<Course> getEnrolledInCourses () {
        return enrolledInCourses;
    }

    public void setEnrolledInCourses (List<Course> val) {
        this.enrolledInCourses = val;
    }

    public Teacher getSupervisor () {
        return supervisor;
    }

    public void setSupervisor (Teacher val) {
        this.supervisor = val;
    }
}

