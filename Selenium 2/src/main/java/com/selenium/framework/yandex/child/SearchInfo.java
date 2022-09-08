package com.selenium.framework.yandex.child;

import com.selenium.framework.yandex.Yandex;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.Keys.ENTER;

public class SearchInfo extends Yandex {

    private WebDriver webdriver;

    public SearchInfo(WebDriver webdriver) {
        this.webdriver = webdriver;
    }

    public void searchInfo(String text) {
        webdriver.get(address);
        WebElement search = webdriver.findElement(By.id("text"));
        search.sendKeys(text);
        search.sendKeys(ENTER);
    }

    public WebDriver getWebdriver() {
        return webdriver;
    }
}
