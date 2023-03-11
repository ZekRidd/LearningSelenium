package com.Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverGetMethods {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        // 1- driver.get("url") >>> yazdığımız URL'ye gider
        driver.get("https://www.amazon.com");

        System.out.println("Sayfa Title : " + driver.getTitle());

        // 3- driver.getCurrentURL() >>> içinde olduğumuz URL bize döndürür
        System.out.println(driver.getCurrentUrl()); // https://www.amazon.com/

        // 4- driver.getPageSource() >>> içinde bulunan sayfanın kaynak kodlarını String olarak döndürür
        System.out.println("=========================");
        System.out.println(driver.getPageSource());
        System.out.println("=========================");

        // 5- driver.getWindowHandle();>>> içinde bulunan sayfanın UNIQUE hash kodunu döndürür
        System.out.println(driver.getWindowHandle()); // 8E1BAA852EA59EF4864A63C3364D5EAC Her defasında değişir

        // 6- driver.getWindowHandles(); >>> driver çalışırken birden fazla sayfa açılmışsa tüm sayfaların hash kodlarını bize döndürür


    }
}
