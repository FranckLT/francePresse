/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.france_presse.reporter_services;

import fr.france_presse.java_bean.Reporter;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public interface ReporterServiceInterface {
    
    public Reporter getReporter(String name);
    
}
