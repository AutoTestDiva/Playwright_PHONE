package org.nat.phonebook.framework;


import org.nat.phonebook.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends HelperBase{

    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnLoginLink() {
        click(By.xpath("//a[.='LOGIN']"));
    }

    public void clickOnSignOutButton() {
        click(By.xpath("//button[contains(.,'Sign Out']"));
    }

    public boolean isLoginLinkPresent() {
        return isElementPresent(By.xpath("//a[.='LOGIN']"));
    }

    public void clickOnRegistrationButton() {
        click(By.xpath("//button[text()='Registration']"));
    }

    public void clickOnLoginButton() {
        click(By.cssSelector("button[name='login']"));
    }

    public void fillLoginRegistrationForm(User user) {
        type(By.cssSelector("[placeholder ='Email']"), user.getEmail());
        type(By.cssSelector("[placeholder ='Password']"), user.getPassword());
    }

    public void login() {
        clickOnLoginLink();
        fillLoginRegistrationForm(new User()
                .setEmail("2025@gmail.com")
                .setPassword("Test2025!"));
        clickOnLoginButton();
    }
    public boolean isSignOutButtonPresent() {
        return isElementPresent2(By.xpath("//button[text()='Sign Out']"));
    }
    public void fillLoginRegistrationFormForScreencast(User user) {
        type(By.cssSelector("[placeholder ='Email']"), user.getEmail());
        pause(500);
        type(By.cssSelector("[placeholder ='Password']"), user.getPassword());
        pause(500);
    }
}
