package com.ratn.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {


//    @FindBy(linkText = "Form Authentication")
//    private WebElement formAuthLink;

    private WebDriver driver;
//    private By formAuthetication = By.linkText("Form Authentication");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage clickFormAuthetication() {
        //driver.findElement(formAuthetication).click();

        clickLink("Form Authentication");
        return new LoginPage(driver);
    }

    public DropdownPage clickDropDown() {
        clickLink("Dropdown");
        return new DropdownPage(driver);
    }

    public void clickLink(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }
}
