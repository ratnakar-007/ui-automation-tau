package com.ratn.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    private By userNameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginBtn      = By.cssSelector("#login button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUserNameField(String userName) {
        driver.findElement(userNameField).sendKeys(userName);
    }

    public void setPasswordField(String  password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public SecureAreaPage clickLoginBtn() {
        driver.findElement(loginBtn).click();
        return new SecureAreaPage(driver);
    }
}
