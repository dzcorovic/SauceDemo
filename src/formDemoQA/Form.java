/*
1.Open http://demoqa.com/automation-practice-form
2.Enter FistName, LastName, Email
3.Verify the number of radio buttons is equal to 3
4.Verify that by default none of radio button is selected
5.Select Female as gender
6.Enter phone Number
7.Enter Date Of Birth
8.Fill in Subject
9.Verify that number of checkboxes is 3
10.Verify that all checkbox are unchecked
11.Check Sport and Music
12.Upload file
13.Enter Current Address
14.Verify that select city is disabled
15.Verify the content of State dropdown
16.Select the state NCR and Gurgaon
17.Click on Submit button
18.Get student name from modal
19.Close modal
*/

package formDemoQA;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Form {
	private WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Form formy = new Form();
		formy.Setup();
		// formy.fillInField(id, value);
		formy.fillInField("firstName", "amina");
		formy.fillInField("lastName", "Prezime");
		formy.fillInField("userEmail", "amina.pez@gmail.com");
		// formy.getAllRadioButton("radio");
		int number = formy.getAllRadioButton("radio");
		Assert.assertEquals(number, 3, "Number of radio buttons is not 3.");
		boolean sel = formy.isRadioSelected("radio");
		Assert.assertFalse(sel, "Radio button is selected by deafult but it should not be");
		formy.selectFemale();
		String PhNumber="061637383";
		formy.EnterPhoneNumber(PhNumber);
		formy.SelectDateofBirth("19-05-1965");
	}

	public void Setup() {

		String dir = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", dir + "\\executable\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // implicit wait -TestNG
		driver.get(" http://demoqa.com/automation-practice-form");
	}

	public void fillInField(String locator, String value) {
		driver.findElement(By.id(locator)).sendKeys(value);
	}

	public int getAllRadioButton(String attValue) {

		List<WebElement> radioList = driver.findElements(By.cssSelector("[type=\"" + attValue + "\"]")); // css selector

		System.out.println("Number of radio buttons is " + radioList.size());

		return radioList.size();
	}

	public boolean isRadioSelected(String attValue) {
		List<WebElement> radioList = driver.findElements(By.cssSelector("[type=\"" + attValue + "\"]"));
		for (int i = 0; i < radioList.size(); i++) {
			if (radioList.get(i).isSelected()) {
				return true;
			}
		}
		return false;
	}

	public void selectFemale() {
		driver.findElement(By.cssSelector("[for=\"gender-radio-2\"]")).click();
		
	}
	public void EnterPhoneNumber(String PhoneNumber) {
		driver.findElement(By.id("userNumber")).sendKeys(PhoneNumber);
	}	
	public void SelectDateofBirth(String dateValue) {
		driver.findElement(By.id("dateOfBirthInput")).click(); // to invoke calendar
		String[] date = dateValue.split("-"); // split funkcija koja razdvaja datum, mjesec i godinu
		String day = date[0];
		String month = date[1];
		String year = date[2];
		System.out.println(day);
		System.out.println(month);
		System.out.println(year);
		
		Select selMonth = new Select(driver.findElement(By.className("react-datepicker__month-select")));
		int MonthValue =Integer.valueOf(month);
		selMonth.selectByIndex(MonthValue-1);
		
	}
}
