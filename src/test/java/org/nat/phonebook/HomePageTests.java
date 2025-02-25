package org.nat.phonebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.NoSuchElementException;

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
       // System.out.println("Home Component is " + isElementPresent(By.xpath("//h1[.='Home Component']")));
        Assert.assertTrue(isHomeComponentPresent());
    }
    public boolean isHomeComponentPresent(){
        return driver.findElements(By.xpath("//h1[.='Home Component']")).size()>0;
    }

    public boolean isElementPresent(By locator){
        return driver.findElements(locator).size()>0;
    }
    public boolean isElementPresent2(By locator){
        try{
            driver.findElement(locator);
            return true;
        }catch (NoSuchElementException ex){
            return false;
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
