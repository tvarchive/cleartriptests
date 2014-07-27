**Introduction:** 

Folks we have written a tutorial for aspiring test automation engineers who wants to master Webdriver and looking for Test Automation Framework creation knowledge. 
The project contains bunch of chapters right from "writing your first Selenium test" to "how to implement Page Object Pattern". 
This is a sample framework for illustration purpose. It will demo the implementation of Java with WebDriver (aka Selenium 2) 
and how to write automated tests. 

**Target Audience:** 

To work and interact with this project, a basic knowledge of Java, Selenium API and GIT would be required. This tutorial is not meant to teach you Java.
This is more to teach and enable you to how to write automated tests in Java using Selenium and TestNG.

**Application Under Test:** 

We are using Cleartrip website (http://www.cleartrip.com) for automation. This website was obvious choice as it is rich with controls like
Textbox, Drop down, Calendar control, Ajax wait etc.
The Scenarios considered are mostly the day to day business use case where in we have used ticket booking business scenario and it's different flavors.
You need to have one of the IDE either Eclipse or IntelliJ. Once you are done with cloning the project , you need to import the project.
Your preferred IDE might throw some error if path to JDK is not set properly.   

**What you will find under this repo:** 

It contains certain chapters and also how a user would transition
 
From 	
	`driver.findby`  

To 
	`given(user).choosesToDoAFlightSearch();`
    `when(user).searchesForAOneWayJourneyWith(journeyDetails);`
    `then(user).hasJourneyOptionsAvailableForHisOutboundJourney();`


**How to Start:**
 In the src folder of the project we have a README package which houses the read me for the chapters. This is a good point to start. One is supposed to read the chapters first and then browse through the Scenarios package to see the implementations. One good way to practice would be create a sample java class file and start experimenting by starting to write the test on the similar lines.
