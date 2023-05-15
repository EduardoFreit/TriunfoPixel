package br.ifpe.triunfopixel.util;

import br.ifpe.triunfopixel.model.Usr;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.faces.context.FacesContext;
import javax.faces.application.Application;
import javax.faces.component.UIViewRoot;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class Util {

    public final static String LOGIN_PAGE = "login.xhtml";

    public static FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }

    public static Application getApplication() {
        return getFacesContext().getApplication();
    }
    
    public static HttpSession getSession() {
            return (HttpSession) FacesContext.getCurrentInstance()
                            .getExternalContext().getSession(false);
    }

    public static UIViewRoot getViewRoot() {
        return getFacesContext().getViewRoot();
    }

    public static void setLocale(Locale locale) {
        getViewRoot().setLocale(locale);
    }

    public static ResourceBundle getResourceBundle(String key) {
        return getApplication().getResourceBundle(getFacesContext(), key);
    }

    public static String md5(String text) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = md.digest(text.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            return text;
        }
    }

    public static Usr getLoginUSer(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Object userAttribute = session.getAttribute("user");
        return userAttribute == null ? null : (Usr) userAttribute;
    }
    
}
