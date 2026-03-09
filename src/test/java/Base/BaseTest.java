package Base;
import Pages.LoginPage;
import Pages.LandingPage;
import Pages.InventoryFormPage;
import Utilities.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

   // BrowserFactory browserFactory = new BrowserFactory();
    public final String url = "https://ndosisimplifiedautomation.vercel.app/";
    public final String browserChoice = "chrome";

    // Static WebDriver so it persists across all test classes in the suite
    public WebDriver driver;
    public LoginPage loginPage;
    public LandingPage landingPage;
    public InventoryFormPage inventoryFormPage;

    @BeforeSuite (alwaysRun = true)
    public void setUp() {
        System.out.println(">>> @BeforeSuite: creating WebDriver (once for whole suite)");
        driver = BrowserFactory.startBrowser(browserChoice, url);
        // Initialize page objects with the driver

        loginPage = new LoginPage(driver);
        landingPage = new LandingPage(driver);
        inventoryFormPage = new InventoryFormPage(driver);
    }

   @AfterSuite (alwaysRun = true)
    public void tearDown() {
        System.out.println(">>> @AfterSuite: quitting WebDriver (once at end of suite)");
        // Close browser after all tests complete
        BrowserFactory.closeBrowser();
    }
}