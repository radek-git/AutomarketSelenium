package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='siteNav']/a[contains(@class, 'loginModalOpenTrigger')]")
    protected WebElement loginButton;

    @FindBy(xpath = "//div[@id='zgodaCookiesModal']")
    protected List<WebElement> cookiesPopupList;

    @FindBy(xpath = "//div[@id='zgodaCookiesModal']/div/a[@id='zgodaCookiesButton']")
    protected WebElement cookiesAcceptButton;

    @FindBy(xpath = "//div[@class='modal-body']/div[@class='modal-info']/div")
    protected WebElement logoutPopupText;

    @FindBy(xpath = "//div[@class='modal-body']/div[@class='modal-buttons']/div")
    protected WebElement logoutPopupCloseButton;

    @FindBy(xpath = "//div[@class='modal-body']/div[@class='modal-info']/div[contains(@class, 'alert-success') and text()='Zostałeś wylogowany poprawnie']")
    protected List<WebElement> logoutPopupWithTextList;

    public static final String SEGMENT_TYPE = "//div[@class='boxLinks']/div[@class='boxLinks_container']/a[@onclick=\"dataLayer.push({ 'eventLabel': 'Segment', 'eventAction': '%s', 'event': 'Homepage' });\"]";





    public Authpopup clickLoginButton() {
        waitForPageToBeLoaded();
        acceptCookies();
        loginButton.click();
        return new Authpopup(driver);
    }


    public void acceptCookies() {
        if (!cookiesPopupList.isEmpty()) {
            cookiesAcceptButton.click();
        }
    }


    public boolean isLogoutPopupWithGivenTextDisplayed() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutPopupCloseButton));
        return !logoutPopupWithTextList.isEmpty();
    }

    public HomePage closeLogoutPopup() {
        logoutPopupCloseButton.click();
        return this;
    }


    public SearchPage selectSegmentType(String segment) {
        waitForPageToBeLoaded();
        driver.findElement(By.xpath(String.format(SEGMENT_TYPE, segment))).click();
        return new SearchPage(driver);
    }
}
