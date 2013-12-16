package cz.cvut.kbss.wpa.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

@FacesValidator(value="birthnumberValidator")
@Configurable
public class BirthnumberValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        //Validator rodneho cisla - napr. slozitejsi kontrola delitelnosti s vyjimkami apod.
        //String s = (String) value;
        //throw new ValidatorException(new FacesMessage("asdasd"))
    }

}
