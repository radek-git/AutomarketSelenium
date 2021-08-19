package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage{


    public SearchPage(WebDriver driver) {
        super(driver);

    }


    @FindBy(xpath = "//div[@class='filters']/div[@class='filters_filterWrapper']/div[@id='filter-marka-model']")
    protected WebElement brandAndModelDropdown;


}
