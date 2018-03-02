package tie.hackathon.travelguide.Screens;

import tie.hackathon.travelguide.R;
import tie.hackathon.travelguide.Tests.Helpers;

import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by valentin.boca on 3/1/2018.
 */

public class NavDrawer {
    public static void NavigateToDestinations() throws Exception {
        Helpers.clickOnObjectWithContentDesc(R.string.navigation_drawer_open);
        Helpers.clickOnAView(R.id.nav_view, withId(R.id.design_navigation_view), 1);
        Destinations.waitForTheDestinationScreenToBeDisplayed();
    }

    public static void NavigateToTravel() throws Exception {
        Helpers.clickOnObjectWithContentDesc(R.string.navigation_drawer_open);
        Helpers.clickOnAView(R.id.nav_view, withId(R.id.design_navigation_view), 2);
        Travel.waitForTheTravelScreenToBeDisplayed();
    }

    public static void NavigateToUtilities() throws Exception {
        Helpers.clickOnObjectWithContentDesc(R.string.navigation_drawer_open);
        Helpers.clickOnAView(R.id.nav_view, withId(R.id.design_navigation_view), 3);
        Utilities.waitForTheUtilitiesScreenToBeDisplayed();
    }

    public static void NavigateToChangeSourceDestination() throws Exception {
        Helpers.clickOnObjectWithContentDesc(R.string.navigation_drawer_open);
        Helpers.clickOnAView(R.id.nav_view, withId(R.id.design_navigation_view), 6);
        ChangeSourceDestination.waitForTheChangeSourceDestinationScreenToBeDisplayed();
    }

    public static void NavigateToEmergencyContacts() throws Exception {
        Helpers.clickOnObjectWithContentDesc(R.string.navigation_drawer_open);
        Helpers.clickOnAView(R.id.nav_view, withId(R.id.design_navigation_view), 7);
        EmergencyContacts.waitForTheEmergencyContactsScreenToBeDisplayed();
    }

    public static void NavigateToSignOut() throws Exception {
        Helpers.clickOnObjectWithContentDesc(R.string.navigation_drawer_open);
        Helpers.clickOnAView(R.id.nav_view, withId(R.id.design_navigation_view), 8);
        LoginPage.waitForTheLoginPageToBeDisplayed();
    }
}
