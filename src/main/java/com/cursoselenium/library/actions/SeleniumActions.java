/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cursoselenium.library.actions;

import com.cursoselenium.library.configuration.TestConfiguration;
import com.cursoselenium.library.configuration.TestLogger;
import com.cursoselenium.library.recorder.RecorderImage;
import com.cursoselenium.library.recorder.RecorderMessages;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author pablo
 */
public class SeleniumActions {
    private final RecorderMessages RECORDER_MESSAGES = new RecorderMessages();
    private final List<WebElement> LIST_NULL_ELEMENT = new ArrayList<>();
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
    private void setMessageForRecorder(String message, boolean success, String image){
        RECORDER_MESSAGES.setMessageForRecorder(message, success, image);
    }             
    public WebElement findElement(By by, String message){
        String image; 
        try{
            WebElement webElement = TestConfiguration.driver.findElement(by);
            image = new RecorderImage(webElement).getImage(true);
            TestLogger.setInfoLog(message);
            this.setMessageForRecorder(message, true, image);
            return webElement;
        }catch(Exception e){
            this.setStackTraceForLogger();
            image = new RecorderImage(null).getImage(false);
            this.setMessageForRecorder(message + ". -> "+ e.getMessage(), false, image);              
            TestLogger.setErrorLog(message + ". -> " + e.toString());
            throw new NoSuchElementException("");
        }
    }
    
    public WebElement findElement(WebElement context, By by, String message){
        String image; 
        try{
            WebElement webElement = context.findElement(by);
            image = new RecorderImage(webElement).getImage(true);
            TestLogger.setInfoLog(message);
            this.setMessageForRecorder(message, true, image);
            return webElement;
        }catch(Exception e){
            this.setStackTraceForLogger();
            image = new RecorderImage(null).getImage(false);
            this.setMessageForRecorder(message + ". -> "+ e.getMessage(), false, image);            
            TestLogger.setErrorLog(message + ". -> " + e.toString());
            throw new NoSuchElementException("");
        }
    }  
    
    public WebElement findElement(By by, int timeout, String message){
        String image;
        WebDriverWait wait = new WebDriverWait(TestConfiguration.driver, Long.valueOf(timeout));
        try{
            WebElement webElement = wait.until(ExpectedConditions.presenceOfElementLocated(by));
            image = new RecorderImage(webElement).getImage(true);
            TestLogger.setInfoLog(message);
            this.setMessageForRecorder(message, true, image);
            return webElement;
        }catch(Exception e){
            this.setStackTraceForLogger();
            image = new RecorderImage(null).getImage(false);
            this.setMessageForRecorder(message + ". -> "+ e.getMessage(), false, image);              
            TestLogger.setErrorLog(message + ". -> " + e.toString());
            throw new NoSuchElementException("");
        }
    } 
    
    public List<WebElement> findElements(By by, String message){
        String image;
        try{
            List<WebElement> listOfWebElement = TestConfiguration.driver.findElements(by);
            image = new RecorderImage(null).getImage(false);
            TestLogger.setInfoLog(message);
            this.setMessageForRecorder(message, true, image);
            return listOfWebElement;
        }catch(Exception e){
            this.setStackTraceForLogger();
            image = new RecorderImage(null).getImage(false);
            this.setMessageForRecorder(message + ". -> "+ e.getMessage(), false, image);  
            TestLogger.setErrorLog(message + ". -> " + e.toString());
            throw new NoSuchElementException("");
        }
    }  
    
    public List<WebElement> findElements(WebElement context, By by, String message){
        try{
            List<WebElement> listOfWebElement = context.findElements(by);
            TestLogger.setInfoLog(message);
            return listOfWebElement;
        }catch(Exception e){
            this.setStackTraceForLogger();
            TestLogger.setErrorLog(message + ". -> " + e.toString());
            throw new NoSuchElementException("");
        }
    }     


     public void clickElement(By by, String message){
        String image; 
        try{
            WebElement webElement = TestConfiguration.driver.findElement(by);
            image = new RecorderImage(webElement).getImage(true);
            webElement.click();
            TestLogger.setInfoLog(message);
            this.setMessageForRecorder(message, true, image);
        }catch(Exception e){
            this.setStackTraceForLogger();
            image = new RecorderImage(null).getImage(false);
            this.setMessageForRecorder(message + ". -> "+ e.getMessage(), false, image);            
            TestLogger.setErrorLog(message + ". -> " + e.toString());
            throw new NoSuchElementException("");
        }
    }  
     
