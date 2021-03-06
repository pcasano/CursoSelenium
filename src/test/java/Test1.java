
import com.cursoselenium.Pages.LogInPage;
import com.cursoselenium.Pages.SignUpPage;
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
public class Test1 extends TestConfiguration{
    
    @BeforeSuite
    public void setTestCaseName(){ 
        this.testCaseName = Test1.class.getName();
    }   
    
    @Test
    public void test1(){
        SoftAssert softAssert = new SoftAssert();
        VoteToursPage voteToursPage = new VoteToursPage();
        voteToursPage.acceptCookies();
        LogInPage logInPage = voteToursPage.goToLogInPage();
        logInPage.introduceEmail(configFileReader.getHashMap().get("user"));
        logInPage.introducePassword(configFileReader.getHashMap().get("password"));
        SignUpPage signUpPage = logInPage.goToSignUpPage();
        signUpPage.checkTags(softAssert);
        signUpPage.introduceName("Pablo");
        signUpPage.introduceYear("2020");
        voteToursPage = signUpPage.goToVoteToursPage();
        
        
        softAssert.assertAll();
    }
    
}
