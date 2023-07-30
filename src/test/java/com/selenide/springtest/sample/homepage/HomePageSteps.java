package com.selenide.springtest.sample.homepage;

import com.selenide.springtest.sample.SearchTest;
import com.selenide.springtest.sample.annotations.LazyAutowired;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.Assert;

public class HomePageSteps {

    @LazyAutowired
    private HomePage homePage;

//    public HomePageSteps() {
//        this.homePage = new HomePage();
//    }

    @Given("^A user navigates to HomePage \"([^\"]*)\"$")
    public void aUserNavigatesToHomePage(String country) {
        homePage.goToHomePage(country);
    }

    @Then("^Google logo is displayed$")
    public void googleLogoIsDisplayed() {
        this.homePage.checkLogoDisplay();
    }

    @And("^search bar is displayed$")
    public void searchBarIsDisplayed() {
        this.homePage.checkSearchBarDisplay();
    }

    @Then("^page title is \"([^\"]*)\"$")
    public void pageTitleIs(String title) {
        String displayedTitle = this.homePage.getTitle();
        Assert.assertTrue("Displayed title is " + displayedTitle + " instead of " + title,
                title.equals(displayedTitle));
    }

    @When("^a user searches for \"([^\"]*)\"$")
    public void aUserSearchesFor(String searchValue) {
        this.homePage.searchFor(searchValue);
    }
}
