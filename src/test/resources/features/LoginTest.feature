Feature: Login test
  Scenario: Login test with correct credentials
    Given I open koel
    When I login as user in koel with "igor.pavliuk@testpro.io" and "1q2w3e4R"
    Then I should be auth in Home Page