package org.example;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public abstract class BasePage {

    @FindBy(xpath = "//div[@class='contentmodal']/div[@id='snrs-close']")
    protected WebElement chatCloseButton;

    @FindBy(xpath = "//div[@class='contentmodal']")
    protected List<WebElement> chatList;

    public WebDriver driver;
    public WebDriverWait wait;
    public Actions actions;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public void waitForPageToBeLoaded() {
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }


    public void closeChatIfOpened() {
        if (!chatList.isEmpty()) {
            chatCloseButton.click();
        }
    }

    public void moveToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
