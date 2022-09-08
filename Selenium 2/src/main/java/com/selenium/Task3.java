package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task3 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.navigate().to("https://www.spicejet.com/");

        WebElement fromElement = driver
                .findElement(By.xpath("//*[@id=\"main-container\"]" +
                        "/div/div[1]/div[3]/div[2]/div[3]/div/div[1]/div/div[2]/input"));
        fromElement.sendKeys("Agr");

        WebElement toElement = driver
                .findElement(By.xpath("//*[@id=\"main-container\"]" +
                        "/div/div[1]/div[3]/div[2]/div[3]/div/div[3]/div/div[2]/input"));
        toElement.sendKeys("Delh");

        WebElement wellcomeAboard = driver
                .findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]"));
        wellcomeAboard.click();

        WebElement button = driver
                .findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[7]/div[2]/div"));
        button.click();

    }
}
