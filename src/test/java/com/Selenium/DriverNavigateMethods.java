package com.Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverNavigateMethods {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        // 1- driver.navigate().to("url) >> istenen url'e gider ancak
        // driver.get("url") ile aynı işlemi yapar forward ve back yapılmasına imkan tanır.

        driver.get("https://www.amazon.com");
        driver.navigate().to("https://www.facebook.com");

        // 2- navigate().back("url); >>>> bir önceki sayfaya geri döner
        driver.navigate().back(); // Bu örnekte amazon'a geri döner

        // 3- navigate().forward("url);>>> Bir sonraki sayfaya girer
        driver.navigate().forward(); // Bu örnekte tekrar facebook sayfasına gider

        // 4- navigate().refresh(); >>> içinde bulunduğu sayfayı yeniler
        driver.navigate().refresh();

        // driver oluşturulduğunda açılan sayfayı kapatmak için driver.close();
        driver.close();

        // driver.quit(); birden fazla sayfa ile çalışıyorsa bu metotu kullanırız
        // driver.quit ve driver.close metotları aynı anda çalışamaz
        // driver.quit();
    }
}
