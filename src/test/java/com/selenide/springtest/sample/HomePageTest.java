package com.selenide.springtest.sample;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.platform.engine.Constants;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectDirectories;
import org.junit.platform.suite.api.Suite;
import org.junit.runner.RunWith;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

//@RunWith(Cucumber.class)
//@CucumberOptions(features = {"src/test/resources/com/automatedtest/sample/Home_page.feature"},
////        strict = false,
//        plugin = {"pretty", "com.epam.reportportal.cucumber.StepReporter",
//        "json:target/cucumber_json_reports/home-page.json",
//        "html:target/home-page-html"},
//        glue = {"com.automatedtest.sample.infrastructure.driver",
//                "com.automatedtest.sample.homepage"})
@Suite
@IncludeEngines("cucumber")
@SelectDirectories("src\\test\\java\\com\\selenide\\springtest\\sample\\features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.selenide.springtest.sample")
@ConfigurationParameter(key = Constants.PLUGIN_PUBLISH_QUIET_PROPERTY_NAME, value = "true")
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME, value = "pretty"+ ", html:target/Destination.html")
public class HomePageTest {
}
