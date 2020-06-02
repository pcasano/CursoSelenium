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

    public SignUpPage() {
        this.confirmIdentity();
    }
    
    @Override
    public void confirmIdentity() {
        Assert.assertEquals(this.driver.findElement(By.id("main-title")).getText(), "Regístrate (es gratis)");       
    }
    public void introduceName(String name){
        WebElement emailInput = this.driver.findElement(By.name("nick"));
        emailInput.clear();
        emailInput.sendKeys(name);
    }    

    public void introduceYear(String year){
        WebElement emailYear = this.driver.findElement(By.name("year"));
        emailYear.clear();
        emailYear.sendKeys(year);
    }     
    
}
