package tie.hackathon.travelguide.Tests;

import android.os.SystemClock;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.AppNotIdleException;
import android.support.test.espresso.NoMatchingRootException;
import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.Root;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiSelector;
import android.view.View;
import android.view.ViewGroup;

import junit.framework.Assert;
import junit.framework.AssertionFailedError;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import tie.hackathon.travelguide.Constants.Time;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.swipeUp;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

/**
 * Created by valentin.boca on 2/22/2018.
 */

public class Helpers extends EspressoTestBase {
    public static Matcher<Root> isToast() {
        return new ToastMatcher();
    }

    public static void isToastMessageWithTextDisplayed(String toastString) {
        onView(withText(toastString)).inRoot(isToast()).check(matches(isDisplayed()));
    }

    public static boolean checkIfUIObjectIsVisible(Matcher<View> matcher, int waitTimeInSeconds) {
        boolean isVisible = false;
        long endTime;

        endTime = System.currentTimeMillis() + waitTimeInSeconds * Time.ONE_SECOND;

        while(!isVisible && System.currentTimeMillis() <= endTime) {
            try {
                onView(matcher).check(matches(isDisplayed()));
                isVisible = true;
            } catch(NoMatchingViewException | AppNotIdleException | AssertionFailedError | NoMatchingRootException e) {
                // do nothing
            }
        }

        return isVisible;
    }

    public static void pressBack() throws Exception {
        UiDevice mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

        mDevice.pressBack();
    }

    public static UiObject getUiObjectByResourceId(String nameSpace, String resourceId) throws Exception {
        return device.findObject(new UiSelector().resourceId(nameSpace + ":id/" + resourceId));
    }

    public static boolean isStringDisplayed(String text) throws Exception {
        return Helpers.checkIfUIObjectIsVisible(allOf(withText(text), isCompletelyDisplayed()), 3);
    }

    public static boolean isIdDisplayed(int text) throws Exception {
        return Helpers.checkIfUIObjectIsVisible(allOf(withId(text), isCompletelyDisplayed()), 3);
    }

    public static Matcher<View> mediaItemPosition(final Matcher<View> parentMatcher, final int childPosition) {
        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("with " + childPosition + " child view of type parentMatcher");
            }

            @Override
            public boolean matchesSafely(View view) {
                if(!(view.getParent() instanceof ViewGroup)) {
                    return parentMatcher.matches(view.getParent());
                }

                ViewGroup group = (ViewGroup) view.getParent();
                return parentMatcher.matches(view.getParent()) && group.getChildAt(childPosition).equals(view);
            }
        };
    }

    public static void clickAMediaItemFromTheList(int rid, int position) throws Exception {
        onView(mediaItemPosition(withId(rid), position)).perform(click());
    }

    public static boolean clickOnAView(int rid2, Matcher<View> matcher, int position) {
        boolean found = false;
        int i = 0;
        int MAX_SWIPES = 2;
        while(!found && i < MAX_SWIPES) {
            onView(withId(rid2)).perform(swipeUp());
            SystemClock.sleep(500);
            try {
                onView(matcher).check(matches(isDisplayed())).perform(actionOnItemAtPosition(position, click()));
                found = true;
            } catch(Exception e) {
                // The search continues
            }
            i++;
        }

        if(!found) {
            Assert.fail("The element has not been found.");
        }
        return found;
    }

    public static void clickOnContentDesc(int text) throws Exception {
        onView(withContentDescription(text)).perform(click());
    }

}
