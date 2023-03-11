package com.Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FirstTest {
    public static void main(String[] args) {
        System.setProperty("web-driver.chrome.driver","/Users/ramazan/Documents/Selenium/Drivers/chromedriver_mac64");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.google.com");
    }
}
