package com.selenide.springtest.sample;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.selenide.springtest.sample.annotations.LazyAutowired;
import com.selenide.springtest.sample.utils.ScreenshotUtil;
import io.cucumber.java.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.WebDriver;
import org.springframework.context.ApplicationContext;

public class CucumberHooks {

    @LazyAutowired
    private ScreenshotUtil screenshotUtil;

    @LazyAutowired
    private ApplicationContext applicationContext;

    @BeforeAll
    public static void beforeall(){

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }
    @AfterStep
    public void afterStep(Scenario scenario){
        if(scenario.isFailed()){
            scenario.attach(this.screenshotUtil.getScreenshot(), "image/png", scenario.getName());
        }
    }

    @After
    public void afterScenario(){
        this.applicationContext.getBean(WebDriver.class).quit();
    }

}
