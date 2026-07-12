package com.muhammedshopkart.support;

import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

import com.muhammedshopkart.config.Config;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.muhammedshopkart.support.*;

public class Hooks {
    private final World world;
    
    public Hooks(World world){
        this.world=world;
    }

    @Before
    public void setup(){
        Configuration.baseUrl = Config.BASEURL_UI();
        Configuration.browser = Config.BROWSER();
        Configuration.browserSize = Config.BROWSERSIZE();
        Configuration.headless = Config.HEADLESS();
    }

    
    @After(order = 1)
    public void attachScreenshotOnFailure(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot =
                    ((TakesScreenshot) getWebDriver())
                            .getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot, "image/png", "failure-screenshot");
        }
    }

}
