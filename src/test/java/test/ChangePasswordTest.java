package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.*;

public class ChangePasswordTest  extends BaseTest{

    HomePage homePage;
    RequestPasswordResetPage requestPasswordResetPage;
    CheckpointRequestPage checkpointRequestPage;
    SingInGooglePage singInGooglePage;
    SingInGooglePagePassword singInGooglePagePassword;
    MailPage mailPage;
    PasswordResetPage passwordResetPage;



    @DataProvider
    public static Object[][] valueForTest() {
        return new Object[][]{
                {"ketborshe@gmail.com", "@@@2512Kate"}
        };
    }

    @Test (dataProvider = "valueForTest")
    public void changePasswordTest(String email, String password) {
        Assert.assertTrue(loginPage.isPageLoaded(), "Login page was not loaded.");

                RequestPasswordResetPage requestPasswordResetPage =
                        loginPage.changePassword();
        Assert.assertTrue(requestPasswordResetPage.isPageLoaded(), "Reset password page was not loaded.");

                CheckpointRequestPage checkpointRequestPage =
                        requestPasswordResetPage.fillForm(email);
        Assert.assertTrue(checkpointRequestPage.isPageLoaded(),
                "Checkpoint request page was not loaded.");

        SingInGooglePage singInGooglePage =
                checkpointRequestPage.openNewMailTab();
        Assert.assertTrue(singInGooglePage.isPageLoaded(), "Sing in Google page was not loaded.");

                SingInGooglePagePassword singInGooglePagePassword =
                        singInGooglePage.fillGoogleForm(email);
        Assert.assertTrue(singInGooglePagePassword.isPageLoaded(), "Sing in password Google page was not loaded.");

                MailPage mailPage =
                        singInGooglePagePassword.singInStepPassword(password);
        Assert.assertTrue(mailPage.isPageLoaded(), "Mail Google page was not loaded.");

        PasswordResetPage passwordResetPage = mailPage.openLetter().clickLetterLink();
        Assert.assertTrue(passwordResetPage.iaPageLoaded(), "Reset password page was not loaded.");

                PasswordResetSubmitPage passwordResetSubmitPage =
                        passwordResetPage.fillPasswordForm(password);
        Assert.assertTrue(passwordResetSubmitPage.iaPageLoaded(), "Reset password page was not loaded.");

                HomePage homePage =  passwordResetSubmitPage.openHomePage();
        Assert.assertTrue(homePage.isPageLoaded(), "Home page is not loaded.");



    }
}

