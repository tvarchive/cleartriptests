package scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Chapter_13_TipsnTricks {

	WebDriver driver;
	Chapter_01_TheFirstSeleniumTest BasicSearchTest = new Chapter_01_TheFirstSeleniumTest();

	@Test
	public void testDragnDropfunctionality() {
		BasicSearchTest.testThatResultsAppearForAOneWayJourney();
		dragAndDropByOffset("rangeHandleMin1", 50, 0);
	}
	
	/**
	 * This is just an example to demonstrate how to use custom browser profiles.
	 * You need to create a browser profile first and then use the below implementation.
	 * This can help you achieve some specific settings, clearing cache on exit etc...
	 * On Mac you can hit the command "/Applications/Firefox.app/Contents/MacOS/firefox-bin -p" in Terminal,
	 * this will help you create a new profile.
	 */
	@Test
	public void testFirefoxProfile(){
		FirefoxProfile test_profile = new ProfilesIni().getProfile("Webdriver");
		driver = new FirefoxDriver(test_profile);
		// Carry on with your regular testing steps
	}
	
	

	/*
	 * This method can be used when there is a droppable element in webpage
	 * 
	 * private void dragAndDropToElement(String toDrag, String toDrop) {
	 * WebElement drag = BasicSearchTest.driver.findElement(By.id(toDrag));
	 * WebElement drop = BasicSearchTest.driver.findElement(By.id(toDrop));
	 * Actions builder = new Actions(BasicSearchTest.driver); Action dragAndDrop
	 * = builder.clickAndHold(drag).moveToElement(drop) .release(drag).build();
	 * dragAndDrop.perform(); }
	 */

	
	// This method is used when you want to drag by an offset and 
	// you don't actually have the container to drop the element
	private void dragAndDropByOffset(String idToDrag, int x, int y) {
		WebElement drag = BasicSearchTest.driver.findElement(By.id(idToDrag));
		Actions builder = new Actions(BasicSearchTest.driver);
		Action dragAndDrop = builder.clickAndHold(drag).moveByOffset(x, y)
				.release(drag).build();
		dragAndDrop.perform();
	}

}
