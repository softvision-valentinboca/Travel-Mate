package tie.hackathon.travelguide.Screens;

import tie.hackathon.travelguide.R;
import tie.hackathon.travelguide.Tests.Helpers;

/**
 * Created by valentin.boca on 3/1/2018.
 */

public class ChangeSourceDestination {
    public static boolean isSourceDestinationDisplayed() throws Exception {
        return Helpers.isObjectWithIdDisplayed(R.id.ll1);
    }

    public static void waitForTheChangeSourceDestinationScreenToBeDisplayed() throws Exception {
        if(!isSourceDestinationDisplayed()) {
            throw new Exception("The ChangeSource/Destination screen is not displayed");
        }
    }
}
