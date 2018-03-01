package tie.hackathon.travelguide.Screens;

import tie.hackathon.travelguide.R;
import tie.hackathon.travelguide.Tests.Helpers;

/**
 * Created by valentin.boca on 3/1/2018.
 */

public class EmergencyContacts {
    public static boolean isPoliceDisplayed() throws Exception {
        return Helpers.isObjectWithIdDisplayed(R.id.police_tag);
    }

    public static void waitForTheEmergencyContactsScreenToBeDisplayed() throws Exception {
        if(!isPoliceDisplayed()) {
            throw new Exception("The ChangeSource/Destination screen is not displayed");
        }
    }
}
