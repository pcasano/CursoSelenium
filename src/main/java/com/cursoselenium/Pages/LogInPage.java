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
        Assert.assertEquals(DRIVER.findElement(By.xpath("main-title"), "get text of element").getText(), "Inicio de sesión");       
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
