package com.company.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.company.framework.utils.WaitUtils;

public class LoginPage extends BasePage {

    private WaitUtils wait;

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(css = "button[type='submit']")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        wait = new WaitUtils(driver, 10);
    }

    public void enterUsername(String username) {
        wait.waitForVisibility(usernameInput);
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        wait.waitForVisibility(passwordInput);
        passwordInput.sendKeys(password);
    }

    public void clickLogin() {
        wait.waitForClickability(loginButton);
        loginButton.click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
}
