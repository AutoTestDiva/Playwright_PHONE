package org.nat.phonebook;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {

    @Test
    public void isHomeComponentPresentTest(){
       Assert.assertTrue(isHomeComponentPresent());
    }

}
