package com.playwright.pages;

import com.microsoft.playwright.Locator;
import com.playwright.utils.BasePageFactory;
import io.qameta.allure.Step;
import org.openqa.selenium.By;


import static com.playwright.config.ConfigurationManager.config;

public final class LoginPage extends BasePage {

    @Step("Navigate to the login page")
    public LoginPage open() {
        page.navigate(config().baseUrl());
        return this;
    }

    @Step("Click on the 'Login' link")
    //public ProductsPage loginLink() {
    public LoginPage loginLink() {
        page.click("//a[.='LOGIN']");
       // return BasePageFactory.createInstance(page, ProductsPage.class);
        return this;
    }

    @Step("Type <username> into 'Username' textbox")
    public LoginPage typeUsername(final String username) {
        page.fill("[placeholder ='Email']", username);
        return this;
    }

    @Step("Type <password> into 'Password' textbox")
    public LoginPage typePassword(final String password) {
        page.fill("[placeholder ='Password']", password);
        return this;
    }

    @Step("Get error message")
    public Locator getErrorMessage() {
        return page.locator(".error-message-container h3");
    }

    @Step("Click on the 'Login' button")
    public ProductsPage submitLogin() {
        page.click("button[name='login']");
        return BasePageFactory.createInstance(page, ProductsPage.class);
    }

    @Step("Login attempt to Swag Labs")
    public ProductsPage loginAs(final String username, final String password) {
        open();
        loginLink();
        typeUsername(username);
        typePassword(password);
        return submitLogin();
    }

}