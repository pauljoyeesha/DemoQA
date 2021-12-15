Feature: To validate tasks in Lamba Test  
@tc1
Scenario Outline: TC1_Start by opening LambdaTest Selenium Playground by login
Given user open the url "<Screenshot>"
And user gives "<username>" and "<password>" and save "<Screenshot>"
And click on login button save "<Screenshot>"
When click enter email ID "<email>" and click populateBtn "<Screenshot>" and accept alert
And user fills the form "<Screenshot>"
And open another new window for new url "<Url>" and save "<Screenshot>"
And download image from CICD section "<Screenshot>"
And upload image to form and submit "<Screenshot>"
Then close browser

Examples:
|Screenshot|username|password|email|Url|
|TC1|lambda|lambda123|pauljoyeesha9@gmail.com|https://www.lambdatest.com/selenium-automation|
