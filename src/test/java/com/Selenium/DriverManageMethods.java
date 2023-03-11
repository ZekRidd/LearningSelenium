package com.Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverManageMethods {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1- driver.manage().window().getSize(); methods
        // driver.manage().window().getSize(); >>> içinde bulunan sayfanın pixel değerlerini döndürür
        System.out.println(driver.manage().window().getSize()); // (1440, 805)

        // 2- driver.manage().window().getPosition(); methods
        // içinde olduğu sayfanın pixel olarak konumunu döndürür
        System.out.println(driver.manage().window().getPosition());

        // 3- driver.manage().window().setPosition();
        // içinde bulunduğu sayfanın sol alt köşesinin bizim gireceğimiz pixel noktasına taşır
        driver.manage().window().setPosition(new Point(15,15));

        // 4- driver.manage().windows().setSize(new Dimension());
        // içinde olduğu sayfanın sol alt köşesi sabit olacak şekilde boyutu ayarlamamızı sağlar
        driver.manage().window().setSize(new Dimension(600,600));

        // konumu ve boyutu yeniledikten sonra ekrana yazdırırsak
        System.out.println("Yeni pencere ölçüleri : " + driver.manage().window().getSize());
        System.out.println("Yeni pencere konumu  :" + driver.manage().window().getPosition());

        // driver.manage().window().maximize(); içinde bulunduğu sayfayı maximize yapar
        // driver.manage().window().fullscreen(); içinde bulunduğu sayfayı fullscreen yapar

        // farklarını görmek için bu methodları kullanıp, başlangıç ve boyutlarını ekrana yazdıralım
        driver.manage().window().maximize();
        System.out.println("maximize konum  :" + driver.manage().window().getPosition()); // (0, 25)
        System.out.println("maximize boyut : " + driver.manage().window().getSize()); // (1440, 804)


        driver.manage().window().fullscreen();
        System.out.println("Fullscreen konum  :" + driver.manage().window().getPosition()); // (0, 0)
        System.out.println("Fullscreen boyut : " + driver.manage().window().getSize()); // (1440, 900)

        // driver.manage.window().minimize(); >>> sayfayı simge durumuna küçültür

        driver.manage().window().minimize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); // Sayfadaki elementleri bulmaya çalışırken
        // En fazla 15 saniye bekler, bulursa devam eder, bulamazsa exception hatası verir


    }
}
