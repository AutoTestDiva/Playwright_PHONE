package org.nat.phonebook;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.isLoginLinkPresent()) {
            app.clickOnSignOutButton();
        }
        app.clickOnLoginLink();
    }

    @Test
    public void loginPositiveTest(){
        app.fillLoginRegistrationForm(new User().setEmail("2025@gmail.com").setPassword("Test2025!"));
        app.clickOnLoginButton();
        Assert.assertTrue(app.isSignOutButtonPresent());
    }
    @Test
    public void loginNegativeTest(){
        app.fillLoginRegistrationForm(new User().setPassword("Test2025!"));
        app.clickOnLoginButton();
        Assert.assertTrue(app.isAlertPresent());
    }
}
