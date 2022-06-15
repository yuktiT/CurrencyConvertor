Feature: Currency Converter Verification
  
  Scenario Outline: To test multiple conversion rates
    Given the user launch the currency converter application 
    When the user enter the from <from> currency to <to> currency
    And enters the <amount> 
    And the user click on convert button
    Then the user verifies the conversion rates

    @Regression
    Examples: 
      | from | to  | amount |
      | USD  | EUR | 50     |
      | USD  | EUR | 15     |
      | USD  | EUR | 23     |
      | USD  | EUR | 55     |
      | USD  | EUR | 60     |
      
    @Smoke
    Examples: 
      | from | to  | amount | 
      | GBP  | CAD | 45     |
      | EUR  | AUD | 20     |
      