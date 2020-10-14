package com.ratn.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage {

    private WebDriver driver;

    private By statusAlert = By.id("flash");
    private By logoutBtn   = By.cssSelector(".example .button");

    public SecureAreaPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getAlertText() {
        return driver.findElement(statusAlert).getText();
    }

    public void clickLogout() {
        driver.findElement(logoutBtn).click();
    }
}
