/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.patientcare.patient.submodels;

import java.io.Serializable;

/**
 *
 * @author lilith
 */
public enum System implements Serializable{
    
        phone("phone","phone"), 
        fax("fax", "fax"), 
        email("email","email"), 
        pager("pager","pager"), 
        url("url","url"), 
        sms("sms","sms"), 
        other("other","other");
        
        private final String key;
        private final String value;

    System(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
        
}
