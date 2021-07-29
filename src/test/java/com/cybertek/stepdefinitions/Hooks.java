package com.cybertek.stepdefinitions;

import com.cybertek.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    //import from io cucmber java not junit
    @Before
    public void setupScenario() {
        System.out.println("-- seting up browser with further details...");
    }

    @After
    public void tearDownScenario(Scenario scenario) {
        //if my scenario fails
        // take a screen shot

        //scenario.is failed() --> if scenario is failed : returns true
       if(scenario.isFailed()){
           byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
           scenario.attach(screenshot, "image/png", scenario.getName());

       }


        System.out.println("After --Teardown steps are being applied");
        Driver.closeDriver();
    }


    @BeforeStep
    public void setup() {
        System.out.println("----setup applying for each step");
    }
}
