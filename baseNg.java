package org.testingNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;

public class baseNg {
    protected WebDriver driver;
    @Parameters(value = "Browser")
    @BeforeClass
    public void setUp(String Browser){
        if(Browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "/Users/sarthakrana/Desktop/IDE/basic/git/src/main/resources/chromedriver");
            driver = new ChromeDriver();
        }
        else if (Browser.equals("safari")){
            System.setProperty("webdriver.safari.driver", "/usr/bin/safaridriver");
            driver = new SafariDriver();
        }
        else{
            System.err.println("Error");
        }
        driver.manage().window().maximize();
        driver.get("https://ecommerce-playground.lambdatest.io");
    }
    @AfterClass
    public void terminate(){
       driver.quit();
    }
}
