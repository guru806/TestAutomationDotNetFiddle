Feature: Validate .netFiddle Application
Description : This feature file covers basic tests on UI

  Background: Navigate to application URL
    Given I navigate to the application URL

   Scenario: @Test1
     Given I click on Run button
     Then I should see "Hello World" text on the output window

  Scenario: @Test2
    Given I input firstName, I should see the actions accordingly
    |firstName|
    |Aiden |
    |Finn|
    |Luke|
    |Steven|
    |Victoria|
