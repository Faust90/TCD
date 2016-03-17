/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcd.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Handler for Query Parameters
 *
 * @author "Jacopo 'Faust' Buttiglieri"
 */
public class QueryParams {
    
    private List<Parameter> paramList;

    public QueryParams() {
        this(new ArrayList<>());
    }

    /**
     * Private constructor
     * 
     * @param paramList the parameters List
     */
    private QueryParams(List<Parameter> paramList) {
        this.paramList = paramList;
    }
    

    public List<Parameter> getParamList() {
        return paramList;
    }
    
    /**
     * Adds a new Parameter
     * 
     * @param param the parameter to add
     */
    public void add(Parameter param){        
        paramList.add(param);
    }
    
    /**
     * Adds a new Parameter
     * 
     * @param type the type of the parameter
     * @param value the value of the parameter
     */
    public void add(int type,String value){
        add(new Parameter(type, value));
    }
}
