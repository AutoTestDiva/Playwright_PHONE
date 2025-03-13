package org.nat.phonebook;

import org.nat.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
        app.getUser().clickOnLoginLink();
    }

//    @Test
//    public void newUserRegistrationPositiveTest() {
//        fillLoginRegistrationForm("2025@gmail.com", "Test2025!");
//        // driver.findElement(By.xpath("//button[text()='Registration']")).click();
//        clickOnRegistrationButton();
//        Assert.assertTrue(isElementPresent2(By.xpath("//button[text()='Sign Out']")));
//    }

    @Test
    public void existedUserRegistrationNegativeTest() {
        app.getUser().fillLoginRegistrationForm(new User()
                .setEmail("2025@gmail.com")
                .setPassword("Test2025!"));
        app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isAlertPresent());
    }
}
