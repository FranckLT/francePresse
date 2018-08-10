/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.france_presse.db.method;


import fr.france_presse.db.utils.DBReporterUtils;
import fr.france_presse.java_bean.Reporter;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Method {
    
    public static List<Reporter> isReporterExists(String name) throws Exception{
        
        List<Reporter> listReporters = new ArrayList<>();

        listReporters = DBReporterUtils.returnOneReporterByName(name);
        
        if (listReporters.size()>0) {
            return listReporters;
        } else{
            
            DBReporterUtils.insertReporter(name);
            
            listReporters = DBReporterUtils.returnOneReporterByName(name);
            
            return listReporters;
            
        }
        
    }

}
