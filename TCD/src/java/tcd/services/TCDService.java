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

    /**
     * Get all the user characters 
     * 
     * @param userId id of the current user
     * @return the list of the user characters
     */
    @Override
    public List<Character> getCharacterList(final int userId) {
        
        try{
            List<Character> resultList = new ArrayList<>();

            ResultSet rs = doQuery("SELECT * FROM t_characters"); 

            while(rs.next()){

                Character character = new Character();

                character.setCharacterName(rs.getString("CHARACTER_NAME"));

                resultList.add(character);
            }

            return resultList;
            
        }catch(SQLException e){
            
            //Print up a message if something went wrong
            FacesMessage mess = new FacesMessage("getCharacterList: "+e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, mess);
        }
        
        //If something went wrong, returns an empty list
        return Collections.EMPTY_LIST;
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

    /**
     * Sets up a db connection
     * 
     * @return a Connection instance
     * @throws SQLException 
     */
    private Connection setConnection() throws SQLException {
        
        if(ds == null)
            throw new SQLException("Can't get Data Source");

        Connection conn = ds.getConnection();

        if(conn == null)
            throw new SQLException("Can't get connection");
        
        return conn;
    }

    /**
     * Executes a query
     * 
     * @param query The query being executed
     * @return the result set
     * @throws SQLException 
     */
    private ResultSet doQuery(String query) throws SQLException {       
        
        //Tries to execute the query
        try(Connection conn = setConnection()) {       

            //Create the statement
            PreparedStatement statement = conn.prepareStatement(query);   

            //Extracts and returns the ResultSet
            ResultSet rs = statement.executeQuery();
            
            return rs;

        }catch(SQLException e){            
            throw e;
        }       
    }

}
