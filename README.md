# Challenge Automation Abstracta

## Test Scenarios
- Extracting Product Information
- Place an Order
- Sign Up in website
- Log In website

## Datos Técnicos:
- Java 11
- Selenium
- TestNg
- Cucumber

## Ejecución por Terminal:
- Test: mvn clean test / mvn test

## Estructura:
1. Main: 

    1.1 com.abstracta.config 

    1.1.1 ConfigPage: 
    - Config params
    - Web browser management
    - Management of Selenium methods

    1.2 LoggerPage:
    - Logger (Log4j2) management to register the process

    1.3 com.abstracta.process

    1.3.1 LogIn: 
    - Log In process management
    
    1.3.2 ProductInfo: 
    - Management of Product Information extraction
    
    1.3.3 Purchase: 
    - Management of Place Order process
    
    1.3.4 SignUp: 
    - Sign Up management
  
    1.4 com.abstracta.utils

    1.4.1 CreateFileText:
   - Management of file creation to save product information

    1.4.2 PropertyManager:
   - Management of Application.Properties file

3. Test:

    2.1 com.abstracta.test.defs

    2.1.1 Common: Before and After Testng annotations to set and close the driver configuration
    
    2.1.2 LogInTest: execution methods to LogIn user
    
    2.1.3 ProductInfoTest: execution methods for Product Information extraction
    
    2.1.4 PurchaseTest: execution methods for Purchase process
    
    2.1.5 SignUpTest: execution methods for Sign Up user

    2.2. RunCucumberTest.java
    Run Definition (Cucumber + TestNg)

## Scenarios
* src/test/resources/scenarios.feature 

## Report
* target/cucumber-report.html

## Screenshots:
* screenshots/

## Logs:
* logs/automation.log

