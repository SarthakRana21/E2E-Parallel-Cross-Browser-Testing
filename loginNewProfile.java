package org.testingNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class loginNewProfile extends baseNg{
    By myAccountMenu = By.xpath("//div[@id='entry_217834']//span[contains(text(),'My account')]");
    By inputEmail = By.id("input-email");
    By inputPassword = By.id("input-password");
    By loginBtn = By.xpath("//input[@type='submit' and @value='Login']");
    By searchBar = By.xpath("//div[@id='entry_217822']//input[@aria-label='Search For Products']");
    By searchButton = By.xpath("//div[@id='entry_217822']//button[@type='submit']");
    By iPhone = By.xpath("//div[@id='entry_212469']//a[text()='iPhone']");
    By buyNowButton = By.xpath("//div[@id='entry_216843']//button[text()= 'Buy now']");

    @Test(priority = 11)
    public void test1_Login(){
        wait(myAccountMenu);
        click(myAccountMenu);
        wait(loginBtn);
        type(inputEmail, "blabla@gmail.com");
        type(inputPassword, "password");
        click(loginBtn);
    }
    @Test(dependsOnMethods = "test1_Login")
    public void test2_addToCart(){
        wait(searchButton);
        click(searchBar);
        type(searchBar,"iphone");
        click(searchButton);
        wait(iPhone);
        click(iPhone);
        wait(buyNowButton);
        click(buyNowButton);
    }
    private WebElement find(By locator){
        return driver.findElement(locator);
    }
    private void click(By locator){
        find(locator).click();
    }
    private void type(By locator, String text){
        find(locator).sendKeys(text);
    }
    private WebElement wait(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element;
    }
}
