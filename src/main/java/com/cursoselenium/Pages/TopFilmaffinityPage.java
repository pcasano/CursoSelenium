/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cursoselenium.Pages;

import com.cursoselenium.helper.FilmData;
import com.cursoselenium.library.actions.XpathBuilder;
import com.cursoselenium.library.configuration.TestConfiguration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

/**
 *
 * @author pablo
 */
public class TopFilmaffinityPage extends BasePage{
    public TopFilmaffinityPage(){
        this.confirmIdentity();
    }

    @Override
    public void confirmIdentity() {
        ASSERT.elementIsDisplayedAndTextEquals(
                By.id("main-title"), 
                "Top FA: todas las películas y series de TV", 
                "check Top FilmAffinity page"
        );        
    }  
    
    public void introdueCountry(String country) {
        DRIVER.clickElement(By.id("country-button"), "click on country dropdown");
        WebElement countryToSelect = DRIVER.findElement(new XpathBuilder().any().id("country-menu").down("div").text(country).toBy(), "select: "+country);   
        Actions action = new Actions(TestConfiguration.driver);
        action.moveToElement(countryToSelect).click().build().perform();
    }
    
    public void introdueGenre(String genre) {
        DRIVER.clickElement(By.id("genre-button"), "click on genre dropdown");
        WebElement genreToSelect = DRIVER.findElement(new XpathBuilder().any().id("genre-menu").down("div").text(genre).toBy(), "select: "+genre);   
        Actions action = new Actions(TestConfiguration.driver);
        action.moveToElement(genreToSelect).click().build().perform();
    } 
    
    public WebElement getContextFirstDisplayedFilm(){
        return DRIVER.findElements(new XpathBuilder().any("ul").id("top-movies").down("ul").toBy(), "get first context").get(0);
    }
    
    public void goToFilmFromContext(WebElement context){
        DRIVER.clickElement(context, new XpathBuilder().down("div").attribute("class", "mc-title").child("a").toBy(), "go to film");
    }
    
    public FilmData getFilmData(WebElement context){
        FilmData filmData = new FilmData();
        filmData.setAvgRating(DRIVER.findElement(
                context, 
                new XpathBuilder().down("li").attribute("class", "data").child("div").attribute("class", "avg-rating").toBy(), 
                "get avg rating").getText());
        filmData.setRateCount(DRIVER.findElement(
                context, 
                new XpathBuilder().down("li").attribute("class", "data").child("div").attribute("class", "rat-count").toBy(), 
                "get avg count").getText());
        filmData.setCountry(DRIVER.findElement(
                context, 
                new XpathBuilder().down("img").attribute("class", "nflag").toBy(), 
                "get country").getAttribute("title"));
        filmData.setYear(DRIVER.findElement(
                context, 
                new XpathBuilder().down("div").attribute("class", "mc-title").toBy(), 
                "get year").getText());                        
        return filmData;
    } 
    
    public void checkData(SoftAssert softAssert, FilmData filmData){
        VERIFY.elementIsDisplayedAndTextEquals(
                softAssert, 
                By.id("movie-rat-avg"), 
                filmData.getAvgRating(), 
                "check average rating"
        );
        VERIFY.elementIsDisplayedAndTextEquals(
                softAssert, 
                new XpathBuilder().any().id("movie-count-rat").child("span").toBy(), 
                filmData.getRateCount(),
                "check rate count"
        ); 
        VERIFY.isEqual(
                softAssert, 
                DRIVER.findElement(new XpathBuilder().any().id("country-img").child("img").toBy(), "").getAttribute("title"), 
                filmData.getCountry(), 
                "check country"
        );
        List<WebElement> listOfElementsForGenre = DRIVER.findElements(
                new XpathBuilder().any().attribute("class", "card-genres").down("a").toBy(), 
                "get list of genre elements"
        );
        List<String> listOfStringsForGenre = new ArrayList<>();
        for (WebElement genre:listOfElementsForGenre){
            listOfStringsForGenre.add(genre.getText());
        }
        VERIFY.isTrue(
                softAssert, 
                listOfStringsForGenre.contains(filmData.getGerne()), 
                "check genre"
        );
        VERIFY.isTrue(
                softAssert, 
                filmData.getYear().contains(DRIVER.findElement(new XpathBuilder().any().id("left-column").down("dd").attribute("itemprop", "datePublished").toBy(), "").getText()), 
                "check year");
    }
    
    public void checkFlags(SoftAssert softAssert) throws InterruptedException{
        List<WebElement> listOfFlagElemets = DRIVER.findElements(
                new XpathBuilder().any().id("top-movies").down("img").attribute("class", "nflag").toBy(), 
                "find flag elements"
        );
        for (WebElement webElement:listOfFlagElemets){
            VERIFY.isTrue(
                    softAssert, 
                    webElement.getAttribute("src").contains("/imgs/countries2/US.png"), 
                    "check flag"
            );
        }       
    }
    
    public void clickOnApplyFilter(){
        DRIVER.clickElement(By.id("submit-form"), "apply filter");
    }
    
    public void setFromYear(String year){
        DRIVER.clickElement(By.id("fromyear-button"), "open from year dropdown");
        WebElement yearToSelect = DRIVER.findElement(new XpathBuilder().any().id("fromyear-menu").down("div").text(year).toBy(), "select "+year);         
        Actions action = new Actions(TestConfiguration.driver);
        action.moveToElement(yearToSelect).click().build().perform();      
    }
    
    public void setUntilYear(String year){
        DRIVER.clickElement(By.id("toyear-button"), "open until year dropdown");
        WebElement yearToSelect = DRIVER.findElement(new XpathBuilder().any().id("toyear-menu").down("div").text(year).toBy(), "select "+year);
        Actions action = new Actions(TestConfiguration.driver);
        action.moveToElement(yearToSelect).click().build().perform();          
    }    
    
    public void checkYears(SoftAssert softAssert) throws InterruptedException{
        List<WebElement> listOfMoviesElemets = DRIVER.findElements(
                new XpathBuilder().any().id("top-movies").down("div").attribute("class", "mc-title").toBy(), 
                "find movies elements"
        );
        for (WebElement movies:listOfMoviesElemets){           
            VERIFY.isTrue(
                    softAssert, 
                    movies.getText().contains("2020"), 
                    "check year of: " + movies.getText()
            );
        }
        
    }
    
}
