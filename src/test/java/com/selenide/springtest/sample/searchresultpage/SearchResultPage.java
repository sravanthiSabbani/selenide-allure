package com.selenide.springtest.sample.searchresultpage;

import com.selenide.springtest.sample.annotations.LazyComponent;
import com.selenide.springtest.sample.pages.BasePage;
import io.cucumber.spring.CucumberContextConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.List;
import java.util.stream.IntStream;
@LazyComponent
public class SearchResultPage extends BasePage {

    private static final String RESULTS_TITLE_SELECTOR = "a h3";

    @FindBy(css = RESULTS_TITLE_SELECTOR)
    private List<WebElement> results;


    boolean isInResults(String expectedTitle, int nbOfResultsToSearch) {

        return IntStream.range(0, Math.min(this.results.size(), nbOfResultsToSearch))
                .anyMatch(index -> this.results.get(index).getText().contains(expectedTitle));
    }

    @Override
    public boolean isAt() {
        return false;
    }
}

