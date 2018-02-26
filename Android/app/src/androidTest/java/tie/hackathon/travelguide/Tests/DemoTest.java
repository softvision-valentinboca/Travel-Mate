package tie.hackathon.travelguide.Tests;

import android.support.test.espresso.Espresso;

import org.junit.Test;

import tie.hackathon.travelguide.Constants.Integers;
import tie.hackathon.travelguide.Constants.Strings;
import tie.hackathon.travelguide.Constants.Timeouts;
import tie.hackathon.travelguide.Screens.City;
import tie.hackathon.travelguide.Screens.LoginPage;
import tie.hackathon.travelguide.Screens.MainPage;

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
    }

    @Test(timeout = Timeouts.TEST_TIMEOUT_MEDIUM)
    public void testIfLogInIsSuccessful() throws Exception {
       MainPage.loginEndToEnd(Strings.PHONE_NO, Strings.PASSWORD);
    }

    @Test(timeout = Timeouts.TEST_TIMEOUT_MEDIUM)
    public void testIfACityFromMainPageIsDisplayed() throws Exception {
        MainPage.loginWaitForAndClickCity();
        Espresso.pressBack();
        MainPage.signOut();
    }

    @Test(timeout = Timeouts.TEST_TIMEOUT_MEDIUM)
    public void testIfFunFactsPageIsDisplayed() throws Exception {
        MainPage.loginWaitForAndClickCity();
        City.clickFunFacts();
        City.waitForFunFactsPageToBeDisplayed(Strings.CITY_MAIN_PAGE, Integers.CITY_NAME);
        City.navigateToMainMenu();
        MainPage.signOut();
    }

    @Test(timeout = Timeouts.TEST_TIMEOUT_MEDIUM)
    public void testIfMoreDetailsCityIsDisplayed() throws Exception {
        MainPage.loginEndToEnd(Strings.PHONE_NO, Strings.PASSWORD);
        MainPage.swipeCity();
        MainPage.waitForTheMainScreenToBeDisplayed();
        MainPage.signOut();
    }

    @Test(timeout = Timeouts.TEST_TIMEOUT_MEDIUM)
    public void testIfGoogleMapsIsDisplayed() throws Exception {
        MainPage.loginEndToEnd(Strings.PHONE_NO, Strings.PASSWORD);
        MainPage.waitForCityToBeDisplayed(Strings.CITY_MAIN_PAGE, Integers.CITY_ON_RIGHT_MAIN_PAGE);
        MainPage.swipeNavigateAndWaitGoogleMaps();
        MainPage.waitForTheMainScreenToBeDisplayed();
        MainPage.signOut();
    }
}