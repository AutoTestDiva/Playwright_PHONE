package org.nat.phonebook;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        if (!isElementPresent(By.cssSelector("a:nth-child(4)"))) {
            click(By.xpath("//button[contains(.,'Sign Out']"));
        }
        click(By.cssSelector("a:nth-child(4)"));
        type(By.cssSelector("[placeholder ='Email']"), "2025@gmail.com");
        type(By.cssSelector("[placeholder ='Password']"), "Test2025!");
        click(By.cssSelector("button[name='login']"));
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
    public void removeContactPositiveTest() {
        click(By.cssSelector(".contact-item_card__2SOIM"));
        click(By.xpath("//button[normalize-space()='Remove']"));

    }
}
