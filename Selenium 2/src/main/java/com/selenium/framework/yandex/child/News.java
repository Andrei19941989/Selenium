package com.selenium.framework.yandex.child;

import com.selenium.framework.yandex.Yandex;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class News extends Yandex {

    private WebDriver webdriver;

    public News(WebDriver webdriver) {
        this.webdriver = webdriver;
    }

    public void goToPage() {
        webdriver.get(address);
        webdriver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div[1]/nav/div/ul/li[5]/a/div[1]"))
                .click();

        // закрываем предыдущую страницу и фокусируемся на открывшейся странице
        ArrayList<String> newTab = new ArrayList<>(webdriver.getWindowHandles());
        if (newTab.size() > 1) {
            webdriver.close();
            webdriver.switchTo().window(newTab.get(newTab.size() - 1));
        }
    }

    public WebDriver getWebdriver() {
        return webdriver;
    }
}
