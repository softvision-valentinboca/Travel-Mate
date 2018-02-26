package tie.hackathon.travelguide.Screens;

import android.support.test.espresso.Espresso;

import tie.hackathon.travelguide.R;
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

    public static void clickFunFacts() throws Exception{
        Helpers.clickASpecificObjectWithId(R.id.funfact);
    }

    public static boolean isFunFactsPageDisplayed(String text, int rid) throws Exception{
        return Helpers.isObjectWithTextAndIdDisplyed(text, rid);
    }

    public static void waitForFunFactsPageToBeDisplayed(String text, int rid) throws Exception{
        if (!isFunFactsPageDisplayed(text, rid)) {
            throw new Exception("The fun facts page is not displayed");
        }
    }

    public static void navigateToMainMenu() throws Exception{
        Espresso.pressBack();
        Espresso.pressBack();
        MainPage.waitForTheMainScreenToBeDisplayed();
    }
}