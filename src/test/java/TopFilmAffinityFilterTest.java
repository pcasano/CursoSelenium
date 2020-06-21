
import com.cursoselenium.Pages.TopFilmaffinityPage;
import com.cursoselenium.Pages.VoteToursPage;
import com.cursoselenium.library.configuration.TestConfiguration;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pablo
 */
public class TopFilmAffinityFilterTest extends TestConfiguration{
    
    @BeforeSuite
    public void setTestCaseName(){ 
        this.testCaseName = Test1.class.getName();
    }   
    
    @Test
    public void test1() throws InterruptedException{
        SoftAssert softAssert = new SoftAssert();
        VoteToursPage voteToursPage = new VoteToursPage();
        voteToursPage.acceptCookies();
        TopFilmaffinityPage topFilmaffinityPage = voteToursPage.goToTopFilmaffinityPage();
        topFilmaffinityPage.introdueCountry("Estados Unidos");
        topFilmaffinityPage.clickOnApplyFilter();
        topFilmaffinityPage.checkFlags(softAssert);
        topFilmaffinityPage.setFromYear("2020");
        topFilmaffinityPage.setUntilYear("2020");
        topFilmaffinityPage.clickOnApplyFilter();
        topFilmaffinityPage.checkYears(softAssert);                
        softAssert.assertAll();
    }
    
}
