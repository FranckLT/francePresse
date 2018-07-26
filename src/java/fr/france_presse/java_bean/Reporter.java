/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.france_presse.java_bean;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Reporter {
    
    private int idReporter;
    
    private String name;
    
    public Reporter(int id, String name){
        
       this.idReporter = id;
       
       this.name = name;
    }
    
    public int getId(){
        return idReporter;
    }
    
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
    
    public void setId(int id){
        this.idReporter = id;
    }
}
