package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterUserPage extends BasePage {

    public RegisterUserPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "DANE_KLIENTA.IMIE")
    protected WebElement nameInput;

    @FindBy(id = "DANE_KLIENTA.NAZWISKO")
    protected WebElement surnameInput;

    @FindBy(id = "DANE_KLIENTA.HASLO")
    protected WebElement passwordInput;

    @FindBy(id = "DANE_KLIENTA.TEL_KOM")
    protected WebElement phoneNrInput;

    @FindBy(xpath = "(//label[contains(@class, 'formChecbox--intend')]/span[@class='checkmark'])[1]")
    protected WebElement checkbox;

    @FindBy(xpath = "//button[contains(@class, 'login_button--registerPage')]")
    protected WebElement createAccountButton;


    public RegisterUserPage completeForm(String name, String surname, String password, String phoneNr) {
        waitForPageToBeLoaded();
        nameInput.sendKeys(name);
        surnameInput.sendKeys(surname);
        passwordInput.sendKeys(password);
        phoneNrInput.sendKeys(phoneNr);
        checkbox.click();
        return this;
    }

    public UserPage clickCreateAccountButton() {
        createAccountButton.click();
        return new UserPage(driver);
    }



}
