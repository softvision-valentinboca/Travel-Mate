package tie.hackathon.travelguide.Screens;

import tie.hackathon.travelguide.R;
import tie.hackathon.travelguide.Tests.Helpers;

/**
 * Created by valentin.boca on 3/1/2018.
 */

public class Destinations {
    public static boolean isSearchACityDisplayed() throws Exception {
        return Helpers.isObjectWithIdDisplayed(R.id.cityname);
    }

    public static void waitForTheDestinationScreenToBeDisplayed() throws Exception {
        if(!isSearchACityDisplayed()) {
            throw new Exception("The Destinations screen is not displayed");
        }
    }
}
