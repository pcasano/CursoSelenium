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
        Assert.assertEquals(DRIVER.findElement(By.xpath("main-title"), "get text of element").getText(), "Regístrate (es gratis)");       
    }
    public void introduceName(String name){

        DRIVER.fillInput(By.name("nick"), name, "introduce name: "+ name);
    }    

    public void introduceYear(String year){
        DRIVER.fillInput(By.name("year_"), 12 , year, "introduce year: "+ year);
    }     
    
}
