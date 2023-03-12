package com.Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class FacebookTest {
    public static void main(String[] args) {
        /*
        https://www.facebook.com adresine gidin
        cookies çıkarsa kabul et butonuna basın
        e-posta kutusuna rastgele bir mail adresi girin
        şifre kısmına rastgele bir şifre girin
        giriş yap butonuna basın
        uyarı olarak hata mesajının "The email or phone number you entered isn't connected to an account.Find your account and log in"
         çıktığını test edin
        sayfayı kapatın

         */
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");
        // cookies çıkarsa kabul et butonuna basın
        driver.findElement(By.xpath("//button[@title='Temel ve isteğe bağlı çerezlere izin ver']")).click();
       // e-posta kutusuna rastgele bir mail adresi girin
        WebElement eposta = driver.findElement(By.xpath("//input[@id='email']"));
        eposta.sendKeys("aslkdjasajdo");
        //şifre kısmına rastgele bir şifre girin
        WebElement password = driver.findElement(By.xpath("//input[@id='pass']"));
        password.sendKeys("asjkd123");
        //giriş yap butonuna basın
        driver.findElement(By.xpath("//button[@name='login']")).click();
        // uyarı olarak hata mesajının çıktığını test edin
        WebElement result = driver.findElement(By.xpath("//div[@class='_9ay7']"));

        String actualResult = result.getText();
        String expected = "The email or phone number you entered isn't connected to an account.Find your account and log in";
        if(expected.equals(actualResult)) {
            System.out.println("Login test passed");
        } else{
            System.out.println("Login test failed");
        }

        //sayfayı kapatın
        driver.close();

    }
}
