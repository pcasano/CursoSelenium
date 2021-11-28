/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cursoselenium;

/**
 *
 * @author pablo
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
//        String browser = "chrome";  
//
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\pablo\\Documents\\NetBeansProjects\\CursoSelenium\\Drivers\\chromedriver.exe");
//        System.setProperty("webdriver.gecko.driver", "C:\\Users\\pablo\\Documents\\NetBeansProjects\\CursoSelenium\\Drivers\\geckodriver.exe");
//        WebDriver driver = null;
//        if(browser.equals("chrome")){
//            driver = new ChromeDriver();
//        }
//        else{
//            driver = new FirefoxDriver();
//        }
//        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
//        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//        driver.get("https://www.filmaffinity.com/es");
//        driver.manage().window().maximize();                
//        WebElement cookies = driver.findElement(By.xpath("//*[@id='qcCmpButtons']/button[@class='qc-cmp-button']"));
//        cookies.click();
//        
//        
//        driver.findElement(By.xpath("//*[text()='Registrarse' and @class='register']")).click();
//
//        WebElement nickField = driver.findElement(By.name("nick"));
//        nickField.sendKeys("Javier");
//        nickField.clear();
//        nickField.sendKeys("Pablo");
//        
//        driver.findElement(By.name("year")).sendKeys("2020");
//        
//        driver.findElement(By.id("sex-button")).click();
//        driver.findElement(By.xpath("//*[text()='Femenino' and starts-with(@class, 'ui-menu')]")).click();
//        
//        
//        driver.findElement(By.name("city")).sendKeys("Munich");
//        
//        driver.findElement(By.id("country-button")).click();
//        driver.findElement(By.xpath("//*[text()='Alemania' and starts-with(@class, 'ui-menu')]")).click();   
//        
//        
//        driver.findElement(By.name("email")).sendKeys("selenium@test.com");
//        
//
//        WebElement checkBox = driver.findElement(By.name("discover_by_email"));
//        System.out.println("El estado es: "+checkBox.isSelected());
//        checkBox.click();
//        System.out.println("El estado es: "+checkBox.isSelected());
//

//div[@class='mini-tours']//a
//*[text()='España']/parent::div//a[contains(text(),'strenos')]
//*[text()='España']/parent::div//a[contains(text(),'strenos')]
//*[@class='movie-card-13']//div[starts-with(text(),'The')]
//*[@class='movie-card-13'']//div[starts-with(text(),'The')]
//*[text()='España' and @class='lsmheader']/parent::div//a[contains(text(),'strenos')]   =   //*[text()='España'][@class='lsmheader']/parent::div//a[contains(text(),'strenos')]


        //System.out.println("Xpath1: "+ new XpathBuilder().any("div").attribute("class", "mini-tours").down("a").toString());
        //System.out.println("Xpath2: "+ new XpathBuilder().any().text("España").parent("div").down("a").textContains("strenos").toString());
        //System.out.println("Xpath3: "+ new XpathBuilder().any().attribute("class", "movie-card-13").down("div").textStartsWith("The").toString());

        
    } 
}
