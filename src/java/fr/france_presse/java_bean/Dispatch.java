/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.france_presse.java_bean;

import java.time.LocalDateTime;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Dispatch {
    
    private int idDispatch;
    
    private String title;
    
    private LocalDateTime publishTime;
    
    private String reporterName;

    public int getIdDispatch() {
        return idDispatch;
    }

    public void setIdDispatch(int idDispatch) {
        this.idDispatch = idDispatch;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(LocalDateTime publishTime) {
        this.publishTime = publishTime;
    }

    public String getReporterName() {
        return reporterName;
    }

    public void setReporterName(String reporterName) {
        this.reporterName = reporterName;
    }

    
    
    
    
    

}
