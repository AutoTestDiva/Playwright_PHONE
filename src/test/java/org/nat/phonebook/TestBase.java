package org.nat.phonebook;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class TestBase {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://telranedu.web.app");
        //max window
        driver.manage().window().maximize();
        //timeout
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public boolean isHomeComponentPresent(){
        return driver.findElements(By.xpath("//h1[.='Home Component']")).size()>0;
    }

    public boolean isElementPresent(By locator){
        return driver.findElements(locator).size()>0;
    }

    public boolean isElementPresent2(By locator){
        try{
            driver.findElement(locator);
            return true;
        }catch (NoSuchElementException ex){
            return false;
        }
    }

    @AfterMethod (enabled=false)
    public void tearDown() {
        driver.quit();
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void type(By locator, String text) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public boolean isAlertPresent() {
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.alertIsPresent());
        if (alert == null) {
            return false;
        } else {
            driver.switchTo().alert();
            alert.accept();
            return true;
        }
    }

    public void clickOnLoginLink() {
        click(By.cssSelector("a:nth-child(4)"));
    }

    public void clickOnSignOutButton() {
        click(By.xpath("//button[contains(.,'Sign Out']"));
    }

    public boolean isLoginLinkPresent() {
        return isElementPresent(By.cssSelector("a:nth-child(4)"));
    }

    public void clickOnRegistrationButton() {
        click(By.xpath("//button[text()='Registration']"));
    } public void clickOnLoginButton() {
        click(By.cssSelector("button[name='login']"));
    }

        public void fillLoginRegistrationForm(User user) {
        type(By.cssSelector("[placeholder ='Email']"), user.getEmail());
        type(By.cssSelector("[placeholder ='Password']"), user.getPassword());
    }

    public void pause(int millis)  {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
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

    public boolean isSignOutButtonPresent() {
        return isElementPresent2(By.xpath("//button[text()='Sign Out']"));
    }

    public void clickOnAddLink() {
        click(By.cssSelector("a[href='/add']"));
    }

    public void clickOnSaveButton() {
        click(By.cssSelector("div[class='add_form__2rsm2'] button"));
    }

    public void fillContactForm(String name, String surname, String phone, String email, String address, String description) {
        type(By.cssSelector("input[placeholder='Name']"), name);
        type(By.cssSelector("input[placeholder='Last Name']"), surname);
        type(By.cssSelector("input[placeholder='Phone']"), phone);
        type(By.cssSelector("input[placeholder='email']"), email);
        type(By.cssSelector("input[placeholder='Address']"), address);
        type(By.cssSelector("input[placeholder='description']"), description);
    }

    public void removeContact() {
        click(By.cssSelector(".contact-item_card__2SOIM"));
        click(By.xpath("//button[.='Remove']"));
    }

    public void addContact() {
        clickOnAddLink();
        fillContactForm("Max", "Mayer", "49123456789", "Max@gmail.com", "Leipzig", "Software tester");
        clickOnSaveButton();
    }

    public void login() {
        clickOnLoginLink();
        fillLoginRegistrationForm(new User().setEmail("2025@gmail.com").setPassword("Test2025!"));
        clickOnLoginButton();
    }
}
