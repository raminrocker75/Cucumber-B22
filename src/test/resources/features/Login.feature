@all
Feature: Library app login feature
  User story:
  As a user, I should be able to login with correct credentials to different accounts.And dashboard should be displayed.
  Accounts are: librarian, student, admin
@librarian
  Scenario: Login as librarian
    Given as a librarian i should be able to login
    When user enters librarian username
    And user enter librarian password
    Then user should see the dashbord

@student
  Scenario: Login as a student
    Given as a student i should be able to login
    When user enters student username
    And user enter student password
    Then user should student the dashbord
@admin
  Scenario: Login as admin
    Given as admin i should be able to login
    When user enters admin username
    And user enter admin password
    Then user should admin the dashboard
    #Break FOR 16 MINS: 2.05 CST
