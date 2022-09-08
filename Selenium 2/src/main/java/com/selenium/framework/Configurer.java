package com.selenium.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Configurer {

    private WebDriver webdriver;

    public Configurer configureChromeDriver() {
        System.setProperty("webdriver.chrome.driver","chromedriver");
        webdriver = new ChromeDriver();
        return this;
    }

    public Configurer windowsMaximize() {
        webdriver.manage().window().maximize();
        return this;
    }

    public Configurer implicitlyWaitInSeconds(int seconds) {
        webdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
        return this;
    }

    public WebDriver getWebdriver() {
        return webdriver;
    }
}
