package org.nat.phonebook.framework;

import org.nat.phonebook.models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ContactHelper extends HelperBase{
    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public int sizeOfContacts(){
        if(isElementPresent2(By.cssSelector(".contact-item_card__2SOIM"))){
            return driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
        }
        return 0;
    }

    public boolean isContactAdded(String text){
        List<WebElement> contacts = driver.findElements(By.cssSelector("h2"));
        for (WebElement el : contacts) {
            if (el.getText().contains(text))
                return  true;}
        return false;
        }



    public void clickOnAddLink() {
        click(By.cssSelector("a[href='/add']"));
    }

    public void clickOnSaveButton() {
        click(By.cssSelector("div[class='add_form__2rsm2'] button"));
    }

    public void fillContactForm(Contact contact) {
        type(By.cssSelector("input[placeholder='Name']"), contact.getName());
        type(By.cssSelector("input[placeholder='Last Name']"), contact.getSurname());
        type(By.cssSelector("input[placeholder='Phone']"), contact.getPhone());
        type(By.cssSelector("input[placeholder='email']"), contact.getEmail());
        type(By.cssSelector("input[placeholder='Address']"), contact.getAddress());
        type(By.cssSelector("input[placeholder='description']"), contact.getDescription());
    }

    public void removeContact() {
        click(By.cssSelector(".contact-item_card__2SOIM"));
        click(By.xpath("//button[.='Remove']"));
    }

    public void addContact() {
        clickOnAddLink();
        fillContactForm(new Contact()
                .setName("Max")
                .setSurname("Mayer")
                .setPhone("49123456789")
                .setEmail("Max@gmail.com")
                .setAddress("Leipzig")
                .setDescription("Software tester"));
        clickOnSaveButton();
    }
}
