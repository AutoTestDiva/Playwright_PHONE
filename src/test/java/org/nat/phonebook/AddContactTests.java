package org.nat.phonebook;

import org.nat.phonebook.models.Contact;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddContactTests extends TestBase{
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
        app.getUser().login();
        app.getContact().clickOnAddLink();
    }

    @Test
    public void addContactPositiveTest(){
        app.getContact().fillContactForm(new Contact()
                .setName("Max")
                .setSurname("Mayer")
                .setPhone("49123456789")
                .setEmail("Max@gmail.com")
                .setAddress("Leipzig")
                .setDescription("Software tester"));
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isContactAdded("Max"));
    }


    @AfterMethod
    public void postCondition(){
        app.getContact().removeContact();
    }

    @DataProvider
    public Iterator<Object[]> newContact(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Oliver", "Kann", "1234567890", "k@g.com", "Berlin", "actor"});
        list.add(new Object[]{"Oliver1", "Kann", "1234567880", "k@g.com", "Berlin", "actor"});
        list.add(new Object[]{"Oliver2", "Kann", "1234567870", "k@g.com", "Berlin", "actor"});

        return list.iterator();
    }
    @Test(dataProvider = "newContact")
    public void addContactPositiveTestFromDataProvider(String name, String surname, String phone,
                                                       String email, String address, String description){
        app.getContact().fillContactForm(new Contact()
                .setName(name)
                .setSurname(surname)
                .setPhone(phone)
                .setEmail(email)
                .setAddress(address)
                .setDescription(description));
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isContactAdded(name));
    }

}

