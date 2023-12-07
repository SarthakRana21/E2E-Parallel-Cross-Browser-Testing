# E2E-Parallel-Cross-Browser-Testing
This repository contains automated test scripts for end to end web application testing using Selenium and TestNG. The tests are designed for cross-browser testing, specifically on Chrome and Safari.
---

## Prerequisites
Make sure you have the following software installed on your machine:
- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html)
- [TestNG](https://testng.org/doc/download.html)
- [Selenium WebDriver](https://www.selenium.dev/documentation/en/webdriver/driver_requirements/)

## Project Structure
- **baseNg.java**: This class initializes the WebDriver based on the specified browser (Chrome or Safari) and performs setup and teardown operations for each test class.
  
- **CreateNewProfile.java**: This class contains tests related to creating a new user profile, registering, and logging out. It extends the `baseNg` class for browser setup.

- **loginNewProfile.java**: This class focuses on user login, searching for products, and adding items to the cart. It also extends the `baseNg` class for browser setup.

## TestNG Suite Configuration
The `testng.xml` file orchestrates the test suite, allowing parallel execution of tests on both Chrome and Safari browsers.

## Running the Tests
To execute the tests, run the `testng.xml` file. Ensure that the necessary drivers (chromedriver and safaridriver) are available in the specified paths.

## Test Data
- For user registration, random email addresses are generated using Apache Commons Lang's `RandomStringUtils`.

## Additional Information
- The tests use explicit waits for synchronization, enhancing reliability.
- The project is designed to facilitate easy integration into continuous integration (CI) pipelines.
---
## Output-
<img width="1552" alt="Screenshot 2023-12-07 at 12 18 19 PM" src="https://github.com/SarthakRana21/E2E-Parallel-Cross-Browser-Testing/assets/107024368/84bef004-6d53-4d24-b2b4-8da6b98224af">
