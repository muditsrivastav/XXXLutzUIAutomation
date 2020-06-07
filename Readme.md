Onna UI Automation
-------------------

About this framework
--------------------

. The framework is a Maven, Page Object Model project created using Java, TestNG, Selenium, Extent Report and Log4J2. <br/>
. The framework can be enhanced to a data-driven framework and each test case can be reused to run for multiple data sets using TestNG data provider. <br/>
. The framework can be improved by creating utility methods. <br/>
. The Framework can easily be integrated to any CI/CD tool for example Jenkins to schedule the run and to deliver the test reports to respective persons. <br/>


Test Case Automated in this Framework
--------------------------------------

Scenario : Create Workspace and share with an existing member (Members added in Admin Panel)
--------
Given User is on Onna home page after successful login <br/>
When User clicks create workspace icon <br/>
And fills Workspace name as “Test” <br/>
And Share workspace with  “test.admin@onna.com”  <br/>
And Select “Manage” permission <br/>
And User clicks “Create” button <br/>
Then Workspace with name “Test” is created <br/>
And Workspace is shared with “test.admin@onna.com” <br/>
And User is navigated to Add a Source page <br/>


How to run the tests
--------------------

. Install Java 7 or above if not present in your computer. <br/>
. Install Maven if not present in your computer. <br/>
. From command line navigate to the project directory. <br/>
. Run command - mvn clean install test <br/>