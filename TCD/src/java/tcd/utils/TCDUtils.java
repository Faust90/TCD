/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcd.utils;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 * Application costants
 *
 * @author "Jacopo 'Faust' Buttiglieri"
 */
@ManagedBean(name = "tcdUtils")
@ApplicationScoped
public class TCDUtils {
    
    /**
     * Empty Query Parameters
     */
    final public static QueryParams QUERY_EMPTY_PARAMS = new QueryParams();
    
    final public static String CHARACTERS_QUERY = "SELECT * FROM t_characters  WHERE CHARACTER_USER = ?";
    
    final public static String ROLE_QUERY = "SELECT * FROM t_role WHERE ID_ROLE = ?";
    
    final public static String LOGIN_QUERY =  "SELECT * FROM t_users WHERE USER_NAME = ? AND USER_PASSWORD = ?";
    
    final public static String LOGIN_PAGE = "index.xhtml";
    
    final public static String MAIN_PAGE = "mainPage.xhtml";
    
    public static String MAIN_PAGE_MESSAGE = "mainMessages";
    
    public static String LOGIN_PAGE_MESSAGE = "loginMessages";
}
