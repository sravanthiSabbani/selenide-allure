package com.selenide.springtest.sample.confluencePage;

import com.selenide.springtest.sample.annotations.LazyAutowired;
import com.selenide.springtest.sample.homepage.HomePageConfl;
import com.selenide.springtest.sample.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Value;

public class LoginSteps {
    @Value("${browser}")
    private String browser;

    @LazyAutowired
    private HomePageConfl homePageConfl;

    @LazyAutowired
    private LoginPage loginPage;

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        homePageConfl
            .goToHomePage()
            .goToLoginPage();
    }

    @When("I try to login with {string} and {string}")
    public void iTryToLoginWithAnd(String userName, String password) {
        loginPage
            .login(userName, password);
    }

    @Then("I verify invalid login message")
    public void iVerifyInvalidLoginMessage() {
        if (!browser.equalsIgnoreCase("firefox")) {
            loginPage
                .verifyLogEntryFailMessage();
        } else {
            loginPage.verifyPasswordErrorMessageWithCss("E-posta adresiniz veya şifreniz hatalı");
        }
    }
}
