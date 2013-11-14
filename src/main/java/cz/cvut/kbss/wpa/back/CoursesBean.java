package cz.cvut.kbss.wpa.back;

import cz.cvut.kbss.wpa.dto.CourseDTO;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;
import cz.cvut.kbss.wpa.service.SchoolCenterIface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@ManagedBean(name = "courses")
//@ApplicationScoped
@Component("courses")
@Scope("application")
public class CoursesBean {

    @Autowired
    private SchoolCenterIface schoolCenter;
    
    private List<SelectItem> allCourses;

    public List<SelectItem> getAllCourses() {
        allCourses = new ArrayList<SelectItem>();
        for (CourseDTO c : schoolCenter.getAllCourses()) {
            allCourses.add(new SelectItem(c, c.getName()));
        }
        return allCourses;
    }
}
