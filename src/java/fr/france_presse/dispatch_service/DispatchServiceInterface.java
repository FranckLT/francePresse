/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.france_presse.dispatch_service;

import fr.france_presse.java_bean.Dispatch;
import java.util.List;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public interface DispatchServiceInterface {
    
    public List<Dispatch> getListDispatchs();
    
    public void addDispatch(Dispatch dispatch);
    
    public List<Dispatch> getLast10Dispatchs();
    
    public Dispatch getOneDispatch(String id);
    
}
