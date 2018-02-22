package tie.hackathon.travelguide.Screens;

import tie.hackathon.travelguide.R;
import tie.hackathon.travelguide.Tests.Helpers;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static tie.hackathon.travelguide.Tests.Helpers.mediaItemPosition;

/**
 * Created by valentin.boca on 2/22/2018.
 */

public class MainPage {
    public static void openNavDrawer() throws Exception {
        Helpers.clickOnContentDesc(R.string.navigation_drawer_open);
    }

    public static void signOut() throws Exception {
        Helpers.clickOnContentDesc(R.string.navigation_drawer_open);
        Helpers.clickOnAView(R.id.nav_view, withId(R.id.design_navigation_view), 8);

    }

    public static void clickOn(int rid, int position) throws Exception {
        onView(mediaItemPosition(withId(rid), position)).perform(click());
    }
}