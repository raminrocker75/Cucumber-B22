package com.cybertek.stepdefinitions;

import com.cybertek.pages.EtsySearchPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Etsy_StepDefinitions {
    EtsySearchPage etsySearchPage = new EtsySearchPage();

    @Given("user is on the Etsy landing page")
    public void user_is_on_the_etsy_landing_page() {
        String browser = ConfigurationReader.getProperty("etsyUrl");
        Driver.getDriver().get(browser);
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Then("user should see Etsy title as expected")
    public void user_should_see_etsy_title_as_expected() {
        String expected = "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone";
        WebDriverWait wait  = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.titleIs(expected));
        String actual  = Driver.getDriver().getTitle();
        Assert.assertTrue("Title is not as expected",actual.equals(expected));
    }

    @When("user types wooden spoon in the search bar")
    public void user_types_wooden_spoon_in_the_search_bar() {

        etsySearchPage.searchBar.sendKeys("Wooden spoon");
    }

    @When("user clicks to search button")
    public void user_clicks_to_search_button() {
        etsySearchPage.searchButton.click();
    }

    @Then("user sees title is Wooden spoon | Etsy")
    public void user_sees_title_is_wooden_spoon_etsy() {
        String expected = "Wooden spoon | Etsy";
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.titleContains("Wooden spoon"));
        String actual = Driver.getDriver().getTitle();
        Assert.assertEquals(actual,expected);
    }


}
