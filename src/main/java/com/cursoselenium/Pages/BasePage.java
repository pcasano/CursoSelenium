/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cursoselenium.Pages;

import com.cursoselenium.library.configuration.TestConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author pablo
 */
public abstract class BasePage {

protected WebDriver driver = TestConfiguration.driver;
public abstract void confirmIdentity();

public VoteToursPage goToVoteToursPage(){
    driver.findElement(By.xpath("//*[text()='Usuarios']/parent::div//a[text()='Votar los tours']")).click();
    return new VoteToursPage();
}

public LogInPage goToLogInPage(){
    driver.findElement(By.xpath("//*[text()='Usuarios']/parent::div//a[text()='Iniciar sesión']")).click();
    return new LogInPage();
}

public SignUpPage goToSignUpPage(){
    driver.findElement(By.xpath("//*[text()='Usuarios']/parent::div//a[text()='Registrarse']")).click();
    return new SignUpPage();
}

}
