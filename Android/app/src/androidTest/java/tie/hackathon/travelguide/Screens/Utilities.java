package tie.hackathon.travelguide.Screens;

import tie.hackathon.travelguide.R;
import tie.hackathon.travelguide.Tests.Helpers;

/**
 * Created by valentin.boca on 3/1/2018.
 */

public class Utilities {
    public static boolean isChecklistDisplayed() throws Exception {
        return Helpers.isObjectWithIdDisplayed(R.id.checklist);
    }

    public static void waitForTheUtilitiesScreenToBeDisplayed() throws Exception {
        if(!isChecklistDisplayed()) {
            throw new Exception("The Utilities screen is not displayed");
        }
    }
}
