package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;

import java.util.Collections;

public class BaseTest {

    protected WebDriver driver;


    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("disable-popup-blocking"));
        options.addArguments("start-maximized");
        options.addArguments("--disable-notifications");
        options.addArguments("disable-extensions");
        driver = new ChromeDriver(options);
    }


}
