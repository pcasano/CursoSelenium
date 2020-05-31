/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cursoselenium.library.configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;



/**
 *
 * @author pablo
 */
public class TestConfiguration {
    
    public static WebDriver driver;
    public static ArrayList<String[]> listOfStackForReport;
    private final String PROPERTY_PATH = "C:\\Users\\pablo\\Documents\\NetBeansProjects\\cursoselenium\\Properties\\config.properties";  
    protected ConfigFileReader configFileReader = new ConfigFileReader();
        
    @BeforeClass
    public void setUp() throws IllegalArgumentException, FileNotFoundException, IOException{

                
        configFileReader.extractParameter();        
        String browser = configFileReader.getHashMap().get("browser");        
        InputStream input = new FileInputStream(PROPERTY_PATH);
        Properties prop = new Properties();
        prop.load(input);        
        
        if(browser.equals("chrome")){ 
            System.setProperty(prop.getProperty("chromeDriverProperty"), prop.getProperty("chromeDriverPath"));            
            driver = new ChromeDriver();
        }
        if(browser.equals("firefox")){  
            System.setProperty(prop.getProperty("firefoxDriverProperty"), prop.getProperty("firefoxDriverPath"));
            driver = new FirefoxDriver();
        }
        else{
            throw new IllegalArgumentException("Browser is not valid: "+browser);
        }  
        
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(configFileReader.getHashMap().get("portal"));        
    }
    
    
    @AfterClass
    public void tearDown(){

        ConfigFileReader configFileReader = new ConfigFileReader();
        configFileReader.extractParameter(); 
        if(configFileReader.getHashMap().get("closeBrowser").equals("true")){
            driver.quit();
        }
    }

    
}
