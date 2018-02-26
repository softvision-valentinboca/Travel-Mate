package tie.hackathon.travelguide.Screens;

import tie.hackathon.travelguide.R;
import tie.hackathon.travelguide.Tests.Helpers;

/**
 * Created by valentin.boca on 2/22/2018.
 */

public class LoginPage {
    public static boolean isSignUpButtonDispalyed() throws Exception{
        return Helpers.isObjectWithIdDisplayed(R.id.ok_signup);
    }

    public static void waitForTheLoginPageToBeDisplayed() throws Exception{
        if (!isSignUpButtonDispalyed()) {
            throw new Exception("The login page is not displayed");
        }
    }

    public static void tapSignUpButton() throws Exception {
        Helpers.clickASpecificObjectWithId(R.id.ok_signup);
    }

    public static void tapLogInString() throws Exception {
        Helpers.clickASpecificObjectWithId(R.id.login);
    }

    public static void tapLogInButton() throws Exception {
        Helpers.clickASpecificObjectWithId(R.id.ok_login);
    }

    public static void insertNameSignUp(String text) throws Exception {
        Helpers.typeTextOnFieldWithId(R.id.input_name_signup, text);
    }

    public static void insertPhoneNumberSignUp(String text) throws Exception {
        Helpers.typeTextOnFieldWithId(R.id.input_num_signup, text);
    }

    public static void insertPhoneNumberLogIn(String text) throws Exception {
        Helpers.typeTextOnFieldWithId(R.id.input_num_login, text);
    }

    public static void insertPasswordSignUp(String text) throws Exception {
        Helpers.typeTextOnFieldWithId(R.id.input_pass_signup, text);
    }

    public static void insertPasswordLogIn(String text) throws Exception {
        Helpers.typeTextOnFieldWithId(R.id.input_pass_login, text);
    }

    public static void signUp(String name, String number, String password) throws Exception{
        LoginPage.insertNameSignUp(name);
        LoginPage.insertPhoneNumberSignUp(number);
        LoginPage.insertPasswordSignUp(password);
    }

    public static void logInWithNumberAndPassword(String number, String password) throws Exception{
        LoginPage.insertPhoneNumberLogIn(number);
        LoginPage.insertPasswordLogIn(password);
    }
}