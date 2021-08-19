package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Authpopup extends BasePage{
    public Authpopup(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "loginId")
    protected WebElement authPopup;

    @FindBy(xpath = "//div[@id='loginId']/div[@class='login_mainContainer']/div[@class='login_formContainer']/form[@id='loginSection']/*/input[@name='email']")
    protected WebElement emailInput;

    @FindBy(xpath = "//div[@id='loginId']/div[@class='login_mainContainer']/div[@class='login_formContainer']/form[@id='loginSection']/*/input[@name='password']")
    protected WebElement passwordInput;

    @FindBy(xpath = "//div[@id='loginId']/div[@class='login_mainContainer']/div[@class='login_formContainer']/form[@id='loginSection']/button[@class='login_button']")
    protected WebElement loginButton;

    @FindBy(xpath = "//div[@class='login_tabsWrapper']/a[contains(@class, 'login_tab--active')]")
    protected WebElement loginHeaderButton;

    @FindBy(xpath = "//div[@class='login_tabsWrapper']/a[contains(@class, 'login_tab') and text()='Załóż konto']")
    protected WebElement registerHeaderButton;

    @FindBy(xpath = "//form[@id='registerSection']/div/input[contains(@class, 'formControl--loginSection')]")
    protected WebElement emailInputInRegisterSection;

    @FindBy(xpath = "//form[@id='registerSection']/button[contains(@class, 'login_button--register')]")
    protected WebElement addButtonInRegisterSection;



    public void waitForPopup() {
        wait.until(ExpectedConditions.visibilityOfAllElements(authPopup));
    }

    public RegisterUserPage registerUser(String email) {
        waitForPageToBeLoaded();
        waitForPopup();
        wait.until(ExpectedConditions.elementToBeClickable(registerHeaderButton)).click();
        emailInputInRegisterSection.click();
        emailInputInRegisterSection.sendKeys(email);
        addButtonInRegisterSection.click();

        return new RegisterUserPage(driver);
    }
}
