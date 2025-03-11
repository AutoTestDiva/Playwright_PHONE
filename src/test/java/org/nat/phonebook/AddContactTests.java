package org.nat.phonebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class AddContactTests extends TestBase{
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
    public boolean isContactAdded(String text){
        List<WebElement> contacts = driver.findElements(By.cssSelector("h2"));
        for (WebElement el : contacts) {
            if (el.getText().contains(text))
                return  true;}
        return false;
        }
    }

