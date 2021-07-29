package com.cybertek.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LibraryStepDefs {
    @Given("as a librarian i should be able to login")
    public void as_a_librarian_i_should_be_able_to_login() {
        System.out.println("Librarian Logged in");
    }

    @Given("as a student i should be able to login")
    public void as_a_student_i_should_be_able_to_login() {
        System.out.println("Student logged in");
    }

    @When("user enters librarian username")
    public void user_enters_librarian_username() {
        System.out.println("entered librarian username");
    }
    @When("user enter librarian password")
    public void user_enter_librarian_password() {
        System.out.println("Entered librarian password");
    }
    @Then("user should see the dashbord")
    public void user_should_see_the_dashbord() {
        System.out.println("user is seeing dashboard");
    }
    @When("user enters student username")
    public void user_enters_student_username() {
        System.out.println("Entered student username");

    }
    @When("user enter student password")
    public void user_enter_student_password() {
        System.out.println("Entered student password");
    }
    @Then("user should student the dashbord")
    public void user_should_student_the_dashbord() {
        System.out.println("Student is seeing dashboard");
    }

    @Given("as admin i should be able to login")
    public void asAdminIShouldBeAbleToLogin() {
        System.out.println("Admin logged in");
    }

    @When("user enters admin username")
    public void userEntersAdminUsername() {
        System.out.println("Admin entered username");
    }

    @And("user enter admin password")
    public void userEnterAdminPassword() {
        System.out.println("Admin entered password");
    }

    @Then("user should admin the dashboard")
    public void userShouldAdminTheDashboard() {
        System.out.println("Admin is seeing dashboard");
    }
}
