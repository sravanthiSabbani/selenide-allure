package com.selenide.springtest.sample;

import io.cucumber.junit.platform.engine.Constants;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectDirectories;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

//@SpringBootTest
//@CucumberContextConfiguration
//@RunWith(Cucumber.class)
//@CucumberOptions(features = {"src/test/resources/com/automatedtest/sample/Search.feature"},
////        strict = false,
//        plugin = {"pretty",
//        "json:target/cucumber_json_reports/search.json"src\test\java\com\selenide\springtest\sample\features
//        "html:target/search-html"},
//        glue = {"com.automatedtest.sample.infrastructure.driver",
//                "com.automatedtest.sample.homepage",
//                "com.automatedtest.sample.searchresultpage"})
@Suite
@IncludeEngines("cucumber")
@SelectDirectories("src\\test\\java\\com\\selenide\\springtest\\sample\\features\\search1.feature")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.selenide.springtest.sample")
@ConfigurationParameter(key = Constants.PLUGIN_PUBLISH_QUIET_PROPERTY_NAME, value = "true")
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME, value = "pretty"+ ", html:target/Destination/")
public class Search1Test {
}
