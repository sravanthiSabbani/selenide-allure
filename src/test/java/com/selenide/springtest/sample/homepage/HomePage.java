package com.selenide.springtest.sample.homepage;

import com.selenide.springtest.sample.annotations.LazyComponent;
import com.selenide.springtest.sample.pages.BasePage;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Value;

import java.time.Duration;

@LazyComponent
public class HomePage extends BasePage {
//
//    private static final String HOME_PAGE_URL = "https://www.google.";
@Value("${application.url}")
private String HOME_PAGE_URL;
    @FindBy(xpath = "//img[@alt='Google']")
    private WebElement logo;
//
    @FindBy(xpath = "//textarea[@title='Search']")
    private WebElement searchInput;
//
//
//    HomePage() {
//        PageFactory.initElements(driver, this);
//    }
//
//    void goToHomePage(String country){
//        driver.get(HOME_PAGE_URL + country);
//        wait.forLoading(20);
//    }
public HomePage goToHomePage(String country) {
    driver.get(this.HOME_PAGE_URL + country);
    int timeout = 20;
    return this;
}
    @Override
    public boolean isAt() {
        return this.wait.until((d) -> this.searchInput.isDisplayed());
    }
//
    void checkLogoDisplay() {
        Assertions.assertTrue(this.logo.isDisplayed());
    }

    String getTitle() {
        return driver.getTitle();
    }

    void checkSearchBarDisplay() {
        Assertions.assertTrue(this.searchInput.isDisplayed());
    }
//
    void searchFor(String searchValue) {
        this.searchInput.sendKeys(searchValue);
        this.searchInput.sendKeys(Keys.ENTER);
    }

//    @Override
//    public boolean isAt() {
//        return false;
//    }
}
