package org.nat.phonebook;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase{
    @BeforeMethod
    public void ensurePrecondition() {
        if (!isLoginLinkPresent()) {
            clickOnSignOutButton();
        }
        clickOnLoginLink();
        fillLoginRegistrationForm("2025@gmail.com", "Test2025!");
        clickOnLoginButton();
        click(By.cssSelector("a[href='/add']"));
    }
    @Test
    public void addContactPositiveTest(){
    click(By.cssSelector("input[placeholder='Name']"));
        type(By.cssSelector("input[placeholder='Name']"), "Max");
        type(By.cssSelector("input[placeholder='Last Name']"), "Mayer");
        type(By.cssSelector("input[placeholder='Phone']"), "49123456789");
        type(By.cssSelector("input[placeholder='email']"), "Max@gmail.com");
        type(By.cssSelector("input[placeholder='Address']"), "Leipzig");
        type(By.cssSelector("input[placeholder='description']"), "Software tester");
        click(By.cssSelector("div[class='add_form__2rsm2'] button"));
        Assert.assertTrue(isContactAdded("Max"));
    }

    @AfterMethod
    public void postCondition(){
            click(By.cssSelector(".contact-item_card__2SOIM"));
            click(By.xpath("//button[.='Remove']"));
        }
    }

