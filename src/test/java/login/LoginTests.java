package login;

import base.BaseTests;
import com.ratn.pages.LoginPage;
import com.ratn.pages.SecureAreaPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTests {

    @Test
    public void testSuccessfulLogin(){
        LoginPage loginPage = homePage.clickFormAuthetication();
        loginPage.setUserNameField("tomsmith");
        loginPage.setPasswordField("SuperSecretPassword!");

        SecureAreaPage secureAreaPage = loginPage.clickLoginBtn();

        //Assert.assertEquals(secureAreaPage.getAlertText(),"You logged into a secure area!", "Alert text incorrect");

        Assert.assertTrue(secureAreaPage.getAlertText().contains("You logged into a secure area!"), "Alert text incorrect");
    }
}

