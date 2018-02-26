package tie.hackathon.travelguide.Screens;

import tie.hackathon.travelguide.Constants.Strings;
import tie.hackathon.travelguide.R;
import tie.hackathon.travelguide.Tests.Helpers;

import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by valentin.boca on 2/22/2018.
 */

public class MainPage {
    public static void openNavDrawer() throws Exception {
        Helpers.clickOnObjectWithContentDesc(R.string.navigation_drawer_open);
    }

    public static void signOut() throws Exception {
        Helpers.clickOnObjectWithContentDesc(R.string.navigation_drawer_open);
        Helpers.clickOnAView(R.id.nav_view, withId(R.id.design_navigation_view), 8);
        LoginPage.waitForTheLoginPageToBeDisplayed();
    }

    public static boolean isSearchACityDisplayed() throws Exception {
        return Helpers.isObjectWithIdDisplayed(R.id.cityname);
    }

    public static void waitForTheMainScreenToBeDisplayed() throws Exception {
        if(!isSearchACityDisplayed()) {
            throw new Exception("The main screen is not displayed");
        }
    }

    public static boolean isACityFromMainPageDisplayed(String text, int rid) throws Exception {
        return Helpers.isObjectWithTextAndIdDisplyed(text, rid);
    }

    public static void waitForCityToBeDisplayed(String text, int rid) throws Exception {
        if(!isACityFromMainPageDisplayed(text, rid)) {
            throw new Exception("The city is not displayed");
        }
    }

    public static void clickACityFromMainPage(String text, int rid) throws Exception {
        Helpers.clickASpecificObjectWithTextAndId(text, rid);
    }

    public static void login() throws Exception {
        LoginPage.waitForTheLoginPageToBeDisplayed();
        LoginPage.tapLogInString();
        LoginPage.logIn(Strings.PHONE_NO, Strings.PASSWORD);
        LoginPage.tapLogInButton();
        MainPage.waitForTheMainScreenToBeDisplayed();
    }
}