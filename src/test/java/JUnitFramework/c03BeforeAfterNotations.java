package JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class c03BeforeAfterNotations {
    /*
    Oluşturduğumuz test class'ın içindeki test metotları
    hep aynı web sitesi ile ilgili ise her seferinde yeniden driver oluşturmaya
    ve her metot için bu driver'ı kapatmaya gerek yoktur
    Class'ın başında bir defa setUp'u çalıştırıp en sonda kapatırsak da olur
    Bunun için BeforeClass ve AfterClass kullanırız

    Before ve After'ı class düzeyinde çalıştırmak için metotları static olarak tanımlamalıyız
     */
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
    }

    @Test @Ignore // Ignore ile işaretlersem bu testi görmezden gelir ve gerçekleştirmez
    public void test02(){
        System.out.println(driver.getTitle());
    }

    @Test
    public void test03(){
        System.out.println(driver.getCurrentUrl());
    }
}
