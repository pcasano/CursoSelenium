/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cursoselenium.Pages;

import com.cursoselenium.library.actions.xpathbuilder.XpathBuilder;
import org.openqa.selenium.By;

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
        ASSERT.elementIsDisplayedAndTextEquals(
                By.id("main-title"), 
                "Tours de votación", 
                "check VoteTours Page title"
        );
    }
   
    public void clcikOnAction(){
        DRIVER.clickElement(XpathBuilder.any().attribute("class", "ttitle").text("Acción").toBy(), "click on Action films");
    }
    
}
