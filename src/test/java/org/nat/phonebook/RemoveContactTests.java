package org.nat.phonebook;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        if (!isLoginLinkPresent()) {
            clickOnSignOutButton();
        }
        clickOnLoginLink();
        fillLoginRegistrationForm("2025@gmail.com", "Test2025!");
        clickOnLoginButton();
        click(By.cssSelector("a[href='/add']"));
        click(By.cssSelector("input[placeholder='Name']"));
        type(By.cssSelector("input[placeholder='Name']"), "Max");
        type(By.cssSelector("input[placeholder='Last Name']"), "Mayer");
        type(By.cssSelector("input[placeholder='Phone']"), "49123456789");
        type(By.cssSelector("input[placeholder='email']"), "Max@gmail.com");
        type(By.cssSelector("input[placeholder='Address']"), "Leipzig");
        type(By.cssSelector("input[placeholder='description']"), "Software tester");
        click(By.cssSelector("div[class='add_form__2rsm2'] button"));
    }

    @Test
    public void removeContactPositiveTest(){
        int sizeBefore = sizeOfContacts();
        click(By.cssSelector(".contact-item_card__2SOIM"));
        click(By.xpath("//button[.='Remove']"));
        pause(1000);
        int sizeAfter = sizeOfContacts();
        Assert.assertEquals(sizeAfter, sizeBefore-1);
    }
}
