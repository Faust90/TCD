package tcd.auth;

import java.util.Locale;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * 
 * @author Jacopo "Faust" Buttiglieri
 */

@ManagedBean(name ="login")
@RequestScoped
public class LoginBacking {

    private String loginUsername;
    private String loginPassword;
    private User user;
    private Locale currentLocale;

    public void doLogin() {
        throw new UnsupportedOperationException("The method is not implemented yet.");
    }

    public String getLoginUsername() {
        return loginUsername;
    }

    public void setLoginUsername(String loginUsername) {
        this.loginUsername = loginUsername;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }   

    public Locale getCurrentLocale() {
        return currentLocale;
    }

    public void setCurrentLocale(Locale currentLocale) {
        this.currentLocale = currentLocale;
    }
    
}
