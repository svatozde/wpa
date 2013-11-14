package cz.cvut.kbss.wpa.converter;

import cz.cvut.kbss.wpa.dto.CourseDTO;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import cz.cvut.kbss.wpa.service.SchoolCenterIface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

@FacesConverter(value = "courseConv")
@Configurable
public class CourseConverter implements Converter {

    @Autowired
    private SchoolCenterIface schoolCenter;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return schoolCenter.getCourse(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return String.valueOf(((CourseDTO) value).getCourseId());
    }

}
