/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cursoselenium.Pages;

import com.cursoselenium.library.actions.SeleniumActions;
import com.cursoselenium.library.actions.XpathBuilder;
import com.cursoselenium.library.checks.HardAssertTest;
import com.cursoselenium.library.checks.SoftAssertTest;
import com.cursoselenium.library.configuration.TestConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author pablo
 */
public abstract class BasePage {
    protected final SeleniumActions DRIVER = new SeleniumActions();
    protected final HardAssertTest ASSERT = new HardAssertTest();
    protected final SoftAssertTest VERIFY = new SoftAssertTest();
    protected WebDriver driver = TestConfiguration.driver;
    public abstract void confirmIdentity();

    public VoteToursPage goToVoteToursPage(){
        DRIVER.clickElement(By.xpath("//*[text()='Usuarios']/parent::div//a[text()='Votar los tours']"), "navigate to Vote Tours Page");
        return new VoteToursPage();
    }

    public LogInPage goToLogInPage(){
        DRIVER.clickElement(By.xpath("//*[text()='Usuarios']/parent::div//a[text()='Iniciar sesión']"), "navigate to Log In Page");
        return new LogInPage();
    }

    public SignUpPage goToSignUpPage(){
        DRIVER.clickElement(By.xpath("//*[text()='Usuarios']/parent::div//a[text()='Registrarse']"), "navigate to Sign Up Page");
        return new SignUpPage();
    }
    public TopFilmaffinityPage goToTopFilmaffinityPage(){
        DRIVER.clickElement(new XpathBuilder().any().text("Top Filmaffinity").toBy(), "navigate to Top Filmaffinity Page");
        return new TopFilmaffinityPage();
    }   
    public void acceptCookies(){
        DRIVER.clickElement(new XpathBuilder().any().id("qcCmpButtons").child("button").textContains("Acepto").toBy(), "Accept cookies");
    }
    

}
