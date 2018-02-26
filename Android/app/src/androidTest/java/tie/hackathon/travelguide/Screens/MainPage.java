package tie.hackathon.travelguide.Screens;

import tie.hackathon.travelguide.Constants.Integers;
import tie.hackathon.travelguide.Constants.Strings;
import tie.hackathon.travelguide.R;
import tie.hackathon.travelguide.Tests.Helpers;

import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by valentin.boca on 2/22/2018.
 */

public class MainPage {
    public static boolean isSearchACityDisplayed() throws Exception {
        return Helpers.isObjectWithIdDisplayed(R.id.cityname);
    }

    public static void waitForTheMainScreenToBeDisplayed() throws Exception {
        if(!isSearchACityDisplayed()) {
            throw new Exception("The main screen is not displayed");
        }
    }

    public static void openNavDrawer() throws Exception {
        Helpers.clickOnObjectWithContentDesc(R.string.navigation_drawer_open);
    }

    public static void signOut() throws Exception {
        Helpers.clickOnObjectWithContentDesc(R.string.navigation_drawer_open);
        Helpers.clickOnAView(R.id.nav_view, withId(R.id.design_navigation_view), 8);
        LoginPage.waitForTheLoginPageToBeDisplayed();
    }

    public static boolean isACityFromMainPageDisplayed(String text, int rid) throws Exception {
        return Helpers.isObjectWithTextAndIdDisplyed(text, rid);
    }

    public static void waitForCityToBeDisplayed(String text, int rid) throws Exception {
        if(!isACityFromMainPageDisplayed(text, rid)) {
            throw new Exception("The city is not displayed");
        }
    }

    public static boolean areMoreDetailsOfACityFromMainPageDisplayed(String text, int rid) throws Exception {
        return Helpers.isObjectWithTextAndIdDisplyed(text, rid);
    }

    public static void waitForMoreDetailsForCityToBeDisplayed(String text, int rid) throws Exception {
        if(!areMoreDetailsOfACityFromMainPageDisplayed(text, rid)) {
            throw new Exception("The city details are not displayed");
        }
    }

    public static void clickACityFromMainPage(String text, int rid) throws Exception {
        Helpers.clickASpecificObjectWithTextAndId(text, rid);
    }

    public static void swipeLeftACityFromTheRightSideOfMainPage(String text, int rid) throws Exception {
        Helpers.swipeLeftASpecificObjectWithTextAndId(text, rid);
    }

    public static void swipeRightACityFromTheRightSideOfMainPage(String text, int rid) throws Exception {
        Helpers.swipeRightASpecificObjectWithTextAndId(text, rid);
    }

    public static void loginEndToEnd(String phone, String password) throws Exception {
        LoginPage.waitForTheLoginPageToBeDisplayed();
        LoginPage.tapLogInString();
        LoginPage.logInWithNumberAndPassword(phone, password);
        LoginPage.tapLogInButton();
        MainPage.waitForTheMainScreenToBeDisplayed();
    }

    public static void loginWaitForAndClickCity() throws Exception {
        MainPage.loginEndToEnd(Strings.PHONE_NO, Strings.PASSWORD);
        MainPage.waitForCityToBeDisplayed(Strings.CITY_MAIN_PAGE, Integers.CITY_ON_RIGHT_MAIN_PAGE);
        MainPage.clickACityFromMainPage(Strings.CITY_MAIN_PAGE, Integers.CITY_ON_RIGHT_MAIN_PAGE);
        City.waitForCityInfoToBeDisplayed(Strings.CITY_MAIN_PAGE, Integers.CITY_NAME);
    }

    public static void swipeCity() throws Exception{
        MainPage.waitForCityToBeDisplayed(Strings.CITY_MAIN_PAGE, Integers.CITY_ON_RIGHT_MAIN_PAGE);
        MainPage.swipeLeftACityFromTheRightSideOfMainPage(Strings.CITY_MAIN_PAGE, Integers.CITY_ON_RIGHT_MAIN_PAGE);
        MainPage.waitForMoreDetailsForCityToBeDisplayed(Strings.CITY_MAIN_PAGE, Integers.MORE_DETAILS_TITLE);
        MainPage.swipeRightACityFromTheRightSideOfMainPage(Strings.CITY_MAIN_PAGE, Integers.MORE_DETAILS_TITLE);
    }

    public static void swipeNavigateAndWaitGoogleMaps() throws Exception{
        MainPage.swipeLeftACityFromTheRightSideOfMainPage(Strings.CITY_MAIN_PAGE, Integers.CITY_ON_RIGHT_MAIN_PAGE);
        MainPage.waitForMoreDetailsForCityToBeDisplayed(Strings.CITY_MAIN_PAGE, Integers.MORE_DETAILS_TITLE);
        MoreCityDetails.tapViewOnMapString();
        MoreCityDetails.waitForGoogleMapsPageToBeDisplayed();
        Helpers.navigateBackToApp();
        MainPage.waitForMoreDetailsForCityToBeDisplayed(Strings.CITY_MAIN_PAGE, Integers.MORE_DETAILS_TITLE);
        MainPage.swipeRightACityFromTheRightSideOfMainPage(Strings.CITY_MAIN_PAGE, Integers.MORE_DETAILS_TITLE);
    }
}