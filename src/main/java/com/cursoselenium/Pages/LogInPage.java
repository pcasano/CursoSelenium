/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cursoselenium.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


/**
 *
 * @author pablo
 */
public class LogInPage extends BasePage{

    public LogInPage() {
        this.confirmIdentity();
    }
 
    
    @Override
    public void confirmIdentity() {
        Assert.assertEquals(this.driver.findElement(By.id("main-title")).getText(), "Inicio de sesión");       
    }  
    
    public void introduceEmail(String email){
        WebElement emailInput = this.driver.findElement(By.name("username"));
        emailInput.clear();
        emailInput.sendKeys(email);
    }
    public void introducePassword(String password){
        WebElement emailPassword = this.driver.findElement(By.name("password"));
        emailPassword.clear();
        emailPassword.sendKeys(password);
    }    
    
    public void clickOkButton(){
        this.driver.findElement(By.name("ok")).click();
    }  
    
    
}
