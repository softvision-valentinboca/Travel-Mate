package tie.hackathon.travelguide.Tests;

import android.support.test.espresso.Espresso;

import org.junit.Test;

import tie.hackathon.travelguide.Constants.Integers;
import tie.hackathon.travelguide.Constants.Strings;
import tie.hackathon.travelguide.Constants.Timeouts;
import tie.hackathon.travelguide.Screens.City;
import tie.hackathon.travelguide.Screens.LoginPage;
import tie.hackathon.travelguide.Screens.MainPage;
import tie.hackathon.travelguide.Screens.MoreCityDetails;
import tie.hackathon.travelguide.Screens.NavDrawer;
import tie.hackathon.travelguide.Screens.Travel;

/**
 * Created by valentin.boca on 2/21/2018.
 */

public class DemoTest extends EspressoTestBase {

    @Test(timeout = Timeouts.TEST_TIMEOUT_MEDIUM)
    public void testIfSignUpIsSuccessful() throws Exception {
        LoginPage.signupWithMuUseFlow();
        MainPage.waitForTheMainScreenToBeDisplayed();
        MainPage.signOut();
    }

    @Test(timeout = Timeouts.TEST_TIMEOUT_MEDIUM)
    public void testIfLogInIsSuccessful() throws Exception {
        MainPage.loginWithMuUseEndToEnd();
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
        MainPage.loginWithMuUseEndToEnd();
        MainPage.swipeCity();
        MainPage.waitForTheMainScreenToBeDisplayed();
        MainPage.signOut();
    }

    @Test(timeout = Timeouts.TEST_TIMEOUT_MEDIUM)
    public void testIfGoogleMapsIsDisplayed() throws Exception {
        MainPage.loginWithMuUseEndToEnd();
        MainPage.waitForCityToBeDisplayed(Strings.CITY_MAIN_PAGE, Integers.CITY_ON_RIGHT_MAIN_PAGE);
        MainPage.swipeLeftACityFromTheRightSideOfMainPage(Strings.CITY_MAIN_PAGE, Integers.CITY_ON_RIGHT_MAIN_PAGE);
        MainPage.waitForMoreDetailsForCityToBeDisplayed(Strings.CITY_MAIN_PAGE, Integers.MORE_DETAILS_TITLE);
        MoreCityDetails.tapViewOnMapString();
        MoreCityDetails.waitForGoogleMapsPageToBeDisplayed();
        Helpers.navigateBackToApp();
        MainPage.waitForMoreDetailsForCityToBeDisplayed(Strings.CITY_MAIN_PAGE, Integers.MORE_DETAILS_TITLE);
        MainPage.swipeRightACityFromTheRightSideOfMainPage(Strings.CITY_MAIN_PAGE, Integers.MORE_DETAILS_TITLE);
        MainPage.waitForTheMainScreenToBeDisplayed();
        MainPage.signOut();
    }

    @Test(timeout = Timeouts.TEST_TIMEOUT_MEDIUM) // incomplete test... work in progress
    public void testIfANewTripIsCreated() throws Exception {
        MainPage.loginWithMuUseEndToEnd();
        MainPage.waitForTheMainScreenToBeDisplayed();
        NavDrawer.NavigateToTravel();
        Travel.clickMyTrips();
        Travel.clickAddNewTrip();
        Travel.newTripFlow("Heey", "Dehli", 2018, 4, 2, 2018, 5, 2);
    }
}
