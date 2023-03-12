package com.Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class bestBuyTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        // 1- https://www.bestbuy.com adresine gidin
        driver.get("https://www.bestbuy.com");

        // 2- cookies varsa kabul edin
        // 3- sayfada kaç adet buton bulunduğunu yazdırın

        List<WebElement> buttonList = driver.findElements(By.tagName("button"));
        System.out.println(buttonList.size());
        // 4- sayfadaki her bir buton üzerindeki sayıları yazdırın

        for (WebElement each:buttonList
             ) {
            System.out.println(each.getText());
        }
    }
}
