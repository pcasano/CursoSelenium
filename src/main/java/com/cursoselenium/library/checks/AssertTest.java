/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cursoselenium.library.checks;

import com.cursoselenium.library.configuration.TestLogger;
import com.cursoselenium.library.recorder.RecorderImage;
import com.cursoselenium.library.recorder.RecorderMessages;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;

/**
 *
 * @author pablo
 */
public class AssertTest {
    private final RecorderMessages RECORDER_MESSAGES = new RecorderMessages();
    private final List<WebElement> LIST_NULL_ELEMENT = new ArrayList<>();
    private StackTraceElement[] stackTrace(){
        return Thread.currentThread().getStackTrace();
    }
    private void setMessageForRecorder(String message, boolean success, String image){
        RECORDER_MESSAGES.setMessageForRecorder(message, success, image);
    }     
    private void setStackTraceForLogger(){
        StackTraceElement[] stackTrace = this.stackTrace();
        for(int i=1;i<6;i++){
            TestLogger.setErrorLog(stackTrace[i].toString());
        }
        System.out.println("");
    } 
    
    protected void isEqualAssertTest(String actual, String expected, String message){
        String image = new RecorderImage(null).getImage(false);
        if(actual.equals(expected)){
            TestLogger.setInfoLog(message);
            this.setMessageForRecorder(message, true, image);
        }
        else{
            this.setMessageForRecorder(message +". Expected: "+ expected + " vs Actual: " + actual, false, image);
            TestLogger.setErrorLog(message + ". Expected: "+expected+" vs Actual: "+actual);
            this.setStackTraceForLogger();
        }
    }
    
    protected void isNotEqualAssertTest(String actual, String expected, String message){
        String image = new RecorderImage(null).getImage(false);
        if(!actual.equals(expected)){
            TestLogger.setInfoLog(message);
            this.setMessageForRecorder(message, true, image);
        }
        else{
            this.setMessageForRecorder(message +". Expected: "+ expected + " vs Actual: " + actual, false, image);
            TestLogger.setErrorLog(message + ". Expected: "+expected+" vs Actual: "+actual);
            this.setStackTraceForLogger();
        }
    }    
    
    protected void elementIsDisplayedAndTextEqualsAssertTest(WebElement webElement, String expected, String message){
        String image = new RecorderImage(webElement).getImage(true);
        if(webElement.isDisplayed() && webElement.getText().trim().equals(expected)){
            TestLogger.setInfoLog(message);
            this.setMessageForRecorder(message, true, image);
        }
        else{
            this.setMessageForRecorder(message +". Expected: "+ expected + " vs Actual: " + webElement.getText().trim(), false, image);
            TestLogger.setErrorLog(message + ". Expected: "+expected+" vs Actual: "+webElement.getText().trim());
            this.setStackTraceForLogger();
        }
    }
    
    protected void elementIsDisplayedAndTextContainsAssertTest(WebElement webElement, String expected, String message){
        String image = new RecorderImage(webElement).getImage(true);
        if(webElement.isDisplayed() && webElement.getText().trim().contains(expected)){
            TestLogger.setInfoLog(message);
            this.setMessageForRecorder(message, true, image);
        }
        else{
            this.setMessageForRecorder(message +". Expected: "+ expected + " vs Actual: " + webElement.getText().trim(), false, image);
            TestLogger.setErrorLog(message + ". Expected: "+expected+" vs Actual: "+webElement.getText().trim());
            this.setStackTraceForLogger();
        }
    }    
    
    protected void IsTrueAssertTest(boolean bool, String message){
        String image = new RecorderImage(null).getImage(false);
        if(bool){
            TestLogger.setInfoLog(message);
            this.setMessageForRecorder(message, true, image);
        }
        else{
            this.setMessageForRecorder(message + ". Expected: true vs Actual: " + bool, false, image);
            TestLogger.setErrorLog(message);
            this.setStackTraceForLogger();
        }
    }
    
    protected void IsFalseAssertTest(boolean bool, String message){
        String image = new RecorderImage(null).getImage(false);
        if(!bool){
            TestLogger.setInfoLog(message);
            this.setMessageForRecorder(message, true, image);
        }
        else{
            this.setMessageForRecorder(message + ". Expected: true vs Actual: " + bool, false, image);
            TestLogger.setErrorLog(message);
            this.setStackTraceForLogger();
        }
    }    
}
