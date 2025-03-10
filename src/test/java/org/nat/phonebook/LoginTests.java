package org.nat.phonebook;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        if (!isElementPresent(By.cssSelector("a:nth-child(4)"))) {
            click(By.xpath("//button[contains(.,'Sign Out']"));
        }
        click(By.cssSelector("a:nth-child(4)"));
    }

    @Test
    public void loginPositiveTest(){
        type(By.cssSelector("[placeholder ='Email']"), "2025@gmail.com");
        type(By.cssSelector("[placeholder ='Password']"), "Test2025!");
        click(By.cssSelector("button[name='login']"));
        Assert.assertTrue(isElementPresent2(By.xpath("//button[text()='Sign Out']")));
    }
}
