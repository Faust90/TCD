package tcd.backings;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import tcd.auth.User;
import tcd.model.Character;
import tcd.services.TCDServiceLocal;

/**
 * 
 * @author Jacopo "Faust" Buttiglieri
 */

@ManagedBean(name ="charListBacking")
@ViewScoped
public class CharListBacking implements Serializable{
    
    private List<Character> characterList;
    
    @ManagedProperty("#{login.user}")
    private User user;
    
    @ManagedProperty("#{tcdService}")
    private TCDServiceLocal tcdService;
    
     
    @PostConstruct
    public void init(){
        retrieveCharactersList();
    }    

    public void openCharacterDetail() {
            throw new UnsupportedOperationException("The method is not implemented yet.");
    }

    public void createCharacter() {
            throw new UnsupportedOperationException("The method is not implemented yet.");
    }

    private void retrieveCharactersList() {
        
        characterList = tcdService.getCharacterList(user.getUserId());
    }

    public void doLogout() {
            throw new UnsupportedOperationException("The method is not implemented yet.");
    }

    public int getCharactersNumber() {
            throw new UnsupportedOperationException("The method is not implemented yet.");
    }

    public List<Character> getCharacterList() {
        return characterList;
    }

    public void setCharacterList( List<Character> characterList) {
        this.characterList = characterList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TCDServiceLocal getTcdService() {
        return tcdService;
    }

    public void setTcdService(TCDServiceLocal tcdService) {
        this.tcdService = tcdService;
    }
        

}
