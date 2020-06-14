/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cursoselenium.library.recorder;

import com.cursoselenium.library.configuration.TestConfiguration;
import java.util.Date;

/**
 *
 * @author pablo
 */
public class RecorderMessages {
    
    
    
    private String[] setStackTraceForRecorder(){        
        String[] myStringArray = new String[6];
        StackTraceElement[] stackTrace = this.stackTrace();
        for (int i=1;i<7;i++){
            myStringArray[i-1] = stackTrace[i+1].toString();
            }  
        return myStringArray;
    }
    
    private String getActionTime(long initialTime){     
        long actionTime_ = new Date().getTime();
        long actionTime = actionTime_ - initialTime;
        int minutes = (int) ((actionTime / 1000) / 60);
        int seconds = (int) (actionTime / 1000) % 60;
        return minutes + ":" + seconds;
    }    
    
    private StackTraceElement[] stackTrace(){
        return Thread.currentThread().getStackTrace();
    }    
    
    public void setMessageForRecorder(String message, boolean success, String image){
        RecorderElements element = new RecorderElements();
        element.setMessage(message);
        element.setSuccess(success);
        element.setImage(image);
        element.setActionTime(this.getActionTime(TestConfiguration.initialTime));
        element.setStackTraceArray(this.setStackTraceForRecorder());
        TestConfiguration.listOfMessagesForReport.add(element);
    } 
    
    public void setMessageForRecorder(String message, boolean success){
        RecorderElements element = new RecorderElements();
        element.setMessage(message);
        element.setSuccess(success);
        element.setActionTime(this.getActionTime(TestConfiguration.initialTime));
        element.setStackTraceArray(this.setStackTraceForRecorder());
        TestConfiguration.listOfMessagesForReport.add(element);
    }     
    
    
}
