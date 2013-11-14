package cz.cvut.kbss.wpa.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;

@Entity
@NamedQueries(
@NamedQuery(name = Course.Q_GET_ALL_COURSES, query = "SELECT c FROM Course c"))
public class Course extends AbstractEntity {

    //Anotace Transient zajisti, ze nasledujici field nebude pouzit pro objektove - relacni mapovani
    @Transient
    public static final String Q_GET_ALL_COURSES = "Course.GET_ALL";

    private String courseId;

    private String name;

    @ManyToMany(mappedBy="courses")
    private List<Teacher> teachers;

    public Course () {
    }

    public String getCourseId () {
        return courseId;
    }

    public void setCourseId (String val) {
        this.courseId = val;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public String getName () {
        return name;
    }

    public void setName (String val) {
        this.name = val;
    }

    
}

