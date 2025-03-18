package org.nat.phonebook;

import org.nat.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class LoginTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
        app.getUser().clickOnLoginLink();
    }

    @Test
    public void loginPositiveTest(){
        app.getUser().fillLoginRegistrationForm(new User()
                .setEmail("2025@gmail.com")
                .setPassword("Test2025!"));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isSignOutButtonPresent());
    }
    @Test
    public void loginNegativeTest(){
        app.getUser().fillLoginRegistrationForm(new User()
                .setPassword("Test2025!"));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isAlertPresent());
    }

    @Test
    public void loginPositiveTestWithScreencast() throws IOException, AWTException {
        app.getUser().deleteScreencast();
        app.getUser().startRecording();
        app.getUser().fillLoginRegistrationFormForScreencast(new User()
                .setEmail("2025@gmail.com")
                .setPassword("Test2025!"));
        app.getUser().clickOnLoginButton();
        app.getUser().pause(2000);
        app.getUser().stopRecording();
    }
}
