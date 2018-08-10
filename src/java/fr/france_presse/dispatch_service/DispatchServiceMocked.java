/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.france_presse.dispatch_service;

import fr.france_presse.java_bean.Dispatch;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class DispatchServiceMocked implements DispatchServiceInterface{
    
    List<Dispatch> listDispatchOrdered; 

    public DispatchServiceMocked() {
        
        listDispatchOrdered = new ArrayList<>();
    }
    
    
    
    public List<Dispatch> getListDispatchs(){
        
        return listDispatchOrdered;
    }
    
    public void addDispatch(Dispatch dispatch){
        listDispatchOrdered.add(dispatch);
    }
    
    public List<Dispatch> getLast10Dispatchs(){
        List<Dispatch> listOF10Dispatchs = new ArrayList<>();
        
        for (int i = 0; i<10; i++) {
            listOF10Dispatchs.add(listDispatchOrdered.get(i));
        }
        
        return listOF10Dispatchs;
    }

    @Override
    public Dispatch getOneDispatch(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
