package tie.hackathon.travelguide.Tests;

import org.junit.Assert;
import org.junit.Test;

import tie.hackathon.travelguide.Constants.Integers;
import tie.hackathon.travelguide.Constants.Strings;
import tie.hackathon.travelguide.Constants.Timeouts;
import tie.hackathon.travelguide.Screens.City;
import tie.hackathon.travelguide.Screens.LoginPage;
import tie.hackathon.travelguide.Screens.MainPage;
import tie.hackathon.travelguide.destinations.description.FinalCityInfo;
import utils.Constants;

/**
 * Created by valentin.boca on 2/21/2018.
 */

public class DemoTest extends EspressoTestBase {

    @Test(timeout = Timeouts.TEST_TIMEOUT_MEDIUM)
    public void testIfSignUpIsSuccessful() throws Exception {
        LoginPage.waitForTheLoginPageToBeDisplayed();
        LoginPage.signUp(Strings.USER, Strings.PHONE_NO, Strings.PASSWORD);
        LoginPage.tapSignUpButton();
        MainPage.waitForTheMainScreenToBeDisplayed();
        MainPage.signOut();
        LoginPage.waitForTheLoginPageToBeDisplayed();
    }

    @Test(timeout = Timeouts.TEST_TIMEOUT_MEDIUM)
    public void testIfLogInIsSuccessful() throws Exception {
        LoginPage.waitForTheLoginPageToBeDisplayed();
        LoginPage.tapLogInString();
        LoginPage.logIn(Strings.PHONE_NO, Strings.PASSWORD);
        LoginPage.tapLogInButton();
        MainPage.waitForTheMainScreenToBeDisplayed();
    }

    @Test(timeout = Timeouts.TEST_TIMEOUT_MEDIUM)
    public void testIfACityFromMainPageIsDisplayed() throws Exception {
        MainPage.waitForTheMainScreenToBeDisplayed();
        MainPage.waitForCityToBeDisplayed(Strings.CITY_MAIN_PAGE, Integers.CITY_ON_RIGHT_MAIN_PAGE);
        MainPage.clickACityFromMainPage(Strings.CITY_MAIN_PAGE, Integers.CITY_ON_RIGHT_MAIN_PAGE);
        City.waitForCityInfoToBeDisplayed(Strings.CITY_MAIN_PAGE, Integers.CITY_NAME);
    }
}