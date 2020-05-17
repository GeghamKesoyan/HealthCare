/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.patient.enums;



/**
 *
 * @author lilith
 */
public enum AddressUse {

    home("home", "home"),
    temp("temp", "temp");
    

    private final String key;
    private final String value;

    AddressUse(String key, String value) {
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
