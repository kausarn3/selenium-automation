package com.zohocrm.testscript;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Keywords {
	static ChromeDriver driver;
	static Properties prop;
	static Robot robot;

	static {
		try {
			robot = new Robot();
			prop = new Properties();
			FileInputStream fs = new FileInputStream(
					"F:\\WorkSpaces\\selenium\\automation-testcase\\src\\com\\zohocrm\\objectrepository\\objectrepository.properties");
			prop.load(fs);

		} catch (IOException | AWTException e) {
			e.printStackTrace();
		}
	}

	public void openbrowser() {
		driver = new ChromeDriver();
	}

	public void navigate(String testData) {
		driver.get(testData);
	}

	public void input(String testData, String objectname) {
		driver.findElement(By.xpath(prop.getProperty(objectname))).sendKeys(testData);
	}

	public void signIn(String objectname) {
		driver.findElement(By.xpath(prop.getProperty(objectname))).click();
	}

	public void waitStatement(double testData) throws InterruptedException {

		Thread.sleep((long) testData);
	}

	public void salutation(String testdata) {
		if (testdata.equals("Mr.")) {
			robot.keyPress(KeyEvent.VK_M);
			robot.keyPress(KeyEvent.VK_R);
			robot.keyPress(KeyEvent.VK_PERIOD);
			robot.keyPress(KeyEvent.VK_ENTER);
		}
		if (testdata.equals("Mrs.")) {
			robot.keyPress(KeyEvent.VK_M);
			robot.keyPress(KeyEvent.VK_R);
			robot.keyPress(KeyEvent.VK_S);
			robot.keyPress(KeyEvent.VK_PERIOD);
			robot.keyPress(KeyEvent.VK_ENTER);
		}
		if (testdata.equals("Ms.")) {
			robot.keyPress(KeyEvent.VK_M);
			robot.keyPress(KeyEvent.VK_S);
			robot.keyPress(KeyEvent.VK_PERIOD);
			robot.keyPress(KeyEvent.VK_ENTER);
		}
		if (testdata.equals("Dr.")) {
			robot.keyPress(KeyEvent.VK_D);
			robot.keyPress(KeyEvent.VK_R);
			robot.keyPress(KeyEvent.VK_PERIOD);
			robot.keyPress(KeyEvent.VK_ENTER);
		}
		if (testdata.equals("prof.")) {
			robot.keyPress(KeyEvent.VK_P);
			robot.keyPress(KeyEvent.VK_R);
			robot.keyPress(KeyEvent.VK_O);
			robot.keyPress(KeyEvent.VK_F);
			robot.keyPress(KeyEvent.VK_PERIOD);
			robot.keyPress(KeyEvent.VK_ENTER);
		}
	}
}
