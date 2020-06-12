/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cursoselenium.library.checks;

import com.cursoselenium.library.configuration.TestLogger;
import org.openqa.selenium.WebElement;

/**
 *
 * @author pablo
 */
public class AssertTest {

    private StackTraceElement[] stackTrace(){
        return Thread.currentThread().getStackTrace();
    }
    
    private void setStackTraceForLogger(){
        StackTraceElement[] stackTrace = this.stackTrace();
        for(int i=1;i<6;i++){
            TestLogger.setErrorLog(stackTrace[i].toString());
        }
        System.out.println("");
    } 
    
    protected void isEqualAssertTest(String actual, String expected, String message){
        if(actual.equals(expected)){
            TestLogger.setInfoLog(message);
        }
        else{
            TestLogger.setErrorLog(message + ". Expected: "+expected+" vs Actual: "+actual);
            this.setStackTraceForLogger();
        }
    }
    
    protected void isNotEqualAssertTest(String actual, String expected, String message){
        if(!actual.equals(expected)){
            TestLogger.setInfoLog(message);
        }
        else{
            TestLogger.setErrorLog(message + ". Expected: "+expected+" vs Actual: "+actual);
            this.setStackTraceForLogger();
        }
    }    
    
    protected void elementIsDisplayedAndTextEqualsAssertTest(WebElement webElement, String expected, String message){
        if(webElement.isDisplayed() && webElement.getText().trim().equals(expected)){
            TestLogger.setInfoLog(message);
        }
        else{
            TestLogger.setErrorLog(message + ". Expected: "+expected+" vs Actual: "+webElement.getText().trim());
            this.setStackTraceForLogger();
        }
    }
    
    protected void elementIsDisplayedAndTextContainsAssertTest(WebElement webElement, String expected, String message){
        if(webElement.isDisplayed() && webElement.getText().trim().contains(expected)){
            TestLogger.setInfoLog(message);
        }
        else{
            TestLogger.setErrorLog(message + ". Expected: "+expected+" vs Actual: "+webElement.getText().trim());
            this.setStackTraceForLogger();
        }
    }    
    
    protected void IsTrueAssertTest(boolean bool, String message){
        if(bool){
            TestLogger.setInfoLog(message);
        }
        else{
            TestLogger.setErrorLog(message);
            this.setStackTraceForLogger();
        }
    }
    
    protected void IsFalseAssertTest(boolean bool, String message){
        if(!bool){
            TestLogger.setInfoLog(message);
        }
        else{
            TestLogger.setErrorLog(message);
            this.setStackTraceForLogger();
        }
    }    
}
