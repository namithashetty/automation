package master.sjsu.clinicalTrials;

import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class Automation {
	public static void main(String[] args)  {
		System.setProperty("webdriver.chrome.driver", "/Users/namithashetty/Desktop/chromedriver");
		WalgreensPage walgreensPage = new WalgreensPage();
		//walgreensPage.launchBrowser();
		//walgreensPage.registerTest();
		walgreensPage.launchBrowser();
		walgreensPage.validSignInTest();
		walgreensPage.launchBrowser();
		walgreensPage.verifyEmptySignInFields();
		walgreensPage.launchBrowser();
		walgreensPage.yourAccountDropDown();
		walgreensPage.launchBrowser();
		walgreensPage.validateBalanceRewardImage();
		walgreensPage.launchBrowser();
		walgreensPage.verifyIncorrectRegisterFields();
		walgreensPage.launchBrowser();
		walgreensPage.validateSignOut();
		System.exit(0);
	}
}
