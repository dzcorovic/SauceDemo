package login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SauceLoginVerThree {
	private WebDriver driver;
	public static void main(String[] args) {
		// create object of the class
				SauceLoginVerTwo login = new SauceLoginVerTwo(); // konstruktor za klasu

				// call method set up on the object
				login.Setup();
				
				System.out.println(login.getCurrentUrl());

				// call method enterUsernameandPassword
			
				login.enterUsernameandPassword("locked_out_user", "secret_sauce");
				
				login.clickLoginButton();
				
				System.out.println(login.getCurrentUrl());
				
				Assert.assertEquals(login.getCurrentUrl(), "https://www.saucedemo.com/inventory.html", "You are not login");
                
				login.
				// call method TearDown
				// login.TearDown();
			}

			public void Setup() {

				String dir = System.getProperty("user.dir");

				System.setProperty("webdriver.chrome.driver", dir + "\\executable\\chromedriver.exe");

				driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // implicit wait -TestNG

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
			
			public void getErrorMessage() {
				
				return driver.findElement(By.cssSelector([data-test="error"])).
				
			}
			
			public void TearDown() {

				driver.quit();

			}

	}


