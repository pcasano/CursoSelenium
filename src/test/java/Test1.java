
import com.cursoselenium.Pages.LogInPage;
import com.cursoselenium.Pages.SignUpPage;
import com.cursoselenium.Pages.VoteToursPage;
import com.cursoselenium.library.configuration.TestConfiguration;
import com.cursoselenium.library.configuration.TestLogger;
import org.testng.annotations.Test;

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
    
    @Test
    public void test1(){
        VoteToursPage voteToursPage = new VoteToursPage();
        LogInPage logInPage = voteToursPage.goToLogInPage();
        logInPage.introduceEmail(configFileReader.getHashMap().get("user"));
        logInPage.introducePassword(configFileReader.getHashMap().get("password"));
        SignUpPage signUpPage = logInPage.goToSignUpPage();
        signUpPage.introduceName("Pablo");
        signUpPage.introduceYear("2020");
        voteToursPage = signUpPage.goToVoteToursPage();

        
        
    }
    
}
