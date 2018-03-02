package tie.hackathon.travelguide.Screens;

import tie.hackathon.travelguide.Constants.Strings;
import tie.hackathon.travelguide.R;
import tie.hackathon.travelguide.Tests.Helpers;

/**
 * Created by valentin.boca on 2/26/2018.
 */

public class MoreCityDetails {
    public static boolean isGoogleMapPageDisplayed() throws Exception {
        return Helpers.getUiObjectByResourceId("com.google.android.apps.maps", "home_bottom_sheet").exists();
    }

    public static void waitForGoogleMapsPageToBeDisplayed() throws Exception {
        if(!isGoogleMapPageDisplayed()) {
            throw new Exception("The Google Maps is not displayed");
        }
    }

    public static void tapViewOnMapString() throws Exception {
        Helpers.clickOnTheFirstObjectInTheListWhenAmbiguous(Strings.VIEW_ON_MAP, R.id.interest_2);
    }
}
