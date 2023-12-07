package org.testingNG;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class createNewProfile extends baseNg{
    By myAccountMenu = By.xpath("//div[@id='widget-navbar-217834']//span[contains(text(),'My account')]");
    By continueBtn = By.xpath("//div[@id='content']//a[text()='Continue']");
    By firstName = By.id("input-firstname");
    By lastName = By.id("input-lastname");
    By email = By.id("input-email");
    By telephone = By.id("input-telephone");
    By password = By.id("input-password");
    By confirmPassword = By.id("input-confirm");
    By checkBox = By.xpath("//label[@for='input-agree']");
    By continueRegester = By.xpath("//input[@type='submit' and @value='Continue']");
    By continueAccountSuccess = By.xpath("//div[@class='buttons mb-4']//a[text()='Continue']");
    By logout = By.xpath("//div[@id='widget-navbar-217834']//span[contains(text(),'Logout')]");
    By logoutContinue = By.xpath("//div[@class='buttons mb-4']//a[text()='Continue']");

    @Test(priority = 1)
    public void test1_NewProfile(){
        click(myAccountMenu);
        wait(continueBtn);
        click(continueBtn);
        wait(continueRegester);
        type(firstName, "Sarthak");
        type(lastName,"Rana");
        type(email, randomEmail());
        type(telephone, "123456789");
        type(password,"password");
        type(confirmPassword, "password");
        click(checkBox);
        click(continueRegester);
        wait(continueAccountSuccess);
        click(continueAccountSuccess);
        System.out.println("\nRandom Email Genereated: "+randomEmail());
    }
    @Test(dependsOnMethods = "test1_NewProfile")
    private void test2_Logout(){
        wait(myAccountMenu);
        Actions act = new Actions(driver);
        act.moveToElement(find(myAccountMenu)).perform();
        click(logout);
        wait(logoutContinue);
        click(logoutContinue);
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
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    private String randomEmail() {
        String randomEmail = RandomStringUtils.random(5, true, true) + "@gmail.com";
        return randomEmail;
    }
}