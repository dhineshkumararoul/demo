Feature: IRCTC Train Page Validations

  Scenario: Starting station input validation
    Given I open the IRCTC website
    When I enter "PU" as starting code and "PATCHUR - PU " as full starting
    Then I validate the train page starts correctly