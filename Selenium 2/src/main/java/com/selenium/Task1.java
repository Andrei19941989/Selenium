package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://google.ru");

        WebElement element1 = driver.findElement(By.name("q"));
        element1.sendKeys("selenium");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        WebElement element2 = driver.findElement(By.name("btnK"));
        element2.click();
    }
}
