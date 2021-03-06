package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginSubmitPage;

public class LinkedinLoginTest extends BaseTest{


    @DataProvider
    public Object[][] validDataProvider() {
        return new Object[][]{
                {"linkedin.TST.yanina@gmail.com", "Test123!"}
                //  { "Ketborshe@gmail.com", "2512Kate" },
                // { "Ketborshe@gmail.com", "2512KATE" }

        };
    }

    @Test(dataProvider = "validDataProvider")
    public void successfulLoginTest(String userEmail, String userPassword) {
        Assert.assertTrue(loginPage.isPageLoaded(),
                "Login page was not loaded.");

        HomePage homePage = loginPage.login(userEmail, userPassword);

        Assert.assertTrue(homePage.isPageLoaded(),
                "Home page is not loaded.");
    }


    @DataProvider
    public Object[][] emptyValueDataProvider() {
        return new Object[][]{
                // { "", "" },
                //   { "", "2512Kate" },
                {"ketborshe@gmail.com", ""}
        };
    }

    @Test(dataProvider = "emptyValueDataProvider")
    public void negativeWithEmptyValuesTest(String userEmail, String
            userPassword) {
        Assert.assertTrue(loginPage.isPageLoaded(),
                "Login page was not loaded.");
        loginPage.login(userEmail, userPassword);
        Assert.assertTrue(loginPage.isTitleDisplayed(),
                "Start page title is wrong.");
    }


    @DataProvider
    public Object[][] inValueDataProvider() {
        return new Object[][]{
                //  { "ketborshe@gmail.com", "123456","","Это неверный пароль.Повторите попытку или измените пароль." },
                {"ketborshe@@gmail.com", "2512Kate", "Этот адрес эл.почты не зарегистрирован в LinkedIn. Повторите попытку.", ""}
        };
    }

    @Test(dataProvider = "inValueDataProvider")
    public void negativeWithValidUnregictredEmailTest(String userEmail,
                                                      String userPassword,
                                                      String emailValidation,
                                                      String passwordValidation) {
        Assert.assertTrue(loginPage.isPageLoaded(),
                "Login page was not loaded.");
        LoginSubmitPage loginSubmitPage = loginPage.login(userEmail, userPassword);
        Assert.assertTrue(loginSubmitPage.isPageLoaded(), "Login pade is not loaded");
        Assert.assertEquals(loginSubmitPage.getUserEmailValidationMessage(),
                emailValidation, "userEmail  validation is incorrect");
        Assert.assertEquals(loginSubmitPage.getUserPasswordValidationmessage(),
                passwordValidation, "userPassword validation message is incorrect");
    }
}



