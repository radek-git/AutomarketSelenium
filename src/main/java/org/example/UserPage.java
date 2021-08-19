package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserPage extends BasePage{

    public UserPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//h1[@class='userSection_header']")
    protected WebElement welcomeLabel;

    @FindBy(xpath = "//div[@class='userSection_aside']/ul/li/a/span[text()=' Wyloguj']")
    protected WebElement logoutButton;


    public String getUsernameFromWelcomeLabel() {
        waitForPageToBeLoaded();
        return welcomeLabel.getText().replace("Witaj, ", "").replace("!", "");
    }

    public HomePage clickLogoutButton() {
        waitForPageToBeLoaded();
        logoutButton.click();
        return new HomePage(driver);
    }
}
