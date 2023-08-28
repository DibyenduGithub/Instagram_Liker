package test_cases;

import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Generic_Utility.Base_Class;
import Generic_Utility.Configdata_Utility;

public class Insta_Liker extends Base_Class {

	Actions act;

	@Test
	void like() throws Throwable {
		Configdata_Utility confg = new Configdata_Utility();
		String USERNAME = confg.commondata("username");
		String PASSWORD = confg.commondata("password");
		driver.findElement(By.name("username")).sendKeys(USERNAME);
		Thread.sleep(2000);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(),'Log in')]")).click();
		Thread.sleep(4000);

		WebElement e = driver
				.findElement(By.xpath("//*[local-name()='svg' and @aria-label='Search']/*[local-name()='path']"));
		act = new Actions(driver); // CursorMoveclickAction is Mandatory for this
		act.moveToElement(e).click().build().perform();
		Thread.sleep(5000);

		String TARGETUSER = confg.commondata("targetuser");
		driver.findElement(By.xpath("//input[@aria-label='Search input']")).sendKeys(TARGETUSER);
		Thread.sleep(5000);
		// WebElement name =
		// driver.findElement(By.xpath("//span[contains(text(),'Chitrak Mazumder')]"));

		List<WebElement> names = driver
				.findElements(By.xpath("//span[@class=\"x1lliihq x193iq5w x6ikm8r x10wlt62 xlyipyv xuxw1ft\"]"));
		for (WebElement f : names) {
			if (f.getText().equalsIgnoreCase(TARGETUSER)) {
				f.click();
				break;
			}
		}
		Thread.sleep(7000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,240)", "");
		Thread.sleep(5000);

		List<WebElement> images = driver
				.findElements(By.xpath("//img[@class='x5yr21d xu96u03 x10l6tqk x13vifvy x87ps6o xh8yej3']"));
		Iterator<WebElement> it = images.iterator();
		while (it.hasNext()) {
			// to Iterate each Image প্রত্যেকটা ছবি তে ইটারেট করে ঢোকা
			WebElement img = it.next();
			act.moveToElement(img).click().build().perform();
			Thread.sleep(4000);

			// Like Image
			WebElement like = driver
					.findElement(By.xpath("//*[local-name()='svg' and @aria-label='Like']/*[local-name()='path']"));
			act.moveToElement(like).click().build().perform();
			Thread.sleep(4000);
			// Close Image
			WebElement close = driver.findElement(
					By.xpath("//*[local-name()='svg' and @aria-label='Close']/*[local-name()='polyline']"));
			act.moveToElement(close).click().build().perform();
			Thread.sleep(5000);
		}
	}
}
