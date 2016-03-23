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
            
            //Adding parameters
            QueryParams charParams = new QueryParams();                
            charParams.add(Types.INTEGER,String.valueOf(userId));
            
            ResultSet charResultSet = doQuery(TCDUtils.CHARACTERS_QUERY,charParams); 

            while(charResultSet.next()){

                Character character = new Character();

                character.setCharacterName(charResultSet.getString("CHARACTER_NAME"));            
                
                //Adding parameters
                QueryParams roleParams = new QueryParams();                
                roleParams.add(Types.INTEGER,charResultSet.getString("CHARACTER_ROLE"));
                
                ResultSet roleResultSet = doQuery(TCDUtils.ROLE_QUERY,roleParams); 
                roleResultSet.next();
                
                Role r = new Role();
                
                String roleName = roleResultSet.getString("ROLE_NAME");
                
                r.setRoleName(localize(roleName));
                
                character.setCharacterRole(r);
                
                resultList.add(character);
            }

            return resultList;
            
        }catch(SQLException e){            
            //Print up a message if something went wrong
            errorMessage(TCDUtils.MAIN_PAGE_MESSAGE,
                        "getCharacterList: "+e.getMessage());
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
    public User doLogin(final String username,final String password){
        //Esegue la query per username e password
        //ritorna null se la login è fallita.
        
        
        QueryParams params = new QueryParams();
        params.add(Types.VARCHAR, username);
        params.add(Types.VARCHAR, password);
        
        try{
        
            ResultSet resultSet = doQuery(TCDUtils.LOGIN_QUERY, params);
            
            if(!resultSet.next())
                throw new Exception();
            
            User loggedUser = new User();
            
            loggedUser.setUserName(resultSet.getString("USER_NAME"));
            loggedUser.setPassword(resultSet.getString("USER_PASSWORD"));
            loggedUser.setUserId(resultSet.getInt("ID_USER"));            
            
            return loggedUser;
        }catch(SQLException e){
            errorMessage(TCDUtils.LOGIN_PAGE_MESSAGE,
                        "doLogin: "+ e.getMessage());
        }catch(Exception ex){
            errorMessage(TCDUtils.LOGIN_PAGE_MESSAGE,
                        "Username o Password non corretti");
        }
        
        return null;
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
                parameterIndex++;
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
            errorMessage(TCDUtils.MAIN_PAGE_MESSAGE,
                        e.getMessage() + " for locale:"+locale.getDisplayName());
        }       
        
        return stringToLocalize;
    }

    /**
     * Used to print on screen error messages
     * 
     * @param errorMessage the message to be shown
     */
    private void errorMessage(String messageID, String errorMessage) {

        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                "Error", 
                                                errorMessage);
        FacesContext.getCurrentInstance().addMessage(messageID, message);
    }

}
