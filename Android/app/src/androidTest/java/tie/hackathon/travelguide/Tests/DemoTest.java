package tie.hackathon.travelguide.Tests;

import org.junit.Assert;
import org.junit.Test;

import tie.hackathon.travelguide.Constants.Strings;
import tie.hackathon.travelguide.Constants.Timeouts;
import tie.hackathon.travelguide.R;
import tie.hackathon.travelguide.Screens.LoginPage;
import tie.hackathon.travelguide.Screens.MainPage;

/**
 * Created by valentin.boca on 2/21/2018.
 */

public class DemoTest extends EspressoTestBase {

    @Test(timeout = Timeouts.TEST_TIMEOUT_MEDIUM)
    public void testIfSignUpIsSuccessful() throws Exception {
        LoginPage.signUp(Strings.USER, Strings.PHONE_NO, Strings.PASSWORD);
        LoginPage.tapSignUpButton();
        Assert.assertTrue(Strings.MAIN_PAGE_NOT_DISPLAYED, MainPage.isScreenDisplayed(R.id.cityname));
        MainPage.signOut();
        Assert.assertTrue(Strings.LOGIN_PAGE_NOT_DISPLAYED, LoginPage.isLoginPageDispalyed(R.id.ok_signup));
    }

    @Test(timeout = Timeouts.TEST_TIMEOUT_MEDIUM)
    public void testIfLogInIsSuccessful() throws Exception {
        LoginPage.tapLogInString();
        LoginPage.logIn(Strings.PHONE_NO, Strings.PASSWORD);
        LoginPage.tapLogInButton();
        Assert.assertTrue(Strings.MAIN_PAGE_NOT_DISPLAYED, MainPage.isScreenDisplayed(R.id.cityname));
    }
}