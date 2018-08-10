/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.france_presse.dispatch_service;

import fr.france_presse.db.utils.DBDispatchUtils;
import fr.france_presse.java_bean.Dispatch;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class DispatchServiceDB implements DispatchServiceInterface{

    @Override
    public List<Dispatch> getListDispatchs() {
        try {
            List<Dispatch> listDispatchs =  DBDispatchUtils.returnAllDispatch();
            return listDispatchs;
            
        } catch (Exception ex) {
            Logger.getLogger(DispatchServiceDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void addDispatch(Dispatch dispatch) {
        
        try {
            DBDispatchUtils.insertDispatch(dispatch);
        } catch (Exception ex) {
            Logger.getLogger(DispatchServiceDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public List<Dispatch> getLast10Dispatchs() {
        
        
        return null;
    }

    @Override
    public Dispatch getOneDispatch(String id) {
        try {
            return DBDispatchUtils.returnOneDispatchByID(id).get(0);
        } catch (Exception ex) {
            Logger.getLogger(DispatchServiceDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    

}
