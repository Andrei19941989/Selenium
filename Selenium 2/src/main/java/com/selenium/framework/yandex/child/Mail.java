package com.selenium.framework.yandex.child;

import com.selenium.framework.yandex.Yandex;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Mail extends Yandex {

    private WebDriver webdriver;

    public Mail(WebDriver webdriver) {
        this.webdriver = webdriver;
    }

    public void goToPage() {
        webdriver.get(address);
        webdriver.findElement(By.linkText("Войти")).click();
    }

    public WebDriver getWebdriver() {
        return webdriver;
    }
}
