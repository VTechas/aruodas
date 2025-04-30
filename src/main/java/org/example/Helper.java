package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Helper {
    public static WebDriver driver;
    public static void setUp(){
        if(driver != null){
            return;
        }
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        acceptCookies();
    }
    public static void acceptCookies() {
        driver.get("https://www.aruodas.lt/ideti-skelbima/");
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
    }

}