package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SauceLoginVerTwo {

	private WebDriver driver;

	public static void main(String[] args) {

		// create object of the class
		SauceLoginVerTwo login = new SauceLoginVerTwo(); // konstruktor za klasu

		// call method set up on the object
		login.Setup();
		
		System.out.println(login.getCurrentUrl());

		// call method enterUsernameandPassword
		login.enterUsernameandPassword("standard_user", "secret_sauce");

		login.clickLoginButton();
		
		System.out.println(login.getCurrentUrl());
		

		// call method TearDown
		// login.TearDown();
	}

	public void Setup() {

		String dir = System.getProperty("user.dir");

		System.setProperty("webdriver.chrome.driver", dir + "\\executable\\chromedriver.exe");

		driver = new ChromeDriver();

		// step 1 open sauce page

		driver.get("https://www.saucedemo.com/");

	}

	public void enterUsernameandPassword(String user, String pass) {

		driver.findElement(By.id("user-name")).sendKeys(user);

		driver.findElement(By.id("password")).sendKeys(pass);

	}

	public void clickLoginButton() {

		driver.findElement(By.className("btn_action")).click();
	}

	public String getCurrentUrl() {
		
		return driver.getCurrentUrl();
		
	}
	
	public void TearDown() {

		driver.quit();

	}

}
