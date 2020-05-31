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
public class SignUpPage extends BasePage{
    public SignUpPage(){
        this.confirmIdentity();
    }
    
    @Override
    public void confirmIdentity() {
        Assert.assertEquals(this.driver.findElement(By.id("main-title")).getText(), "Regístrate (es gratis)");
    }
    
    public void introducename(String name){
        WebElement nameInput = this.driver.findElement(By.name("nick"));
        nameInput.clear();
        nameInput.sendKeys(name);
    }

}
