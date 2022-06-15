# Currency Converter Verification
---

- Write an acceptance test for http://www.xe.com/currencyconverter/

- The Acceptance criteria is to test multiple conversion rates

- The test should iterate over 5 sets of sample data.

- Example iteration : 
    *  The test should input from Euro to pounds.
    *  Verify the result on the proceeding page.
    
    
### The project directory structure

 ```Gherkin
 
  src
  + main
  + test
    + java                          Test runners and supporting code
        + pageObjects               For  page objects
            Homepage.java
        + stepDefinations           For Defining all the step definations and Hooks class
            StepDefs.java
            TestHooks.java
        + testRunner
          AppTestRunner.java          For Test runner
        + utilities
          BaseClass.java              For defining the Webdriver based on the browser
          PropertyReader.java         For reading the properties fron config.properties
    + resources
      + features                    Feature files
          CurrencyConverterAppTest.feature  
  ```
  
## Executing the tests
  
- To run the  project, you can either just run the `AppTestRunner.java` test runner class, or run either `mvn test` from the command line.   
- By default, the tests will run using Chrome. You can run them in Edge by overriding the `driver` configuration.properties file, e.g. browser = Edge
- Also applied tags

  
## Reports for the tests
- As of now we are getting json as well as html cucumber reports
- The test results will be recorded in the `target` directory.
