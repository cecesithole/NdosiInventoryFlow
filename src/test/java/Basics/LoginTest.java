package Basics;

import Base.BaseTest;
import Pages.LoginPage;
import Utilities.ReadXLData;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

    @Test(groups = "login", dataProvider = "testData", dataProviderClass = ReadXLData.class)
    public void loginWithValidDetails(String Username, String Password) throws InterruptedException {
        System.out.println(">>> Starting class LoginTest");
        // Reinitialize page objects with the static driver
       // loginPage = new LoginPage(driver);
        //PageFactory.initElements(driver, this);

        loginPage.clickLoginButton();
        loginPage.enterEmailAddress(Username);
        loginPage.enterPassword(Password);
        loginPage.clickSubmitButton();
        loginPage.verifyLoginSuccess("Here's who's working today");
    }
}
