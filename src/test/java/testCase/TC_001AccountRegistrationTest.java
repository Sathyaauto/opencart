package testCase;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001AccountRegistrationTest extends BaseClass {
	public WebDriver driver;
	@BeforeClass(groups={"Regression","Master"})
	public void setup()
	{
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();//deletes all coolies from browser.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://tutorialsninja.com/demo/");	
		driver.manage().window().maximize();
	}
	@AfterClass
	public void teardown()
	
	{
		
		driver.close();
	}
	
	@Test 
	public void test_accountRegistration()
	{
		logger.info("*****starting TC_001AccountRegistrationTest******"  );
		HomePage hp=new HomePage(driver);
		logger.info("Clicking on my login a/c");
		hp.clickMyAccount();
		hp.clickRegister();
		logger.info("Clicking on my register a/c");
		AccountRegistrationPage rp=new AccountRegistrationPage(driver);
		/*rp.setfirstname("sath");
		rp.setlastname("Bala");
		rp.setemail("sd@gmail.com");
		rp.setpassword("done");
		rp.setconfirmpassword("done");
		rp.settelephone("212121");
		rp.setclickprivacypolicy();
		rp.setclickcontinue();
		String confmsg=rp.getConfirmationMsg();
		Assert.assertEquals(confmsg,"Your account has been successfully updated");*/
		
		// Dynamic Value
		logger.info("providing customer details");
		rp.setfirstname(randomeString().toUpperCase());
		rp.setlastname(randomeString().toUpperCase());
		rp.setemail(randomeString()+"@gmail.com");
		String password=randomeString();
		rp.setpassword("password");
		rp.setconfirmpassword("password");
		rp.settelephone("randomeNumber()");
		rp.setclickprivacypolicy();
		rp.setclickcontinue();
		String confmsg=rp.getConfirmationMsg();
		//Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		if (confmsg.equals("Your Account Has Been Created!"))
		{
			logger.info("Login Suuccessfull");
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("Registration Failed");
			Assert.fail();
		
	}

	}
}