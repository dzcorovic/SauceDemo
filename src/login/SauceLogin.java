package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SauceLogin {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\Nahla_automation\\vjezba\\SauceDemo\\executable\\chromedriver.exe");
	
	    WebDriver driver = new ChromeDriver(); 
	    
	    // step 1 open sauce page
	    
	    driver.get("https://www.saucedemo.com/");
	    Thread.sleep(3000);
	    
	    // step 2 open
	    
	   // driver.navigate().to("https://www.saucedemo.com/");
	    
	   // find user-name element 
	    
	   WebElement username= driver.findElement(By.id("user-name"));
	   
	   // find element password
	   
	   WebElement password= driver.findElement(By.id("password"));
	   
	   // find Login button
	   
	   WebElement logButton = driver.findElement(By.className("btn_action"));
	   
	   // sent username and password
	   username.sendKeys("standard_user");
	   password.sendKeys("secret_sauce");
	   
	   
	   // click on login button
	   
	   logButton.click();
	   
	   // get current url
	   
	  String cUrl = driver.getCurrentUrl();
	  
	  System.out.println("This is current URL:"+ cUrl);
	  
	  if(cUrl.contentEquals("https://www.saucedemo.com")) {
		  System.out.println("Url is correct. Test case:PASSED");
	  }
	  else {
		  System.out.println("Url is incorrect. Test case: FAILED");
	  } 
	  
	   //close browser
	   driver.quit();
	   
	}

}
