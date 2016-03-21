package tcd.auth;

import java.util.Locale;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import tcd.services.TCDServiceLocal;
import tcd.utils.TCDUtils;

/**
 * 
 * @author Jacopo "Faust" Buttiglieri
 */

@ManagedBean(name ="login")
@SessionScoped
public class LoginBacking {

    private String loginUsername;
    private String loginPassword;
    private User user;
    private Locale currentLocale;    
    
    @ManagedProperty("#{tcdService}")
    private TCDServiceLocal tcdService;

    public String doLogin() {
       user = tcdService.doLogin(loginUsername,loginPassword);
       
       if(user != null)
           return TCDUtils.MAIN_PAGE;
       
       return TCDUtils.LOGIN_PAGE;
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

    public TCDServiceLocal getTcdService() {
        return tcdService;
    }

    public void setTcdService(TCDServiceLocal tcdService) {
        this.tcdService = tcdService;
    } 
    
}
