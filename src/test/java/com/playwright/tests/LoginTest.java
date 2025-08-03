package com.playwright.tests;

import com.playwright.pages.ProductsPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginTest extends BaseTest {

    @Test
    public void testCorrectLoginCredentials() {
        ProductsPage productsPage = loginPage.loginAs("2025@gmail.com", "Test2025!");
        assertThat(productsPage.signOutButton()).hasText("Sign Out");
    }


    @Test
    public void testIncorrectLoginCredentials() {
       loginPage.loginAs("wrong", "fake");
        page.onDialog(dialog -> {
            Assertions.assertEquals("Wrong email or password", dialog.message());
            dialog.accept(); // Закрываем alert
        });
    }
}
