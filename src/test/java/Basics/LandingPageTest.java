package Basics;

import Base.BaseTest;
import Pages.LandingPage;
import org.testng.annotations.Test;

public class LandingPageTest extends BaseTest{

    @Test(groups = "landing", dependsOnGroups = "login")
    public void landingPage(){
        System.out.println("Starting class landingPageTest");
       // LandingPage landingPage = new LandingPage(driver);
        landingPage.clickLearnTab();
        landingPage.clickLearningMaterialsTab();
        landingPage.clickWebAutomationAdvanceTab();
    }
}
