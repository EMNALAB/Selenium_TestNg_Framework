# Automation Framework - POM

Welcome to the Coin Gecko Automation Framework! This framework is designed to automate test cases for the Sample application, ensuring the quality and reliability of the platform. Below you will find information on setting up the framework, the tools and technologies used, project hierarchy, reporting, supported browsers, and more.

## Setup

1. Ensure that Java is installed on your machine.
2. Set up Eclipse and install TestNG tool using the Eclipse Marketplace.
3. Open Eclipse and click on "File" > "Open Projects from File System" > Click "Directory" button > Navigate to your project > Select the folder > Finish.
4. Maven will automatically install the necessary dependencies for the automation framework.

## Assertions

Assertions are applied throughout the framework to validate expected outcomes. However, due to the dynamic nature of numeric values, assertions are primarily applied to static text. In order to apply assertions to numeric values, APIs would be required to retrieve fresh input for comparison.

## Locators

The framework prioritizes using ID as the primary locator, but custom CSS selectors and XPath are utilized when ID is not available. This approach ensures effective element identification even when class names are commonly used.

## Language and Tools Used

The automation framework is developed using Selenium with Java. TestNG, Spark Reporter, and other 3rd-party tools are also implemented to enhance the testing process.

## Build Management Tool

Maven is utilized as the project and dependency management tool to simplify the setup and management of the project.

## Design Pattern

The framework follows the Page Object Pattern, which enhances code reusability and maintainability by separating the page structure from the test code. 

## Hierarchy

```
src/main/java:
  Configurations:
    - ExcelSheet: Contains methods to update test status in Excel Sheet.
    - ExtentReports: Contains directory and implementation of Spark Reports.
    - Listeners: Listens to the execution of test cases.
    - Rerun_Testcase: Reruns failed test cases to check for flakiness.
    - Snap_Function: Contains screenshot methods.
    - Webdriver: Contains WebDriver implementation.

src/test/java:
  Helpers:
    - Helpers_Crypto: Contains shared functions specific to webpages.
    - Helpers: Contains shared functions used throughout the project.

Page_Object:
  - Homepage: Contains locators of the homepage page.
  - AccessCryptoData: Contains locators of a specific page.

test_Cases:
  - Navigation: Contains test cases for redirection/navigation from the homepage.
  - Validate_btc: Contains test cases for scenarios like sharing and adding to portfolio.

test_Data (Using Data Providers):
  - Td_Home: Contains test data for the homepage.
  - Td_crypto: Contains test cases for displaying specific crypto details.

src/test/resources:
  - Data.properties: Contains URL and browser name configurations.
  - Test_Sheet.xlsx: Contains method names and execution results.

Implementation of Reporting:

The framework generates three types of reports: Spark Reports, TestNG reports, and Excel sheet results. To view Spark Reports, simply open the provided HTML file.

Screenshots:

The attached screenshots provide detailed information about the execution and results.

Error Handling:

If a test case fails, the framework captures the exception and attaches the corresponding screenshot in the Spark Reporter. Additionally, the framework reruns the failed test case three times to identify any flakiness issues.

Supported Browsers:

The framework supports three browsers: Chrome, Edge, and Firefox. The default browser is Microsoft Edge, but you can modify the browser selection in the data.properties file under src/test/resources.

How to Run the Framework:

Individual test cases can be executed, or you can run the complete test suite by opening the testng.xml file and right-clicking to run using TestNG. This execution will generate comprehensive reports.

Naming Convention:

Method names are detailed, improving the readability and understanding of the code.

Comments:

Throughout the project, comments have been placed to enhance code readability and maintainability.

Automated Test Cases:

The following test cases have been automated:
- TC01_Verify_the_user_is_redirected_to_the_homepage_when_he_access_the_link
- TC02_Verify_that_the_new_Coins_tab_is_clickable

We hope this framework provides a robust and efficient way to automate test cases for the Coin Gecko application. Feel free to explore and contribute to its development!

Happy Testing!
