package org.nat.phonebook;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CreateAccountTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!isElementPresent(By.cssSelector("a:nth-child(4)"))) {
            driver.findElement(By.xpath("//button[contains(.,'Sign Out']")).click();
        }
        driver.findElement(By.cssSelector("a:nth-child(4)")).click();
    }

    @Test
    public void newUserRegistrationPositiveTest() {
        driver.findElement(By.cssSelector("[placeholder ='Email']")).click();
        driver.findElement(By.cssSelector("[placeholder ='Email']")).clear();
        driver.findElement(By.cssSelector("[placeholder ='Email']")).sendKeys("2025@gmail.com");
        driver.findElement(By.cssSelector("[placeholder ='Password']")).click();
        driver.findElement(By.cssSelector("[placeholder ='Password']")).clear();
        driver.findElement(By.cssSelector("[placeholder ='Password']")).sendKeys("Test2025!");
        // driver.findElement(By.xpath("//button[text()='Registration']")).click();
        driver.findElement(By.cssSelector("button[name='login']")).click();
        Assert.assertTrue(isElementPresent2(By.xpath("//button[text()='Sign Out']")));
    }

    @Test
    public void newUserRegistrationNegativeTest() {
        driver.findElement(By.cssSelector("[placeholder ='Email']")).click();
        driver.findElement(By.cssSelector("[placeholder ='Email']")).clear();
        driver.findElement(By.cssSelector("[placeholder ='Email']")).sendKeys("2025@gmail.com");
        driver.findElement(By.cssSelector("[placeholder ='Password']")).click();
        driver.findElement(By.cssSelector("[placeholder ='Password']")).clear();
        driver.findElement(By.cssSelector("[placeholder ='Password']")).sendKeys("Test2025!");
        driver.findElement(By.xpath("//button[text()='Registration']")).click();
        Assert.assertTrue(isAlertPresent());
    }

    public boolean isAlertPresent() {
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.alertIsPresent());
        if (alert == null) {
            return false;
        } else {
            driver.switchTo().alert();
            alert.accept();
            return true;
        }

    }
}
