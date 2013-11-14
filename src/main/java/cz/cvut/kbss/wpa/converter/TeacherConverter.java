package cz.cvut.kbss.wpa.converter;

import cz.cvut.kbss.wpa.dto.TeacherDTO;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import cz.cvut.kbss.wpa.service.SchoolCenterIface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

@FacesConverter(value = "teacherConv")
@Configurable
public class TeacherConverter implements Converter {

    @Autowired
    private SchoolCenterIface schoolCenter;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if ((value == null) || "".equals(value)) {return null;}
        return schoolCenter.getTeacher(Long.parseLong(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {return null;}
        Long id = ((TeacherDTO) value).getId();
        if (id == null) {return "";}
        return String.valueOf(id);
    }

}
