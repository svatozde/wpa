package cz.cvut.kbss.wpa.back;

import cz.cvut.kbss.wpa.dto.TeacherDTO;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;
import cz.cvut.kbss.wpa.service.SchoolCenterIface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@ManagedBean(name="teachers")
//@RequestScoped
@Component("teachers")
@Scope("request")
public class TeachersBean {
    
    @Autowired
    private SchoolCenterIface schoolCenter;
    

    private List<SelectItem> allTeachers;

    public List<SelectItem> getAllTeachers() {
        allTeachers = new ArrayList<SelectItem>();
        allTeachers.add(new SelectItem(new TeacherDTO(), "---"));
        for (TeacherDTO t : schoolCenter.getAllTeachers()) {
            allTeachers.add(new SelectItem(t, t.getSurname() + " " + t.getFirstName() + " (" + t.getDepartment().getName() + ")"));
        }
        return allTeachers;
    }
}
