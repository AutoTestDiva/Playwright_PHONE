package org.nat.phonebook;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase{
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.isLoginLinkPresent()) {
            app.clickOnSignOutButton();
        }
        app.login();
        app.clickOnAddLink();
    }

    @Test
    public void addContactPositiveTest(){
        app.fillContactForm(new Contact()
                .setName("Max")
                .setSurname("Mayer")
                .setPhone("49123456789")
                .setEmail("Max@gmail.com")
                .setAddress("Leipzig")
                .setDescription("Software tester"));
        app.clickOnSaveButton();
        Assert.assertTrue(app.isContactAdded("Max"));
    }

    @AfterMethod
    public void postCondition(){
        app.removeContact();
    }
}

