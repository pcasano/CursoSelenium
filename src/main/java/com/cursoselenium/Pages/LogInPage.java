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
        ASSERT.elementIsDisplayedAndTextEquals(
                By.id("main-title"), 
                "Inicio de sesión", 
                "check LogIn Page title"
        );        
    }  
    
    public void introduceEmail(String email){

        DRIVER.fillInput(By.name("username"), email, "introduce email: "+ email);
    }
    public void introducePassword(String password){
        DRIVER.fillInput(By.name("password"), password, "introduce password: "+ password);
    }    
    
    public void clickOkButton(){
        DRIVER.clickElement(By.name("ok"), "click on OK button");
    }  
    
    
}
