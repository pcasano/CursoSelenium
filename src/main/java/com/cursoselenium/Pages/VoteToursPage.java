/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cursoselenium.Pages;

import com.cursoselenium.library.actions.XpathBuilder;
import org.openqa.selenium.By;
import org.testng.Assert;

/**
 *
 * @author pablo
 */
public class VoteToursPage extends BasePage{
public VoteToursPage(){
    this.confirmIdentity();
}
    @Override
    public void confirmIdentity() {
        Assert.assertEquals(DRIVER.findElement(By.xpath("main-title"), "get text of element").getText(), "Tours de votación");   
    }
   
    public void clcikOnAction(){
        //DRIVER.clickElement(By.xpath("//*[@class='ttitle' and text()='Acción']"), "click on Action films");
        DRIVER.clickElement(new XpathBuilder().attribute("class", "ttitle").text("Acción").toBy(), "click on Action films");
    }
    
}
