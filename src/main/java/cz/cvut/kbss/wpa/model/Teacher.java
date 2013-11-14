package cz.cvut.kbss.wpa.model;

import cz.cvut.kbss.wpa.dto.TeacherDTO;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("teacher")
public class Teacher extends Person {
    
    @ManyToOne
    @JoinColumn(name="dep_id")
    private Department department;

    @ManyToMany
    @JoinTable(name="teacher_courses")
    private List<Course> courses;
    
    public Teacher() {
    }

    public Teacher(TeacherDTO dto) {
        super(dto, null);
    }
    
    public Department getDepartment () {
        return department;
    }

    public void setDepartment (Department val) {
        this.department = val;
    }

    public List<Course> getCourses () {
        return courses;
    }

    public void setCourses (List<Course> val) {
        this.courses = val;
    }

}

