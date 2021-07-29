package com.cybertek.stepdefinitions;

import com.cybertek.pages.DropDownPage;
import com.cybertek.pages.LibraryLoginPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.internal.com.google.common.collect.Maps;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataTable_Steps {
    LibraryLoginPage loginPage = new LibraryLoginPage();
    DropDownPage dropdownsPage = new DropDownPage();

    @Given("User is on the dropdowns page of practice tool")
    public void user_is_on_the_dropdowns_page_of_practice_tool() {
        Driver.getDriver().get("http://practice.cybertekschool.com/dropdown");
    }

    @Then("User should see below info in month dropdown")
    public void user_should_see_below_info_in_month_dropdown(List<String> expectedList) {

        //1- Get the dropdown as a select object
        Select monthDropdown = new Select(dropdownsPage.month);

        //2- Get all the options from the dropdown and store inside of a List
        List<WebElement> actualMonthsAsWebElement = monthDropdown.getOptions();

        Assert.assertEquals(expectedList, BrowserUtils.getElementsText(actualMonthsAsWebElement));


//        //3- Convert the actualMonths from List<WebElement> to List<String>
//        List<String> actualMonthsAsString = new ArrayList<>();
//
//        for (WebElement each : actualMonthsAsWebElement) {
//
//            actualMonthsAsString.add(each.getText());
//
//        }
//
//        Assert.assertEquals(expectedList, actualMonthsAsString);


    }


    @Given("user is on the login page of library app")
    public void user_is_on_the_login_page_of_library_app() {

        String url = ConfigurationReader.getProperty("libraryUrl");
        Driver.getDriver().get(url);

    }

    @When("user enters username and password as below")
    public void user_enters_username_and_password_as_below(Map<String, String> loginInfo) {

        String username = loginInfo.get("username");
        //String password = loginInfo.get("password");

        loginPage.emailInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(loginInfo.get("password"));

        loginPage.signIn.click();

    }

    @Then("user should see title is Library")
    public void user_should_see_title_is_something() {

        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Library";

    }


    @Then("user should see below words displayed")
    public void user_should_see_below_words_displayed(List<String> listOfFruits) {

        System.out.println("listOfFruits.size() = " + listOfFruits.size());
        System.out.println("listOfFruits = " + listOfFruits);

    }

    @Then("user should see title is something")
    public void userShouldSeeTitleIsSomething() {
    }
}
