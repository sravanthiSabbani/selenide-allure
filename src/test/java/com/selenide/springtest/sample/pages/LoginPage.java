package com.selenide.springtest.sample.pages;

import com.codeborne.selenide.SelenideElement;
import com.selenide.springtest.sample.annotations.LazyComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.junit.jupiter.api.Assertions.assertEquals;

@LazyComponent
public class LoginPage extends BasePage {
    //********* Web Elements by using Page Factory *********
    @FindBy(how = How.ID, using = "email")
    public WebElement userName;

    @FindBy(how = How.ID, using = "email")
    public SelenideElement userName1;
    @FindBy(how = How.ID, using = "password")
    public WebElement password;

    //********* Web Elements by using By Class *********
    By loginButtonBy          = By.id("loginButton");
    By errorMessageUsernameBy = By.xpath("//*[@id=\"loginForm\"]/div[1]/div/div");
    By errorMessagePasswordBy = By.xpath("//*[@id=\"loginForm\"]/div[2]/div/div");
    By errorMessagePasswordCssBy = By.cssSelector("div[data-errormessagefor='password'] > .errorText");

    //*********Page Methods*********
    public LoginPage login(String userName, String password) {
        writeText(this.userName, userName);
        writeText(this.password, password);
        jsClick(loginButtonBy);
        return this;
    }

    /***
     * Enter value using selenide api - setValue(**)
     * @param userName
     * @param password
     * @return
     */
    public LoginPage loginUsingSelenide(String userName, String password) {
        userName1.setValue(userName);
        writeText(this.password, password);
        jsClick(loginButtonBy);
        return this;
    }

    public LoginPage verifyLoginUserNameErrorMessage(String expectedText) {
        assertEquals(expectedText, readText(errorMessageUsernameBy));
        return this;
    }

    public LoginPage verifyPasswordErrorMessage(String expectedText) {
        assertEquals(expectedText, readText(errorMessagePasswordBy));
        return this;
    }

    public LoginPage verifyPasswordErrorMessageWithCss(String expectedText) {
        assertEquals(expectedText, readTextErrorMessage(errorMessagePasswordCssBy));
        return this;
    }

    public LoginPage verifyLogEntryFailMessage() {
        logUtil.isLoginErrorLog(driver);
        return this;
    }

    @Override public boolean isAt() {
        return this.wait.until((d) -> this.userName.isDisplayed());
    }
}
