package tie.hackathon.travelguide.Screens;

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
    }

    public static boolean isMainScreenDisplayed() throws Exception{
        MainPage.waitFor();
        return Helpers.isObjectWithIdDisplayed(R.id.cityname);
    }

    public static void waitFor() throws Exception{
        Helpers.waitFor(R.id.cityname, 5);
    }
}