package com.selenide.springtest.sample.searchresultpage;

import com.selenide.springtest.sample.SearchTest;
import io.cucumber.java.en.Then;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

public class SearchResultPageSteps {

    @Autowired
    private SearchResultPage searchResultPage;



    @Then("^\"([^\"]*)\" is displayed in the first \"([^\"]*)\" results$")
    public void isDisplayedInTheFirstResults(String expectedResult, int nbOfResultsToSearch) {
        Assert.assertTrue(expectedResult + " wasn't found in the first " + nbOfResultsToSearch + " results.",
                this.searchResultPage.isInResults(expectedResult, nbOfResultsToSearch));
    }
}
