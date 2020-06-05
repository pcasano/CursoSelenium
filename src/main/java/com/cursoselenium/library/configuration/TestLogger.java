/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cursoselenium.library.configuration;
import org.apache.log4j.Logger;
/**
 *
 * @author pablo
 */
public class TestLogger {
    
    private static Logger log = Logger.getLogger(TestLogger.class);
    
    public static void setInfoLog(String message){
        log.info(message);
    }
    public static void setErrorLog(String message){
        log.error(message);
    }
    
}
