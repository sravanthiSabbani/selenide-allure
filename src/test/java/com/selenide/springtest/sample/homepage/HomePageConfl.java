package com.selenide.springtest.sample.homepage;

import com.selenide.springtest.sample.annotations.LazyComponent;
import com.selenide.springtest.sample.pages.BasePage;
import com.selenide.springtest.sample.pages.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
@LazyComponent
public class HomePageConfl extends BasePage {
    @Autowired
    LoginPage loginPage;

    @Value("${confluence.url}")
    private String baseURL;

    //*********Web Elements By Using Page Factory*********
    @FindBy(how = How.CLASS_NAME, using = "btnSignIn")
    public WebElement signInButton;

    By homePageLogo = By.cssSelector(".logo.home");

    //*********Page Methods*********
    //Go to Homepage
    public HomePageConfl goToHomePage() {
        driver.get(baseURL);
        return this;
    }

    //Go to LoginPage
    public HomePageConfl goToLoginPage() {
        click(signInButton);
        return this;
    }

    @Override
    public boolean isAt() {
        return this.wait.until((d) -> this.signInButton.isDisplayed());
    }

    public HomePageConfl verifyThatIAmAtHomePage() {
        Assertions.assertTrue(driver.findElement(homePageLogo).isDisplayed());
        return this;

    }
}
