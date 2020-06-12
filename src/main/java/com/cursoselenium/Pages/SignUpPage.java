/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cursoselenium.Pages;

import com.cursoselenium.library.actions.XpathBuilder;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;



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
        ASSERT.elementIsDisplayedAndTextEquals(
                By.id("main-title"), 
                "Regístrate (es gratis)", 
                "check SignUp Page title"
        );          
    }
    public void introduceName(String name){

        DRIVER.fillInput(By.name("nick"), name, "introduce name: "+ name);
    }    

    public void introduceYear(String year){
        DRIVER.fillInput(By.name("year"), 12 , year, "introduce year: "+ year);
    } 
    
    public void checkTags(SoftAssert softAssert){
        VERIFY.elementIsDisplayedAndTextEquals(
                softAssert, 
                new XpathBuilder().any("input").attribute("name", "nick").parent("div").child("div").toBy(), 
                "Nombre/Nick", 
                "check tag Name"
        );
        VERIFY.elementIsDisplayedAndTextEquals(
                softAssert, 
                new XpathBuilder().any("input").attribute("name", "year").parent("div").child("div").toBy(), 
                "Año de nacimiento:", 
                "check tag year"
        );        
        
    }
 
    
}
