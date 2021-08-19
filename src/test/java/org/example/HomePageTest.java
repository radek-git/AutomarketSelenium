package org.example;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePageTest extends BaseTest{

    private HomePage homePage;
    public static final String USER_EMAIL = "user3@email.com";
    public static final String USERNAME = "username";
    public static final String SURNAME = "surname";
    public static final String PASSWORD = "password";
    public static final String PHONE_NR = "968218741";


    @BeforeMethod
    public void before() {
        driver.get("https://automarket.pl/");
        homePage = new HomePage(driver);
    }

    @Test
    public void shouldCreateNewUserTest() {
        String usernameFromWelcomeLabel = homePage.clickLoginButton()
                .registerUser(USER_EMAIL)
                .completeForm(USERNAME, SURNAME, PASSWORD, PHONE_NR)
                .clickCreateAccountButton()
                .getUsernameFromWelcomeLabel();

        assertTrue(usernameFromWelcomeLabel.equalsIgnoreCase(USERNAME) );
    }


    @Test
    public void shouldRegisterUserAndLogout() {
        boolean logoutPopupWithGivenTextDisplayed = homePage.clickLoginButton()
                .registerUser(USER_EMAIL)
                .completeForm(USERNAME, SURNAME, PASSWORD, PHONE_NR)
                .clickCreateAccountButton()
                .clickLogoutButton()
                .isLogoutPopupWithGivenTextDisplayed();

        assertTrue(logoutPopupWithGivenTextDisplayed);

//        homePage.closeLogoutPopup();
    }
}
