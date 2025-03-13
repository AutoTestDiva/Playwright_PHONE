package org.nat.phonebook;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.isLoginLinkPresent()) {
            app.clickOnSignOutButton();
        }
        app.login();
        app.addContact();
    }

    @Test
    public void removeContactPositiveTest() {
        int sizeBefore = app.sizeOfContacts();
        app.removeContact();
        app.pause(1000);
        int sizeAfter = app.sizeOfContacts();
        Assert.assertEquals(sizeAfter, sizeBefore - 1);
    }
}
