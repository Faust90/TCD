/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcd.utils;

/**
 * Class for Query Parameters
 *
 * @author "Jacopo 'Faust' Buttiglieri"
 */
public class Parameter {
    
    private int type;
    private String value;

    /**
     * Constructor
     * 
     * @param type the type of the parameter (take from java.sql.Types)
     * @param value the string value of the parameter
     */
    public Parameter(int type, String value) {
        this.type = type;
        this.value = value;
    }    

    /**
     * Private constructor
     */
    private Parameter() {
      
    }
        
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
    
    
}
