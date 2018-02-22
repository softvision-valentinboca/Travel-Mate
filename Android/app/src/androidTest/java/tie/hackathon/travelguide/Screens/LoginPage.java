package tie.hackathon.travelguide.Screens;

import tie.hackathon.travelguide.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by valentin.boca on 2/22/2018.
 */

public class LoginPage {
    public static void tapSignUp() throws Exception {
        onView(withId(R.id.ok_signup)).perform(click());
    }

    public static void tapLogIn() throws Exception {
        onView(withId(R.id.login)).perform(click());
    }

    public static void tapLogInButton() throws Exception {
        onView(withId(R.id.ok_login)).perform(click());
    }

    public static void insertNameSignUp(String text) throws Exception {
        onView(withId(R.id.input_name_signup)).perform(click());
        onView(withId(R.id.input_name_signup)).perform(typeText(text));
    }

    public static void insertPhoneNumberSignUp(String text) throws Exception {
        onView(withId(R.id.input_num_signup)).perform(click());
        onView(withId(R.id.input_num_signup)).perform(typeText(text));

    }

    public static void insertPhoneNumberLogIn(String text) throws Exception {
        onView(withId(R.id.input_num_login)).perform(click());
        onView(withId(R.id.input_num_login)).perform(typeText(text));

    }

    public static void insertPasswordSignUp(String text) throws Exception {
        onView(withId(R.id.input_pass_signup)).perform(click());
        onView(withId(R.id.input_pass_signup)).perform(typeText(text));

    }

    public static void insertPasswordLogIn(String text) throws Exception {
        onView(withId(R.id.input_pass_login)).perform(click());
        onView(withId(R.id.input_pass_login)).perform(typeText(text));

    }

    public static void signUp(String name, String number, String password) throws Exception{
        LoginPage.insertNameSignUp(name);
        LoginPage.insertPhoneNumberSignUp(number);
        LoginPage.insertPasswordSignUp(password);
    }

    public static void logIn(String number, String password) throws Exception{
        LoginPage.insertPhoneNumberLogIn(number);
        LoginPage.insertPasswordLogIn(password);
    }
}