package tie.hackathon.travelguide.Screens;

import tie.hackathon.travelguide.R;
import tie.hackathon.travelguide.Tests.Helpers;

/**
 * Created by valentin.boca on 3/1/2018.
 */

public class Travel {
    public static boolean isMyTripsCategoryDisplayed() throws Exception {
        return Helpers.isObjectWithContentDescAndTextDisplyed("FunnyFacts", "MY TRIPS");
    }

    public static void waitForTheTravelScreenToBeDisplayed() throws Exception {
        if(!isMyTripsCategoryDisplayed()) {
            throw new Exception("The Travel screen is not displayed");
        }
    }

    public static boolean isMyTripsScreenDisplayed() throws Exception {
        return Helpers.isObjectWithTextAndIdDisplyed("Add New Trip", R.id.tv);
    }

    public static void waitForMyTripsScreenToBeDisplayed() throws Exception {
        if(!isMyTripsScreenDisplayed()) {
            throw new Exception("The Add New Trip screen is not displayed");
        }
    }

    public static boolean isAddNewTripDisplayed() throws Exception {
        return Helpers.isObjectWithTextAndIdDisplyed("ADD TRIP", R.id.ok);
    }

    public static void waitForTheAddNewTripScreenToBeDisplayed() throws Exception {
        if(!isAddNewTripDisplayed()) {
            throw new Exception("The Add New Trip screen is not displayed");
        }
    }

    public static void clickMyTrips() throws Exception {
        Helpers.clickOnObjectWithIdAtPosition(R.id.vali, 0);
        Travel.waitForTheTravelScreenToBeDisplayed();
    }

    public static void clickAddNewTrip() throws Exception {
        Helpers.clickASpecificObjectWithTextAndId("Add New Trip", R.id.tv);
        //Travel.waitForTheAddNewTripScreenToBeDisplayed();
    }

    public static void insertTripName(String text) throws Exception {
        Helpers.typeTextOnFieldWithId(R.id.tname, text);
    }

    public static void insertCityName(String text) throws Exception {
        Helpers.typeTextOnFieldWithId(R.id.cityname, text);
    }

    public static void enterStartDate(int yearStart, int monthStart, int dayStart) throws Exception {
        //Helpers.setDate(R.id.sdate, yearStart, monthStart, dayStart);
    }

    public static void enterEndDate(int yearEnd, int monthEnd, int dayEnd) throws Exception {
        Helpers.clickASpecificObjectWithId(R.id.sdate);
        Helpers.setDate(yearEnd, monthEnd, dayEnd);
    }

    public static void newTripFlow(String trip, String city, int yearStart, int monthStart, int dayStart, int yearEnd, int monthEnd, int dayEnd) throws Exception {
        Travel.insertTripName(trip);
        Travel.insertCityName(city);
        Travel.enterStartDate(yearStart, monthStart, dayStart);
        Travel.enterEndDate(yearEnd, monthEnd, dayEnd);
        Helpers.clickASpecificObjectWithTextAndId("ADD TRIP", R.id.ok);
    }
}
