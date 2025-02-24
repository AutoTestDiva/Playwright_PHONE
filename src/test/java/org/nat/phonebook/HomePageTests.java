package org.nat.phonebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomePageTests {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://telranedu.web.app");
        //max window
        driver.manage().window().maximize();
        //timeout
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void isHomeComponentPresentTest(){
        //driver.findElement(By.xpath("//h1[.='Home Component']"));
        System.out.println("Home Component is " + isHomeComponentPresent());
    }
    public boolean isHomeComponentPresent(){
        return driver.findElements(By.xpath("//h1[.='Home Component']")).size()>0;
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
