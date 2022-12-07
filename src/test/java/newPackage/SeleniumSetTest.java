package newPackage;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.bouncycastle.util.Arrays.Iterator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Objects.FacebookPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import methods.Lambdatest;

public class SeleniumSetTest {
	
	WebDriver driver;
	Lambdatest objectrepo;
	
	
	@BeforeTest
	public void setup()throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium webdriver\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.lambdatest.com/selenium-playground/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}
	

	@Test(priority = 1)
	public void verifyPageTitleTest()throws InterruptedException {
    	String title = driver.getTitle();
    	System.out.println("The page title is:" +title);
    	
    	Assert.assertEquals(title, "Selenium Grid Online | Run Selenium Test On Cloud");
    		
	}
	
	@Test(priority =2)
    public void verifyclickOnLink()throws InterruptedException {
    	
		objectrepo = new Lambdatest(driver);
		objectrepo.clickOnLink();
    
  }
	
	@Test(priority = 3)
	public void verifySingleInput()throws InterruptedException {
		objectrepo = new Lambdatest(driver);
		objectrepo.singleInputField();
	}
	
	
	@Test(priority = 4)
	public void verifyTwoInput()throws InterruptedException {
		objectrepo = new Lambdatest(driver);
		objectrepo.twoInputField();
	}
	   
    @AfterTest
    public void tearDown() {
    	driver.quit();
    }
    

}
