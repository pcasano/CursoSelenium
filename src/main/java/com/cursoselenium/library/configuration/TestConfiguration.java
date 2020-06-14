/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cursoselenium.library.configuration;

import com.cursoselenium.library.recorder.HtmlGenerator;
import com.cursoselenium.library.recorder.RecorderConfiguration;
import com.cursoselenium.library.recorder.RecorderElements;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;



/**
 *
 * @author pablo
 */
public class TestConfiguration {
    
    public static WebDriver driver;
    private final String PROPERTY_PATH = "C:\\Users\\pablo\\Documents\\NetBeansProjects\\cursoselenium\\Properties\\config.properties";  
    private final String PROPERTY_PATH_LOG4J = "C:\\Users\\pablo\\Documents\\NetBeansProjects\\cursoselenium\\Properties\\log4j.properties"; 
    protected ConfigFileReader configFileReader = new ConfigFileReader();
    public static long initialTime;
    protected String testCaseName;
    private StringBuilder htmlReportPathSB;
    public static ArrayList<RecorderElements> listOfMessagesForReport = new ArrayList<>();
    public static ArrayList<String[]> listOfStackForReport;    
        
    @BeforeClass
    public void setUp() throws FileNotFoundException, IOException {
        initialTime = new Date().getTime();        
        configFileReader.extractParameter();        
        String browser = configFileReader.getHashMap().get("browser");        
        InputStream input = new FileInputStream(PROPERTY_PATH);
        InputStream inputPropLog4J = new FileInputStream(PROPERTY_PATH_LOG4J);
        Properties prop = new Properties();
        Properties propLog4J = new Properties();
        prop.load(input);        
        propLog4J.load(inputPropLog4J);
        PropertyConfigurator.configure(propLog4J);        
        
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
        htmlReportPathSB = new StringBuilder().append(prop.getProperty("htmlReportPath")).append("//");
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(configFileReader.getHashMap().get("portal"));        
    }
    
    
    @AfterClass
    public void tearDown(ITestContext context){
        String reportPath = htmlReportPathSB.
                append("htmlReport_").
                append(testCaseName).
                append("_").
                append(new SimpleDateFormat("yyyy-MM-dd_HHmmss").format(new Date())).
                append(".html").toString();
        RecorderConfiguration recorderConfiguration = new RecorderConfiguration();
        recorderConfiguration.setNumberOfFailedTests(context.getFailedTests().size());
        recorderConfiguration.setTestCaseName(testCaseName);
        recorderConfiguration.setPathHtmlReport(reportPath);
        ConfigFileReader configFileReader = new ConfigFileReader();
        configFileReader.extractParameter(); 
        if(configFileReader.getHashMap().get("closeBrowser").equals("true")){
            driver.quit();
        }
        HtmlGenerator htmlGenerator = new HtmlGenerator(listOfMessagesForReport, recorderConfiguration);
        try{
            htmlGenerator.htmlGenerator();
        }catch(Exception e){
            TestLogger.setErrorLog("Error in the generation of html reports");
        }        
    }

    
}
