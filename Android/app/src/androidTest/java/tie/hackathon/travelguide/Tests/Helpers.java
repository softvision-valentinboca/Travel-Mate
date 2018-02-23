package tie.hackathon.travelguide.Tests;

import android.os.SystemClock;
import android.support.test.espresso.AppNotIdleException;
import android.support.test.espresso.NoMatchingRootException;
import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.PerformException;
import android.support.test.espresso.Root;
import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.util.HumanReadables;
import android.support.test.espresso.util.TreeIterables;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiSelector;
import android.view.View;
import android.view.ViewGroup;

import junit.framework.Assert;
import junit.framework.AssertionFailedError;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import tie.hackathon.travelguide.Constants.Time;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.swipeUp;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isRoot;
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

        device.pressBack();
    }

    public static UiObject getUiObjectByResourceId(String nameSpace, String resourceId) throws Exception {
        return device.findObject(new UiSelector().resourceId(nameSpace + ":id/" + resourceId));
    }

    public static boolean isObjectWithTextDisplyed(String text) throws Exception {
        return Helpers.checkIfUIObjectIsVisible(allOf(withText(text), isCompletelyDisplayed()), 3);
    }

    public static boolean isObjectWithTextAndIdDisplyed(String text, int rid) throws Exception {
        return Helpers.checkIfUIObjectIsVisible(allOf(withText(text), withId(rid), isCompletelyDisplayed()), 3);
    }

    public static boolean isObjectWithIdDisplayed(int rid) throws Exception {
        return Helpers.checkIfUIObjectIsVisible(allOf(withId(rid), isCompletelyDisplayed()), 3);
    }

    public static Matcher<View> ObjectPosition(final Matcher<View> parentMatcher, final int childPosition) {
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

    public static void clickAnObjectFromTheList(int rid, int position) throws Exception {
        onView(ObjectPosition(withId(rid), position)).perform(click());
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

    public static void clickOnObjectWithContentDesc(int text) throws Exception {
        onView(withContentDescription(text)).perform(click());
    }

    public static void clickOnItemWithIdAtPosition(int rid, int position) throws Exception {
        onView(ObjectPosition(withId(rid), position)).perform(click());
    }

    public static void typeTextOnFieldWithId(int rid, String text) throws Exception {
        onView(withId(rid)).perform(typeText(text));
    }

    public static void tapButtonWithId(int rid) throws Exception {
        onView(withId(rid)).perform(click());
    }

    public static ViewAction waitId(final int viewId, final long millis) {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return isRoot();
            }

            @Override
            public String getDescription() {
                return "wait for a specific view with id <" + viewId + "> during " + millis + " millis.";
            }

            @Override
            public void perform(final UiController uiController, final View view) {
                uiController.loopMainThreadUntilIdle();
                final long startTime = System.currentTimeMillis();
                final long endTime = startTime + millis;
                final Matcher<View> viewMatcher = withId(viewId);

                do {
                    for(View child : TreeIterables.breadthFirstViewTraversal(view)) {
                        // found view with required ID
                        if(viewMatcher.matches(child)) {
                            return;
                        }
                    }
                    uiController.loopMainThreadForAtLeast(50);
                }
                while(System.currentTimeMillis() < endTime);

                // timeout happens
                throw new PerformException.Builder()
                        .withActionDescription(this.getDescription())
                        .withViewDescription(HumanReadables.describe(view))
                        .withCause(new TimeoutException())
                        .build();
            }
        };
    }

    public static void waitFor(int rid, int time) throws Exception {
        onView(isRoot()).perform(waitId(rid, TimeUnit.SECONDS.toMillis(time)));
    }

    public static void clickASpecificObject(String text, int rid) throws Exception {
        onView(allOf(withText(text), withId(rid))).perform(click());
    }
}