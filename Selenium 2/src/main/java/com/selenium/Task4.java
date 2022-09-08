package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class Task4 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            try {
                System.setProperty("webdriver.chrome.driver", "chromedriver");
                WebDriver driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
                driver.navigate().to("https://www.aviasales.ru/");

                WebElement elementFrom = driver.findElement(By.xpath("//input[@id='origin']"));
                elementFrom.sendKeys("Москва");

                WebElement elementTo = driver.findElement(By.xpath("//input[@id='destination']"));
                elementTo.sendKeys("Сочи");

                WebElement elementDate = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/" +
                        "div[2]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/div[1]"));
                elementDate.click();

                // ищем дату через два месяца
                // перемещаемся на два месяца вперед
                WebElement toNextMonth = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]"
                        + "/div[1]/div[1]/form[1]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/"
                        + "div[1]/button[1]/span[1]/*[1]"));
                toNextMonth.click();
                toNextMonth.click();
                // находим список дней искомого месяца
                WebElement month = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]"
                        + "/div[1]/form[1]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]"));
                List<WebElement> listDays = month.findElements(By.className("calendar__day-cell"));
                String dayAndYear = LocalDate.now().getDayOfMonth() < 10
                        ? "0" + LocalDate.now().getDayOfMonth()
                        : LocalDate.now().getDayOfMonth()
                        + " " + LocalDate.now().getYear();
                for (WebElement day : listDays) {
                    if (day.getAttribute("aria-label") != null
                            && day.getAttribute("aria-label").contains(dayAndYear)) {
                        day.click();
                        break;
                    }
                }
                // заполняем количество взрослых - 2, детей - 1
                driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/" +
                        "form[1]/div[4]")).click();

                WebElement incrementPassenger = driver.findElement(By.className("additional-fields__passengers-wrap"));
                List<WebElement> incrementPassengerList = incrementPassenger.findElements(By.className("additional-fields__passenger-row"));
                try {
                    WebElement adultIncrement = incrementPassengerList.get(0);
                    adultIncrement.findElement(By.className("--increment")).click();
                    WebElement childIncrement = incrementPassengerList.get(1);
                    childIncrement.findElement(By.className("--increment")).click();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                // нажимаем кнопку Найти билеты
                driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]" +
                        "/div[5]/button[1]")).click();

                ArrayList<String> newTab = new ArrayList<>(driver.getWindowHandles());
                if (newTab.size() > 1) {
                    driver.switchTo().window(newTab.get(newTab.size() - 1));
                }

                List<WebElement> flights = driver.findElements(By.className("product-list__item"));

                // заходим на рейс
                System.out.println("flights: " + flights.size());
                for (WebElement flight : flights) {
                    if (!flight.getAttribute("class").contains("advert")) {
                        flight.click();
                        break;
                    }
                }
                // нажимаем Подробнее
                WebElement moreInfo = driver.findElement(By.xpath("//div[contains(text(),\"Подробнее\")]"));
                try {
                    for (int j = 0; j < 10; j++) {
                        System.out.println("click more info " + j);
                        moreInfo.click();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                // находим заголовок и печатаем его
                WebElement title = driver.findElement(By.xpath("//body/div[@id='avs-modal-container']" +
                        "/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]"));
                List<WebElement> rowOfTitle = title.findElements(By.tagName("div"));
                rowOfTitle.forEach(row -> {
                    System.out.println(row.getText());
                });
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Exception " + i);
            }
        }
    }
}
