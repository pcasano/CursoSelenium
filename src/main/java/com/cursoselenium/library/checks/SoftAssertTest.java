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
import org.testng.asserts.SoftAssert;

/**
 *
 * @author pablo
 */
public class SoftAssertTest extends AssertTest{
    
    private SeleniumActions seleniumActions = new SeleniumActions();
    
    public void isEqual(SoftAssert softAssert, String actual, String expected, String message){
        isEqualAssertTest(actual, expected, "VERIFY: " + message);
        softAssert.assertEquals(actual, expected);
    }
    
    public void elementIsDisplayedAndTextEquals(SoftAssert softAssert, WebElement webElement, String expected, String message){
        elementIsDisplayedAndTextEqualsAssertTest(webElement, expected, "VERIFY: " + message);
        softAssert.assertEquals(webElement.getText().trim(), expected);
    }
    
    public void isTrue(SoftAssert softAssert, boolean bool, String message){
        IsTrueAssertTest(bool, "VERIFY: " + message);
        softAssert.assertTrue(bool);
    }

    public void elementIsDisplayedAndTextContains(SoftAssert softAssert, WebElement webElement, String expected, String message){
        elementIsDisplayedAndTextContainsAssertTest(webElement, expected, "VERIFY: " + message);
        softAssert.assertTrue(webElement.getText().contains(expected));
    } 
    
    public void isNotEqual(SoftAssert softAssert, String actual, String expected, String message){
        isNotEqualAssertTest(actual, expected, "VERIFY: " + message);
        softAssert.assertNotEquals(actual, expected);
    }  
    
    public void isFalse(SoftAssert softAssert, boolean bool, String message){
        IsFalseAssertTest(bool, "VERIFY: " + message);
        softAssert.assertFalse(bool);
    } 
 
    public void elementIsDisplayedAndTextEquals(SoftAssert softAssert, By by, String expected, String message){
        WebElement webElement = seleniumActions.findElement(by, "");
        elementIsDisplayedAndTextEqualsAssertTest(webElement, expected, "VERIFY: " + message);
        softAssert.assertEquals(webElement.getText().trim(), expected);
    }     
    
}
