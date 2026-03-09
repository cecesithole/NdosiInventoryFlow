package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LandingPage {

    WebDriver driver;
    WebDriverWait wait;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    // Learn tab
    @FindBy(xpath = "//*[@id=\"app-root\"]/nav/div[1]/div[2]/div[1]/button/span[2]")
    WebElement LearnTab;

    // Learning Materials tab
    @FindBy(xpath = "//*[@id=\"app-root\"]/nav/div[1]/div[2]/div[1]/div/button[2]/span[2]")
    WebElement LearningMaterialsTab;

    // Web automation advance tab
    @FindBy(xpath = "//*[@id=\"tab-btn-web\"]/span[2]")
    WebElement webAutomationAdvanceTab;

    public void clickLearnTab() {
        wait.until(ExpectedConditions.elementToBeClickable(LearnTab)).click();
    }

    public void clickLearningMaterialsTab() {
        wait.until(ExpectedConditions.elementToBeClickable(LearningMaterialsTab)).click();
    }

    // Clicks the web automation advance tab to navigate to the inventory form
    public void clickWebAutomationAdvanceTab() {
        wait.until(ExpectedConditions.elementToBeClickable(webAutomationAdvanceTab)).click();
    }
}