XXXLutz UI Automation
-------------------

About this framework
--------------------

. The framework is a Maven, Page Object Model project created using Java, TestNG, Selenium, Extent Report for reporting and Log4J2 for logging <br/>
. The framework can be enhanced to a data-driven framework and each test case can be reused to run for multiple data sets using TestNG data provider. <br/>
. The framework is integrated with code quality tool prettier.  <br/>
. The framework is integrated with testing service BrowserStack. <br/>
. The framework is integrated with CircleCI. <br/>


Test Case Automated in this Framework
--------------------------------------
1. Verify we can add new things to do task.
2. Verify we can check completed task and the completed task is visible on All Tab and Completed Tab but not on Active Tab.



How to run the tests
--------------------

. Install Java 7 or above if not present in your computer.<br/>
a) Follow this video for installing it on windows - https://www.youtube.com/watch?v=IJ-PJbvJBGs <br/>
b) For mac install openjdk follow instructions on this link - https://openjdk.java.net/install/  <br/>
. Install Maven if not present in your computer. <br/>
a) For Windows follow instructions here - https://maven.apache.org/guides/getting-started/windows-prerequisites.html. <br/>
b) For mac follow instructions here - https://maven.apache.org/install.html <br/>
. From command line navigate to the project directory. <br/>
. Run command - mvn prettier:check clean install , if build fails due to formatting run command - mvn prettier:write clean install<br/>


NOTE:
-----
The test will fail on CircleCI and BrowserStack as the te.react-todo-app is running locally. <br/>
