package tcd.services;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import tcd.auth.User;
import java.util.*;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.sql.DataSource;
import tcd.model.Character;
import tcd.model.Role;
import tcd.model.Skill;
import tcd.utils.Parameter;
import tcd.utils.QueryParams;
import tcd.utils.TCDUtils;

@ManagedBean(name ="tcdService")
@SessionScoped
public class TCDService implements TCDServiceLocal,Serializable {
    
    @Resource(name = "jdbc/TCD")
    private DataSource ds;    
    
    private ResourceBundle bundle ;

    
    @PostConstruct
    public void init(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        bundle = facesContext.getApplication().getResourceBundle(facesContext, "labels");
    }
    
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
            
            ResultSet rs = doQuery(TCDUtils.CHARACTERS_QUERY); 

            while(rs.next()){

                Character character = new Character();

                character.setCharacterName(rs.getString("CHARACTER_NAME"));            
                
                //Adding parameters
                QueryParams params = new QueryParams();                
                params.add(Types.INTEGER,rs.getString("CHARACTER_ROLE"));
                
                ResultSet rs2 = doQuery(TCDUtils.ROLE_QUERY,params); 
                rs2.next();
                
                Role r = new Role();
                
                String roleName = rs2.getString("ROLE_NAME");
                
                r.setRoleName(localize(roleName));
                
                character.setCharacterRole(r);
                
                resultList.add(character);
            }

            return resultList;
            
        }catch(SQLException e){
            
            //Print up a message if something went wrong
            FacesMessage mess = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                "Error",
                                                "getCharacterList: "+e.getMessage());
            FacesContext.getCurrentInstance().addMessage("error", mess);
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
     * @param parameters the parameters of the query
     * @return the result set
     * @throws SQLException 
     */
    private ResultSet doQuery(String query,QueryParams parameters) throws SQLException{
        
        //Tries to execute the query
        try(Connection conn = setConnection()) {       

            //Create the statement
            PreparedStatement statement = conn.prepareStatement(query);   
            
            int parameterIndex = 1;
            for (Parameter param : parameters.getParamList()) {
                statement.setObject(parameterIndex, param.getValue(), param.getType());
            }

            //Extracts and returns the ResultSet
            ResultSet rs = statement.executeQuery();
            
            return rs;

        }catch(SQLException e){            
            throw e;
        }   
        
    }
    
    /**
     * Executes a query without parameters
     * 
     * @param query The query being executed
     * @return the result set
     * @throws SQLException 
     */
    private ResultSet doQuery(String query) throws SQLException {       
        
        //Executes the query without any params
        return doQuery(query,TCDUtils.QUERY_EMPTY_PARAMS);
    }

    /**
     * Localize a string
     * 
     * @param stringToLocalize the string to localize
     * @return the localized string, or the string itself if there is a problem
     * 
     */
    private String localize(String stringToLocalize) {
        
        try{                     
            return bundle.getString(stringToLocalize);
        }catch(MissingResourceException e){
            
            //Print up a message if something went wrong
            Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
            FacesMessage mess = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                "Error",
                                                e.getMessage() + " for locale:"+locale.getDisplayName());
            FacesContext.getCurrentInstance().addMessage(null, mess);
        }       
        
        return stringToLocalize;
    }

}
