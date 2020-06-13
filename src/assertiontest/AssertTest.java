package assertiontest;

import org.testng.Assert;

public class AssertTest {

	public static void main(String[] args) {
			//Assert.assertTrue(5<4, "Pet nije manje od 4");
		//Assert.assertFalse(5>4, "Greska pet je vece od cetiri.");
		Assert.assertEquals(5, 5, "Rezultat nije Ok");
		Assert.assertEquals(5, 4, "Rezultat nije Ok");
	}

}
