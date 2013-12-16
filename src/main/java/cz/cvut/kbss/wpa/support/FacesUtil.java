/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.kbss.wpa.support;

import java.util.Locale;
import java.util.ResourceBundle;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class FacesUtil {

    public static String getRequestParameter(String name) {
        return (String) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(name);
    }

    public static String getRequestURL() {
        return (String) ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getRequestURL().toString();
    }

    /**
     * Prida message do contextu uzivatele zdroj == @null
     *
     * @param string
     */
    public static void addMessage(String string) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(string));
    }

    public static void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    /**
     * Get message from the specified bundle
     *
     * @param bundleName budle baseName
     * @param key key of the message
     * @return message
     */
    public static String getMessage(String bundleName, String key) {
        return ResourceBundle.getBundle(bundleName).getString(key);
    }

    public static String getMessage(String key) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String messageBundleName = facesContext.getApplication().getMessageBundle();
        Locale locale = facesContext.getViewRoot().getLocale();
        ResourceBundle bundle = ResourceBundle.getBundle(messageBundleName, locale);
        return bundle.getString(key);
    }

    public static Object getSessionAttribute(String key) {
        return ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true)).getAttribute(key);

    }

    public static void setSessionAttribute(String key, Object value) {
        ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true)).setAttribute(key, value);
    }

    /**
     * Returns remote address for this request
     *
     * @return remote address
     */
    public static String getRemoteAddress() {
        return ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getRemoteAddr();
    }
}
