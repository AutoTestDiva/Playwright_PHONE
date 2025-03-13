package org.nat.phonebook.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageHelper extends HelperBase{
    public HomePageHelper(WebDriver driver) {
        super(driver);
    }

    public boolean isHomeComponentPresent(){
        return driver.findElements(By.xpath("//h1[.='Home Component']")).size()>0;
    }
}
