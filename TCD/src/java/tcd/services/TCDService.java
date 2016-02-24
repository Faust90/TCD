package tcd.services;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import tcd.auth.User;
import java.util.*;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.sql.DataSource;
import tcd.model.Character;
import tcd.model.Role;
import tcd.model.Skill;

@ManagedBean(name ="tcdService")
@SessionScoped
public class TCDService implements TCDServiceLocal,Serializable {
    
    @Resource(name = "jdbc/TCD")
    private DataSource ds;
    
    private Logger log;

    @Override
    public List<Character> getCharacterList() {
        
        List<Character> resultList = new ArrayList<Character>();
        
        try{
            if(ds == null)
                throw new SQLException("Can't get Data Source");

            Connection conn = ds.getConnection();

            if(conn == null)
                throw new SQLException("Can't get connection");
                        
            FacesMessage mess = new FacesMessage(conn.getSchema());
            FacesContext.getCurrentInstance().addMessage(null, mess);
            
            //TODO
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM t_characters");
            
            ResultSet rs = statement.executeQuery();
            
            while(rs.next()){
                
                Character character = new Character();
                
                character.setCharacterName(rs.getString("CHARACTER_NAME"));

                resultList.add(character);
            }
            
        }catch(Exception e){
            FacesMessage mess = new FacesMessage(e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, mess);
        }

        return resultList;
    }

    @Override
    public List<Role> getRoleList() {
            throw new UnsupportedOperationException("The method is not implemented yet.");
    }

    @Override
    public void saveCharacter() {
            throw new UnsupportedOperationException("The method is not implemented yet.");
    }

    @Override
    public User doLogin() {
            throw new UnsupportedOperationException("The method is not implemented yet.");
    }

    private List<Skill> getSkillList() {
            throw new UnsupportedOperationException("The method is not implemented yet.");
    }

}
