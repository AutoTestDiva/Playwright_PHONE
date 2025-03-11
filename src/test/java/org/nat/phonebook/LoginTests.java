package org.nat.phonebook;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        if (!isLoginLinkPresent()) {
            clickOnSignOutButton();
        }
        clickOnLoginLink();
    }

    @Test
    public void loginPositiveTest(){
        fillLoginRegistrationForm("2025@gmail.com", "Test2025!");
        clickOnLoginButton();
        Assert.assertTrue(isElementPresent2(By.xpath("//button[text()='Sign Out']")));
    }
}