     public void clickElement(WebElement webElement, String message){
        String image; 
        try{
            image = new RecorderImage(webElement).getImage(true);
            webElement.click();
            TestLogger.setInfoLog(message);
            this.setMessageForRecorder(message, true, image);

        }catch(Exception e){
            this.setStackTraceForLogger();
            image = new RecorderImage(null).getImage(false);
            this.setMessageForRecorder(message + ". -> "+ e.getMessage(), false, image);              
            TestLogger.setErrorLog(message + ". -> " + e.toString());
            throw new NoSuchElementException("");
        }
    }       
    
     public void clickElement(WebElement context, By by, String message){
        String image;
        try{            
            WebElement webElement = context.findElement(by);
            image = new RecorderImage(webElement).getImage(true);
            webElement.click();
            TestLogger.setInfoLog(message);
            this.setMessageForRecorder(message, true, image);

        }catch(Exception e){
            this.setStackTraceForLogger();
            image = new RecorderImage(null).getImage(false);
            this.setMessageForRecorder(message + ". -> "+ e.getMessage(), false, image);            
            TestLogger.setErrorLog(message + ". -> " + e.toString());
            throw new NoSuchElementException("");
        }
    } 
     
     public void clickElement(By by, int timeout, String message){
        String image;
        WebDriverWait wait = new WebDriverWait(TestConfiguration.driver, Long.valueOf(timeout));
        try{
            WebElement webElement = wait.until(ExpectedConditions.presenceOfElementLocated(by));
            image = new RecorderImage(webElement).getImage(true);
            webElement.click();
            TestLogger.setInfoLog(message);
            this.setMessageForRecorder(message, true, image);

        }catch(Exception e){
            this.setStackTraceForLogger();
            image = new RecorderImage(null).getImage(false);
            this.setMessageForRecorder(message + ". -> "+ e.getMessage(), false, image);                  
            TestLogger.setErrorLog(message + ". -> " + e.toString());
            throw new NoSuchElementException("");
        }
    } 
     
    public void fillInput(By by, String input, String message){
        String image;
        try{
            WebElement webElement = TestConfiguration.driver.findElement(by);
            image = new RecorderImage(webElement).getImage(true);
            webElement.clear();
            webElement.sendKeys(input);
            TestLogger.setInfoLog(message);
            this.setMessageForRecorder(message, true, image);
        }
        catch(Exception e){
            this.setStackTraceForLogger();
            image = new RecorderImage(null).getImage(false);
            this.setMessageForRecorder(message + ". -> "+ e.getMessage(), false, image);             
            TestLogger.setErrorLog(message + ". -> " + e.toString());
            throw new NoSuchElementException("");
        }
    }
    
    public void fillInput(WebElement context, By by, String input, String message){
        String image;
        try{
            WebElement webElement = context.findElement(by);  
            image = new RecorderImage(webElement).getImage(true);
            webElement.clear();
            webElement.sendKeys(input);
            TestLogger.setInfoLog(message);
            this.setMessageForRecorder(message, true, image);
        }
        catch(Exception e){
            this.setStackTraceForLogger();
            image = new RecorderImage(null).getImage(false);
            this.setMessageForRecorder(message + ". -> "+ e.getMessage(), false, image); 
            TestLogger.setErrorLog(message + ". -> " + e.toString());
            throw new NoSuchElementException("");
        }
    } 
    
    public void fillInput(WebElement webElement, String input, String message){
        String image;
        try{       
            image = new RecorderImage(webElement).getImage(true);
            webElement.clear();
            webElement.sendKeys(input);
            TestLogger.setInfoLog(message);
            this.setMessageForRecorder(message, true, image);
        }
        catch(Exception e){
            this.setStackTraceForLogger();
            image = new RecorderImage(null).getImage(false);
            this.setMessageForRecorder(message + ". -> "+ e.getMessage(), false, image); 
            TestLogger.setErrorLog(message + ". -> " + e.toString());
            throw new NoSuchElementException("");
        }
    }
    
    public void fillInput(By by, int timeout, String input, String message){
        String image;
        WebDriverWait wait = new WebDriverWait(TestConfiguration.driver, Long.valueOf(timeout));
        try{
            WebElement webElement = wait.until(ExpectedConditions.presenceOfElementLocated(by));        
            image = new RecorderImage(webElement).getImage(true);
            webElement.clear();
            webElement.sendKeys(input);
            TestLogger.setInfoLog(message);
            this.setMessageForRecorder(message, true, image);
        }
        catch(Exception e){
            this.setStackTraceForLogger();
            image = new RecorderImage(null).getImage(false);
            this.setMessageForRecorder(message + ". -> "+ e.getMessage(), false, image);             
            TestLogger.setErrorLog(message + ". -> " + e.toString());
            throw new NoSuchElementException("");
        }
    }     
}
