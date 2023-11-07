package testLayer;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseWebsite.BaseClass;
import baseWebsite.LoginPom;

public class OrderTest extends BaseClass {
	
	LoginPom log;
	
	public  OrderTest()
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
		
		log.Login("dark");
		
	  log.buttonclick();
	  log.Paswd("password");; 
	  log.checkboxbtn();
		 log.submitbtn();
		// WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
			 ac.moveToElement(driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/span"))).click().build().perform();
			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div/div[2]/div[1]/a/div/div/div/div[1]/img")));
			 ac.moveToElement(driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/div[1]/a/div/div/div/div[1]/img"))).click().build().perform();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"a-autoid-1-announce\"]/span"))); 
		
		
	} 
	@Test
public void Test1() {
			
			String data=driver.findElement(By.xpath("/html/body/div[1]/section/div[1]/div[4]/form/label/span")).getText();
			Assert.assertEquals(data, "9 orders");
}
	@Test
public void Test2() {	
				 WebElement spandropdown=driver.findElement(By.xpath("//*[@id=\"a-autoid-1-announce\"]"));
			
			spandropdown.click();
			WebElement dropdownValue = driver.findElement(By.id("time-filter_0"));
			
			dropdownValue.click();
			 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"a-autoid-1-announce\"]/span")));
		String data1=driver.findElement(By.xpath("/html/body/div[1]/section/div/div[4]/form/label/span")).getText();
		Assert.assertEquals(data1, "2 orders");
	}

}
