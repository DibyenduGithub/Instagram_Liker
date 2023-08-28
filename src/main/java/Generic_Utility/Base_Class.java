package Generic_Utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Base_Class {
	public static WebDriver driver;

	@BeforeTest
	public WebDriver setup() throws Throwable {
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(co);
		Configdata_Utility confg = new Configdata_Utility();
		String URL = confg.commondata("url");
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		return driver;
	}

	@AfterTest
	public void TearDown() {
		System.out.println("Build Success!!");
		driver.close();
	}

}
