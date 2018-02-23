package tie.hackathon.travelguide.Screens;

import tie.hackathon.travelguide.Tests.Helpers;

/**
 * Created by valentin.boca on 2/23/2018.
 */

public class City {
    public static boolean isCityPageDisplayed(String text, int rid) throws Exception{
        return Helpers.isObjectWithTextAndIdDisplyed(text, rid);
    }

    public static void waitForCityInfoToBeDisplayed(String text, int rid) throws Exception{
        if (!isCityPageDisplayed(text, rid)) {
            throw new Exception("The city page is not displayed");
        }
    }
}