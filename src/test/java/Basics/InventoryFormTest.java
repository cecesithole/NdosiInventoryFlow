package Basics;
import Base.BaseTest;
import Pages.InventoryFormPage;
import org.testng.annotations.Test;

public class InventoryFormTest extends BaseTest {

    @Test(groups = "inventory", dependsOnGroups = "landing")
    public void inventoryFormPage() {
        System.out.println(">>> Starting class inventoryFormTest <<<");
        InventoryFormPage inventoryFormPage = new InventoryFormPage(driver);
       /* landingPage.clickLearnTab();
        landingPage.clickLearningMaterialsTab();
        landingPage.clickWebAutomationAdvanceTab();*/

        // Fill the inventory form
        inventoryFormPage.selectDeviceTypeByVisibleText("Phone");
        inventoryFormPage.selectBrandByVisibleText("Apple");
        // Choose storage dynamically - pass just the capacity (64GB or 128GB)
        inventoryFormPage.chooseStorage("128GB");
        inventoryFormPage.selectColor("Blue");
        inventoryFormPage.setQuantity(2);
        inventoryFormPage.setAddress("123 Test Street Cape Town");
        inventoryFormPage.clickNext();
        // Choose shipping method dynamically - pass just the method type (express or standard)
        // The method constructs the ID automatically (e.g., "express" becomes "shipping-option-express")
        inventoryFormPage.chooseShippingMethod("express");
        inventoryFormPage.applyDiscount("SAVE10");
        inventoryFormPage.confirmPurchase();

        // Temporarily comment out these lines to see if the rest of the flow works
        // inventoryFormPage.confirmPurchase();
        // inventoryFormPage.verifyPurchaseSuccess("Purchase successful!");
    }
}
