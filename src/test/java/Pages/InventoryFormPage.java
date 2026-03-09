package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import java.time.Duration;

// It encapsulates the elements and actions related to filling out the inventory form.
public class InventoryFormPage {

    // WebDriver instance for browser interactions
    WebDriver driver;
    // WebDriverWait for explicit waits to handle dynamic elements
    WebDriverWait wait;

    // Constructor to initialize the page object with the WebDriver and set up PageFactory
    public InventoryFormPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    // Locates the device type dropdown element
    @FindBy(id = "deviceType")
    WebElement deviceTypeSelect;

    // Locates the brand dropdown element
    @FindBy(id = "brand")
    WebElement brandSelect;

    // Storage radio buttons are dynamically located by ID, so no hardcoded @FindBy needed

    // Locates the color dropdown element
    @FindBy(id = "color")
    WebElement colorSelect;

    // Locates the quantity input field
    @FindBy(id = "quantity")
    WebElement quantityInput;

    // Locates the address input field
    @FindBy(id = "address")
    WebElement addressInput;

    // Locates the next button for the inventory form
    @FindBy(id = "inventory-next-btn")
    WebElement inventoryNextButton;

    // Shipping methods are dynamically located by ID, so no hardcoded @FindBy needed

    // Locates the discount code input field
    @FindBy(id = "discount-code")
    WebElement discountCodeInput;

    // Locates the apply discount button
    @FindBy(id = "apply-discount-btn")
    WebElement applyButton;

    // locates the discount feedback message
    @FindBy(id = "discount-feedback")
    WebElement discountFeedbackMessage;

    // Locates the add to cart button
   // @FindBy(id = "add-to-cart-btn")
   // WebElement addToCartButton;

    // Locates the confirm purchase button
    @FindBy(id = "purchase-device-btn")
    WebElement confirmPurchaseButton;

    // Locates the total value
    @FindBy(id = "breakdown-total-value")
    WebElement totalValue;

    // Locates the total value
    @FindBy(id = "//*[@id=\"purchase-success-toast\"]/p[1]")
    WebElement orderSuccessToast;

    @FindBy(id = "//*[@id=\"purchase-success-toast\"]/div[2]/p")
    WebElement orderDetails;

    // Selects the device type from the dropdown by visible text
    public void selectDeviceTypeByVisibleText(String deviceType) {
        // Wait until the dropdown is clickable
        wait.until(ExpectedConditions.elementToBeClickable(deviceTypeSelect));
        // Use Selenium Select to choose the option by visible text
        new Select(deviceTypeSelect).selectByVisibleText(deviceType);
    }

    // Selects the brand from the dropdown by visible text
    public void selectBrandByVisibleText(String brand) {
        // Wait until the dropdown is clickable
        wait.until(ExpectedConditions.elementToBeClickable(brandSelect));
        // Use Selenium Select to choose the option by visible text
        new Select(brandSelect).selectByVisibleText(brand);
    }

    // Chooses the storage option by capacity (64GB, 128GB, etc.)
    // The method constructs the ID dynamically based on the storage capacity provided
    public void chooseStorage(String storageCapacity) {
        // Construct the storage radio button ID from the capacity (e.g., "128GB" becomes "storage-128GB")
        String storageId = "storage-" + storageCapacity;
        // Find the specific storage option by the constructed ID
        WebElement storageOption = driver.findElement(By.id(storageId));
        // Wait until it is clickable and click it
        wait.until(ExpectedConditions.elementToBeClickable(storageOption)).click();
    }

    // Selects the color from the dropdown by visible text
    public void selectColor(String color) {
        // Wait until the dropdown is clickable
        wait.until(ExpectedConditions.elementToBeClickable(colorSelect));
        // Use Selenium Select to choose the option by visible text
        new Select(colorSelect).selectByVisibleText(color);
    }

    // Sets the quantity in the input field
    public void setQuantity(int qty) {
        // Wait until the input is visible
        wait.until(ExpectedConditions.visibilityOf(quantityInput));
        // Clear the field and send the quantity as string
        quantityInput.clear();
        quantityInput.sendKeys(Integer.toString(qty));
    }

