package com.selenium.framework;

import com.selenium.framework.yandex.child.Mail;
import com.selenium.framework.yandex.child.News;
import com.selenium.framework.yandex.child.SearchInfo;
import com.selenium.framework.yandex.child.YandexMarket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FrameworkTest {

    Configurer configurer;

    @BeforeEach
    public void beforeTest() {
        configurer = new Configurer()
                .configureChromeDriver()
                .implicitlyWaitInSeconds(10)
                .windowsMaximize();
    }

    @Test
    public void testMail() {
        Mail mail = new Mail(configurer.getWebdriver());
        mail.goToPage();
    }

    @Test
    public void testNews() {
        News news = new News(configurer.getWebdriver());
        news.goToPage();
    }

    @Test
    public void testSearchInfo() {
        YandexMarket market = new YandexMarket(configurer.getWebdriver());
        market.goToPage();
    }

    @Test
    public void testYandexMarket() {
        SearchInfo searchInfo = new SearchInfo(configurer.getWebdriver());
        searchInfo.searchInfo("дельфины");
    }

}