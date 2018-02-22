package tie.hackathon.travelguide.Tests;

import org.junit.Assert;
import org.junit.Test;

import tie.hackathon.travelguide.Constants.Strings;
import tie.hackathon.travelguide.R;
import tie.hackathon.travelguide.Screens.LoginPage;
import tie.hackathon.travelguide.Screens.MainPage;

/**
 * Created by valentin.boca on 2/21/2018.
 */

public class DemoTest extends EspressoTestBase {

    @Test
    public void testIfSignUpIsSuccessful() throws Exception {
        LoginPage.signUp("user", "0754211009", "test1234");
        LoginPage.tapSignUp();
        MainPage.signOut();
        Assert.assertTrue("The login page is not displayed", Helpers.isIdDisplayed(R.id.ok_signup));
    }

    @Test
    public void testIfLogInIsSuccessful() throws Exception {
        LoginPage.tapLogIn();
        LoginPage.logIn("0754211009", "test1234");
        LoginPage.tapLogInButton();
        Assert.assertTrue("The main page is not displayed", Helpers.isStringDisplayed(Strings.TRAVEL_MATE));
    }
}