/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.kbss.wpa.back;

import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component("login")
@Scope("request")
public class LoginBean {
    
    public String getLoginName() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
    
}
