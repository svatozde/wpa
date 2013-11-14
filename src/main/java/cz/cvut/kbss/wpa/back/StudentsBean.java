package cz.cvut.kbss.wpa.back;

import cz.cvut.kbss.wpa.dto.StudentDTO;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import cz.cvut.kbss.wpa.service.SchoolCenterIface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@ManagedBean(name="students")
//@SessionScoped
@Component("students") //pod nazvem students bean bude tato komponenta pristupna z JSF
@Scope("session")
public class StudentsBean implements Serializable {

    @Autowired
    private SchoolCenterIface schoolCenter;
    
    private StudentDTO student = null;
    
    private String password;

    

    /** Creates a new instance of StudentsBean */
    public StudentsBean() {
    }

    public List<StudentDTO> getAllStudents() {
        return schoolCenter.getAllStudents();
    }

    public StudentDTO getStudent() {
        return student;
    }

    public void setStudent(StudentDTO student) {
        this.student = student;
    }

    public String newStudent() {
       student = new StudentDTO();
       password = null;
       return "student";
    }

    public String saveStudent() {
        if (student.getId() == null) {
            schoolCenter.createStudent(student, password);
        } else {
            schoolCenter.saveStudent(student);
        }
        return "students";
    }

    public String editStudent(StudentDTO student) {
        this.student = student;
        return "student";
    }

    public void removeStudent(StudentDTO student) {
        schoolCenter.removeStudent(student);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
