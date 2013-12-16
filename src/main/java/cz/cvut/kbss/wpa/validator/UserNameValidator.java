/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.kbss.wpa.validator;

import cz.cvut.kbss.wpa.badminton.exception.WPAException;
import cz.cvut.kbss.wpa.badminton.service.IPlaceService;
import cz.cvut.kbss.wpa.badminton.service.IPlayerService;
import cz.cvut.kbss.wpa.badminton.service.IUserService;
import cz.cvut.kbss.wpa.badminton.service.PlayerService;
import cz.cvut.kbss.wpa.support.FacesUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *
 * @author zdeněk
 */
@FacesValidator(value = "usernameValidator")
@Configurable
@Component("usernameValidator")
public class UserNameValidator implements Validator {

   @Autowired
   private IPlayerService playerService;

    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {
        String name = (String) o;
           
           if (name == null || !playerService.checkName(name)) {
               FacesMessage msg
                       = new FacesMessage(FacesUtil.getMessage("usernameUsed"),
                               FacesUtil.getMessage("usernameUsed"));
               msg.setSeverity(FacesMessage.SEVERITY_ERROR);
               throw new ValidatorException(msg);
           }
       
    }

}
