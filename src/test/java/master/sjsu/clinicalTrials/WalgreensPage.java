package master.sjsu.clinicalTrials;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class WalgreensPage  {
	WebDriver driver = new ChromeDriver();
	String userName = "namitha.shetty@icloud.com";
	String password = "iCloud1234";
	
	public void launchBrowser(){
		// objects and variables instantiation
		
		String appUrl = "http://www.walgreens.com";
		//String appUrl = "https://www.walgreens.com/youraccount/default.jsp";
		driver.get(appUrl);
		// maximize the browser window
		driver.manage().window().maximize();
	}
		
	//REGISTER test
	public void registerTest(){
		try{
			WebElement createAccount = driver.findElement(By.xpath("//*[contains(text(), 'Register')]"));
			createAccount.click();
		
			//Basic account Sign up
			Thread.sleep(100);
			WebElement signUpForBasic = driver.findElement(By.xpath("//*[contains(text(), 'Sign up for basic access')]"));
			signUpForBasic.click();
		
			//Enter First name
			WebElement firstName = driver.findElement(By.name("firstName"));
			firstName.clear();
			firstName.sendKeys("Nirmala");
		
			//Enter Last name
			WebElement lastName = driver.findElement(By.name("lastName"));
			lastName.clear();
			lastName.sendKeys("Shetty");
		
			//Enter email address
			WebElement email = driver.findElement(By.name("registerEmail"));
			email.clear();
			email.sendKeys(userName);
		
			//Enter password
			WebElement password1 = driver.findElement(By.name("registerPassword"));
			password1.clear();
			password1.sendKeys(password);
		
			Thread.sleep(1000);
			//Click on Show Password characters checkbox
			WebElement showPassword = driver.findElement(By.id("wag-regform-showpassword-label"));
			showPassword.click();
		
			Thread.sleep(5000);
			//Agree the terms
			//WebElement termsAgree = driver.findElement(By.id("read_and_agree_walgreens_terms_of_use"));
			//termsAgree.click();
		
			//Close the pop up
			WebElement closePopup = driver.findElement(By.name("Close"));
			closePopup.click();
		
			//System.out.println("PASS");
			Assert.assertTrue(assertSignUp(), "Sign up success");
		}catch(Exception ex){
		}
	}
	
	//Validation of Error messsages when incorrect values in the fields are entered
	public void verifyIncorrectRegisterFields(){
		try{
			//Click on Register
			WebElement createAccount = driver.findElement(By.xpath("//*[contains(text(), 'Register')]"));
			createAccount.click();
						
			//Basic account Sign up
			Thread.sleep(100);
			WebElement signUpForBasic = driver.findElement(By.xpath("//*[contains(text(), 'Sign up for basic access')]"));
			signUpForBasic.click();
					
			//Enter First name
			WebElement firstName = driver.findElement(By.name("firstName"));
			firstName.clear();
			firstName.sendKeys("$#@%^");
		
			//Enter Last name
			WebElement lastName = driver.findElement(By.name("lastName"));
			lastName.clear();
			lastName.sendKeys("@#$^&");
		
			//Enter email address
			WebElement email = driver.findElement(By.name("registerEmail"));
			email.clear();
			email.sendKeys("sbc");
		
			//Enter password
			WebElement password1 = driver.findElement(By.name("registerPassword"));
			password1.clear();
			password1.sendKeys("as");
			
			Thread.sleep(1000);
			//Click on Show Password characters checkbox
			WebElement showPassword = driver.findElement(By.id("wag-regform-showpassword-label"));
			showPassword.click();
			
			Thread.sleep(2000);
			Assert.assertTrue(assertSignInFields("Please enter a valid first name only with letters."), "PASS");
			Assert.assertTrue(assertSignInFields("Please enter a valid last name only with letters."), "PASS");
			Assert.assertTrue(assertSignInFields("Please enter a valid email address."), "PASS");
			Assert.assertTrue(assertSignInFields("Password needs to have a minimum of 8 characters."), "PASS");
		}
		catch(Exception ex){
			
		}
	}
	
	//Check validation of Register page	
		public boolean assertRegisterFields(String text){
			try{
		        boolean b = driver.getPageSource().contains(text);
		        System.out.println(b);
		         if(b){
		        	 System.out.println("PASS");
		         	 return true;
		         }
		         else{
		        	 System.out.println("FAIL");
		         	return false;
		         }
		        }
		        catch(Exception e){
		            return false;
		        }
		  }
	
	public void validSignInTest(){
		try{
			//Sign in to walgreens
			WebElement signIn = driver.findElement(By.xpath("//*[contains(text(), 'Sign In')]"));
			signIn.click();
		
			//Enter Username
			WebElement userNameLogin = driver.findElement(By.id("signin-username"));
			userNameLogin.clear();
			userNameLogin.sendKeys(userName);
		
			//Enter Password
			WebElement passwd = driver.findElement(By.id("signin-password"));
			passwd.clear();
			passwd.sendKeys(password);
		
			//Click on Sign in
			WebElement clickSignIn = driver.findElement(By.id("wag-newlogin-signin"));
			clickSignIn.click();
		
			Thread.sleep(4000);
			//Check whether correct page was loaded
		
			Assert.assertTrue(assertLogin(), "Login success");
		}
		catch(Exception ex){
			
		}
	}
		
	
		
	//Validation of Error messsages when sign in is clicked while Username and Password are empty
	public void verifyEmptySignInFields(){
		//Sign in to walgreens
		WebElement signIn = driver.findElement(By.xpath("//*[contains(text(), 'Sign In')]"));
		signIn.click();
				
		//Click on Sign in
		WebElement clickSignIn = driver.findElement(By.id("wag-newlogin-signin"));
		clickSignIn.click();
				
		Assert.assertTrue(assertSignInFields("Please enter your username."), "PASS");
		Assert.assertTrue(assertSignInFields("Please enter your password."), "PASS");
	}
	
	//Check validation of Username and Password
	public boolean assertSignInFields(String text){
		try{
	        boolean b = driver.getPageSource().contains(text);
	        System.out.println(b);
	         if(b){
	        	 System.out.println("PASS");
	         	 return true;
	         }
	         else{
	        	 System.out.println("FAIL");
	         	return false;
	         }
	        }
	        catch(Exception e){
	            return false;
	        }
	  }
		
	
	public boolean assertLogin(){
		
		String actualUrl = driver.getCurrentUrl();
		System.out.println(actualUrl);
		String expectedUrl = "https://www.walgreens.com/youraccount/default.jsp";
		if(actualUrl.equals(expectedUrl)){
			System.out.println("PASS");
			return true;
		}
		else{
			System.out.println("FAIL");
			return false;
		}
	}
		
		
	public boolean assertSignUp(){
		//Validate whether account is successfully created and your profile is loaded
		String actualUrl = driver.getCurrentUrl();
		System.out.println(actualUrl);
		String expectedUrl = "https://www.walgreens.com/youraccount/default.jsp";
		if(actualUrl.equals(expectedUrl)){
			System.out.println("PASS");
			return true;
		}
		else{
			System.out.println("FAIL");
			return false;
		}
	}
		
		
	//Test Launching of Product orders from Your Account drop down
	public void yourAccountDropDown(){
		WebElement yourAccount = driver.findElement(By.id("youaccountdropdown"));
		yourAccount.click();
		
		WebElement productOrder = driver.findElement(By.xpath("//*[contains(text(), 'Product Orders')]"));
		productOrder.click();
		
		Assert.assertTrue(assertAccountDropDown(), "Login success");
	}
		
	//Validate whether correct page is loaded
	public boolean assertAccountDropDown(){
		String actualUrl = driver.getCurrentUrl();
		System.out.println(actualUrl);
		String expectedUrl = "https://www.walgreens.com/youraccount/orderstatus/orderstatus.jsp";
		if(actualUrl.equals(expectedUrl)){
			System.out.println("PASS");
			return true;
		}
		else{
			System.out.println("FAIL");
			return false;
		}
	}
	
	//Validate the Balance rewards image
	public void validateBalanceRewardImage(){
		try{
			//Click on Register
			WebElement createAccount = driver.findElement(By.xpath("//*[contains(text(), 'Register')]"));
			createAccount.click();
					
			//Basic account Sign up
			Thread.sleep(100);
			WebElement signUpForBasic = driver.findElement(By.xpath("//*[contains(text(), 'Sign up for basic access')]"));
			signUpForBasic.click();
		
			Thread.sleep(3000);
			WebElement balanceRewardImage = driver.findElement(By.xpath("//img[@src='/images/adaptive/share/images/point-blnc.png']"));
			boolean balanceRewardAssert = balanceRewardImage.isDisplayed();
			System.out.println(balanceRewardAssert);
			
			if(balanceRewardAssert){
				System.out.println("PASS");
			}
			else{
				System.out.println("FAIL");
			}
		}
		catch(Exception ex){
			
		}
	}
	
	public void validateSignOut(){
		try{
			validSignInTest();
			WebElement yourAccount = driver.findElement(By.id("youaccountdropdown"));
			yourAccount.click();
		
			WebElement productOrder = driver.findElement(By.xpath("//*[contains(text(), 'Sign Out')]"));
			productOrder.click();
		
			Thread.sleep(2000);
			Assert.assertTrue(assertSignOut(), "Sign Out success");
		}
		catch(Exception ex){
			
		}
	}
		
	//Validate whether correct page is loaded
	public boolean assertSignOut(){
		String actualUrl = driver.getCurrentUrl();
		System.out.println(actualUrl);
		String expectedUrl = "https://www.walgreens.com/logout.jsp";
		if(actualUrl.equals(expectedUrl)){
			System.out.println("PASS");
			return true;
		}
		else{
			System.out.println("FAIL");
			return false;
		}
	}
}
