/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cursoselenium.library.actions;

import com.cursoselenium.library.configuration.TestConfiguration;
import com.cursoselenium.library.configuration.TestLogger;
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
    
    
    public WebElement findElement(By by, String message){
        try{
            WebElement webElement = TestConfiguration.driver.findElement(by);
            TestLogger.setInfoLog(message);
            return webElement;
        }catch(Exception e){
            this.setStackTraceForLogger();
            TestLogger.setErrorLog(message + ". -> " + e.toString());
            throw new NoSuchElementException("");
        }
    }
    
    public WebElement findElement(WebElement context, By by, String message){
        try{
            WebElement webElement = context.findElement(by);
            TestLogger.setInfoLog(message);
            return webElement;
        }catch(Exception e){
            this.setStackTraceForLogger();
            TestLogger.setErrorLog(message + ". -> " + e.toString());
            throw new NoSuchElementException("");
        }
    }  
    
    public WebElement findElement(By by, int timeout, String message){
        WebDriverWait wait = new WebDriverWait(TestConfiguration.driver, Long.valueOf(timeout));
        try{
            WebElement webElement = wait.until(ExpectedConditions.presenceOfElementLocated(by));
            TestLogger.setInfoLog(message);
            return webElement;
        }catch(Exception e){
            this.setStackTraceForLogger();
            TestLogger.setErrorLog(message + ". -> " + e.toString());
            throw new NoSuchElementException("");
        }
    } 
    
    public List<WebElement> findElements(By by, String message){
        try{
            List<WebElement> listOfWebElement = TestConfiguration.driver.findElements(by);
            TestLogger.setInfoLog(message);
            return listOfWebElement;
        }catch(Exception e){
            this.setStackTraceForLogger();
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
        try{
            WebElement webElement = TestConfiguration.driver.findElement(by);
            webElement.click();
            TestLogger.setInfoLog(message);

        }catch(Exception e){
            this.setStackTraceForLogger();
            TestLogger.setErrorLog(message + ". -> " + e.toString());
            throw new NoSuchElementException("");
        }
    }  
     
     public void clickElement(WebElement webElement, String message){
        try{
            webElement.click();
            TestLogger.setInfoLog(message);

        }catch(Exception e){
            this.setStackTraceForLogger();
            TestLogger.setErrorLog(message + ". -> " + e.toString());
            throw new NoSuchElementException("");
        }
    }       
    
     public void clickElement(WebElement context, By by, String message){
        try{
            WebElement webElement = context.findElement(by);
            webElement.click();
            TestLogger.setInfoLog(message);

        }catch(Exception e){
            this.setStackTraceForLogger();
            TestLogger.setErrorLog(message + ". -> " + e.toString());
            throw new NoSuchElementException("");
        }
    } 
     
     public void clickElement(By by, int timeout, String message){
        WebDriverWait wait = new WebDriverWait(TestConfiguration.driver, Long.valueOf(timeout));
        try{
            WebElement webElement = wait.until(ExpectedConditions.presenceOfElementLocated(by));
            webElement.click();
            TestLogger.setInfoLog(message);

        }catch(Exception e){
            this.setStackTraceForLogger();
            TestLogger.setErrorLog(message + ". -> " + e.toString());
            throw new NoSuchElementException("");
        }
    } 
     
    public void fillInput(By by, String input, String message){
        try{
            WebElement webElement = TestConfiguration.driver.findElement(by);        
            webElement.clear();
            webElement.sendKeys(input);
            TestLogger.setInfoLog(message);
        }
        catch(Exception e){
            this.setStackTraceForLogger();
            TestLogger.setErrorLog(message + ". -> " + e.toString());
            throw new NoSuchElementException("");
        }
    }
    
    public void fillInput(WebElement context, By by, String input, String message){
        try{
            WebElement webElement = context.findElement(by);        
            webElement.clear();
            webElement.sendKeys(input);
            TestLogger.setInfoLog(message);
        }
        catch(Exception e){
            this.setStackTraceForLogger();
            TestLogger.setErrorLog(message + ". -> " + e.toString());
            throw new NoSuchElementException("");
        }
    } 
    
    public void fillInput(WebElement webElement, String input, String message){
        try{       
            webElement.clear();
            webElement.sendKeys(input);
            TestLogger.setInfoLog(message);
        }
        catch(Exception e){
            this.setStackTraceForLogger();
            TestLogger.setErrorLog(message + ". -> " + e.toString());
            throw new NoSuchElementException("");
        }
    }
    
    public void fillInput(By by, int timeout, String input, String message){
        WebDriverWait wait = new WebDriverWait(TestConfiguration.driver, Long.valueOf(timeout));
        try{
            WebElement webElement = wait.until(ExpectedConditions.presenceOfElementLocated(by));        
            webElement.clear();
            webElement.sendKeys(input);
            TestLogger.setInfoLog(message);
        }
        catch(Exception e){
            this.setStackTraceForLogger();
            TestLogger.setErrorLog(message + ". -> " + e.toString());
            throw new NoSuchElementException("");
        }
    }     
}
