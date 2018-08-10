/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.france_presse.utils;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Method {
    
    public static String convertStreamToString(java.io.InputStream is) {
		
	    java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
	    
	    return s.hasNext() ? s.next() : "";
	    
	}
    
    public static String[] separateEsperluette(String code){
		
		String regex = "&";
		
		String tableParameters[] = code.split(regex);
           
		return tableParameters; 
	}
    
    public static String getLogin(String code){
		
		String regex = "&";
		
		String name[] = code.split(regex);
                
                String username = findUsername(name[0]);
                
		return username; 
	}
    
    public static String getPassword(String code){
        
                String regex = "&";
		
		String passwords[] = code.split(regex);
                
                String password = findPassword(passwords[1]);
                
		return password;
        
    }
    
    public static String  findUsername(String string){
		
		String regex = "=";
		
		String username[] = string.split(regex);
		
		return username[1];
		
	}
    
    public static String findPassword(String string){
        
                String regex = "=";
		
		String password[] = string.split(regex);
		
		return password[1];
    }
    
    public static String[] getPasswordAndLogin(String string){
        
        String username = getLogin(string).toLowerCase();
        
        String password = getPassword(string).toLowerCase();
        
        String[] tableauLogAndPassword = {username, password};
        
        return tableauLogAndPassword;
    }
    
    public static boolean verifyPassword(String s1, String s2){
        if (s1.equals(s2)) {
            return true;
        } else {
            return false;
        }
    }
    
    public static String findAttribute(String code){
	
	String regex = "=";
	
	String name[] = code.split(regex);
	
	return name[0];
	
}
    public static String findTitle(String code){
               
        String string = separateEsperluette(code)[0];
        
	String regex = "=";
	
	String name[] = string.split(regex);
	
	return name[1];
	
}
    
    public static String findReporter(String code){
        
        String string = separateEsperluette(code)[1];
        
        String regex = "=";
	
	String reporterName[] = string.split(regex);
        
        return reporterName[1];
    }
    
    public static Timestamp localDateTimeToTimestamp(LocalDateTime dateTime){
        
        Timestamp date = Timestamp.valueOf(dateTime);
        
        return date;
    }

}