    // Sets the address in the input field
    public void setAddress(String address) {
        // Wait until the input is visible
        wait.until(ExpectedConditions.visibilityOf(addressInput));
        // Clear the field and send the address
        addressInput.clear();
        addressInput.sendKeys(address);
    }

    // Clicks the next button to proceed in the form
    public void clickNext() {
        // Wait until the button is clickable and click it
        wait.until(ExpectedConditions.elementToBeClickable(inventoryNextButton)).click();
    }

    // Chooses the shipping method by type (express, standard, etc.)
    // The method constructs the ID dynamically based on the shipping method provided
    public void chooseShippingMethod(String shippingMethod) {
        // Construct the shipping radio button ID from the method type (e.g., "express" becomes "shipping-option-express")
        String shippingId = "shipping-option-" + shippingMethod;
        // Find the specific shipping option by the constructed ID
        WebElement shippingOption = driver.findElement(By.id(shippingId));
        // Wait until it is clickable and click it
        wait.until(ExpectedConditions.elementToBeClickable(shippingOption)).click();
    }

    // Chooses the warranty option by type (none, 1yr, 2yr, etc.)
    // The method constructs the ID dynamically based on the warranty type provided
    public void chooseWarranty(String warrantyType) {
        // Construct the warranty radio button ID from the type (e.g., "1yr" becomes "warranty-option-1yr")
        String warrantyId = "warranty-option-" + warrantyType;
        // Find the specific warranty option by the constructed ID
        WebElement warrantyOption = driver.findElement(By.id(warrantyId));
        // Wait until it is clickable and click it
        wait.until(ExpectedConditions.elementToBeClickable(warrantyOption)).click();
    }

    // Applies a discount code
    public void applyDiscount(String code) {
        // Wait until the discount input is visible
        wait.until(ExpectedConditions.visibilityOf(discountCodeInput));
        // Clear and enter the code
        discountCodeInput.clear();
        discountCodeInput.sendKeys(code);
        // Wait until the apply button is clickable and click it
        wait.until(ExpectedConditions.elementToBeClickable(applyButton)).click();
    }

    public void verifyDiscountMessage(String expectedMessage) {
        // Wait until the message is visible
        wait.until(ExpectedConditions.visibilityOf(discountFeedbackMessage));
        // Get the actual text
        String actual = discountFeedbackMessage.getText();
        // Assert that it matches the expected message
        if (!actual.equals(expectedMessage)) {
            throw new AssertionError("Expected: " + expectedMessage + ", but got: " + actual);
        }
    }

    public void verifyTotal(String totalExpected) {
        // Wait until the toast is visible
        wait.until(ExpectedConditions.visibilityOf(totalValue));
        // Get the actual text
        String actual = totalValue.getText();
        // Assert that it matches the expected message
        if (!actual.equals(totalExpected)) {
            throw new AssertionError("Expected: " + totalExpected + ", but got: " + actual);
        }
    }

    // Click Confirms the purchase
    public void confirmPurchase() {
        // Wait until the button is clickable and click it
        wait.until(ExpectedConditions.elementToBeClickable(confirmPurchaseButton)).click();
    }

    // Verifies the purchase success message
    public void verifyPurchaseSuccess(String expectedMessage) {
        // Wait until the toast is visible
        wait.until(ExpectedConditions.visibilityOf(orderSuccessToast));
        // Get the actual text
        String actual = orderSuccessToast.getText();
        // Assert that it matches the expected message
        if (!actual.equals(expectedMessage)) {
            throw new AssertionError("Expected: " + expectedMessage + ", but got: " + actual);
        }
    }

    public void verifyOrderDetails(String expectedMessage) {
        // Wait until the toast is visible
        wait.until(ExpectedConditions.visibilityOf(orderDetails));
        // Get the actual text
        String actual = orderDetails.getText();
        // Assert that it matches the expected message
        if (!actual.equals(expectedMessage)) {
            throw new AssertionError("Expected: " + expectedMessage + ", but got: " + actual);
        }
    }

    // Private helper method to wait and click an element
    private void waitAndClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    // Private helper method to wait, clear, and send keys to an input element
    private void waitAndSendKeys(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
    }

    // Private helper method to wait and get text from a visible element
    private String getTextWhenVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }
}