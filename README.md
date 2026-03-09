Project Overview: NdosiAutoInventoryFlow

NdosiAutoInventoryFlow/
├── pom.xml                           # Maven configuration with Selenium, TestNG, POI, ExtentReports
├── README.md                         # Empty documentation file
├── testng.xml                        # Root TestNG suite (separate tests for Login and Inventory)
├── testrunner/testng.xml             # Alternative suite (combined test)
├── src/
│   ├── main/
│   │   ├── java/                     # (Empty - no main classes)
│   │   └── resources/
│   │       └── testdata.xlsx         # Excel file for test data
│   └── test/
│       └── java/
│           ├── Base/
│           │   └── BaseTest.java     # Base class with browser setup/teardown
│           ├── Basics/
│           │   ├── LoginTest.java    # Login test with Excel data provider
│           │   ├── InventoryFormTest.java  # Inventory form filling test
│           │   └── LandingPageTest.java    # Navigation test
│           ├── Pages/
│           │   ├── LoginPage.java    # Login page object model
│           │   ├── LandingPage.java  # Landing page navigation
│           │   └── InventoryFormPage.java  # Inventory form page object model
│           └── Utilities/
│               ├── BrowserFactory.java     # Browser initialization
│               └── ReadXLData.java         # Excel data provider utility
Key Components
1. Dependencies (pom.xml)
   Selenium WebDriver 4.40.0: Browser automation
   TestNG 7.12.0: Testing framework
   Apache POI 5.5.1: Excel file reading
   ExtentReports 5.1.2: Test reporting
2. Base Framework (BaseTest.java)
   Uses @BeforeClass/@AfterClass for browser lifecycle
   Initializes all page objects
   Browser opens once per test class, closes after all methods
3. Page Object Model
   LoginPage.java: Login functionality with explicit waits
   LandingPage.java: Navigation to inventory form
   InventoryFormPage.java: Comprehensive form filling with dynamic element selection
4. Test Classes
   LoginTest.java: Data-driven login test using Excel
   InventoryFormTest.java: End-to-end inventory form submission
   LandingPageTest.java: Navigation test
5. Utilities
   BrowserFactory.java: Cross-browser support (Chrome, Firefox, Edge, etc.)
   ReadXLData.java: Data provider that reads Excel sheets by test method name
   Key Features
   ✅ Page Object Model: Clean separation of UI elements and actions
   ✅ Data-Driven Testing: Excel-based test data
   ✅ Dynamic Element Selection: Radio buttons selected by constructing IDs
   ✅ Explicit Waits: Robust element interaction handling
   ✅ Cross-Browser Support: Configurable browser choice
   ✅ TestNG Integration: Prioritized test execution
   ✅ ExtentReports Ready: Reporting framework configured
   Current Test Flow
   LoginTest: Reads credentials from Excel → Logs into application
   InventoryFormTest: Fills device details → Selects options → Submits form
   LandingPageTest: Handles navigation between sections
   Configuration
   URL: https://ndosisimplifiedautomation.vercel.app/
   Browser: Chrome (configurable)
   Test Data: src/main/resources/testdata.xlsx
   Timeouts: 15 seconds for element waits
