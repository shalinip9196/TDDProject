package testLayer;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import baseWebsite.BaseClass;
import baseWebsite.LoginPom;
import testdata.InputData;


public class LoginTestNg extends BaseClass{
	
	LoginPom log;
	public  LoginTestNg()
	{
		super();
	}

	
	@BeforeMethod
	public void initialsetup() throws InterruptedException
	{
		
		Initiation();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		Actions ac=new Actions(driver);
		ac.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).click().build().perform();
		 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_email")));
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		log= new LoginPom();
		
		
	} 

@DataProvider 
public Object[][] Details() { Object
  result[][]=InputData.readexcel("Sheet1");  return result; } 
	
	@Test(priority=1 ,dataProvider="Details")
	public void Tc_valid_login(String fname,String lname) throws InterruptedException {
	
	  log.Login(fname);
	  log.buttonclick();
	  log.Paswd(lname); 
	  log.checkboxbtn();
	  log.submitbtn();
	
	  Assert.assertEquals(log.ValidatePageTitle(),"Hello, vignesh");
	} 
	
	@Test
	
	public void Tc_Empty_Username()
	{
		
		log.Login("");
		log.buttonclick();
		
		
		String Alert=log.invalidemail();
		Assert.assertEquals(Alert,  "Enter your e-mail address or mobile phone number");
	}
	@Test
	public void Tc_invalid_Mobile()
	{
		
		log.Login("1");
		log.buttonclick();
			String Alert=log.invalidmobile();
			Assert.assertEquals(Alert,  "We cannot find an account with that mobile number");
		}
		
	
	@Test
	public void Tc_Empty_Passwords()
	{
		
		log.Login("v.vignesh.0811@gmail.com");
		log.buttonclick();
		log.Paswd("");
		 log.checkboxbtn();
		log.submitbtn();
		
		
			String Alert=log.Emptypassword();
			Assert.assertEquals(Alert,"Enter your password");
		
	}

	@Test
	public void Tc_Page_title_Load()
	{
		String title=log.Validatepageload();
		Assert.assertEquals(title, "Amazon Sign In");
	}
	
	@AfterMethod
	public void close()
	{
		driver.close();
	}


}
