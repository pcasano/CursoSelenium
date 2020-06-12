/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cursoselenium.library.checks;

import com.cursoselenium.library.actions.SeleniumActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/**
 *
 * @author pablo
 */
public class HardAssertTest extends AssertTest{
    
    private SeleniumActions seleniumActions = new SeleniumActions();
    
    public void isEqual(String actual, String expected, String message){
        isEqualAssertTest(actual, expected, "ASSERT: " + message);
        Assert.assertEquals(actual, expected);
    }
    
    public void elementIsDisplayedAndTextEquals(WebElement webElement, String expected, String message){
        elementIsDisplayedAndTextEqualsAssertTest(webElement, expected, "ASSERT: " + message);
        Assert.assertEquals(webElement.getText().trim(), expected);
    }
    
    public void isTrue(boolean bool, String message){
        IsTrueAssertTest(bool, "ASSERT: " + message);
        Assert.assertTrue(bool);
    }

    public void elementIsDisplayedAndTextContains(WebElement webElement, String expected, String message){
        elementIsDisplayedAndTextContainsAssertTest(webElement, expected, "ASSERT: " + message);
        Assert.assertTrue(webElement.getText().contains(expected));
    } 
    
    public void isNotEqual(String actual, String expected, String message){
        isNotEqualAssertTest(actual, expected, "ASSERT: " + message);
        Assert.assertNotEquals(actual, expected);
    }  
    
    public void isFalse(boolean bool, String message){
        IsFalseAssertTest(bool, "ASSERT: " + message);
        Assert.assertFalse(bool);
    }    
    
    public void elementIsDisplayedAndTextEquals(By by, String expected, String message){
        WebElement webElement = seleniumActions.findElement(by, "");
        elementIsDisplayedAndTextEqualsAssertTest(webElement, expected, "ASSERT: " + message);
        Assert.assertEquals(webElement.getText().trim(), expected);
    }    
    
}
