package testLayer;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import baseWebsite.AddressPOM;
import baseWebsite.BaseClass;
import baseWebsite.LoginPom;
import testdata.InputData;

public class AddressTestng extends BaseClass {

	LoginPom log;
	AddressPOM add;

	public AddressTestng() {
		super();
	}

	@DataProvider
	public Object[][] Details() {
		Object result[][] = InputData.readexcel("Sheet1");
		return result;
	}

	@BeforeMethod
	@Test
	public void initialsetup() throws InterruptedException {

		Initiation();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		Actions ac = new Actions(driver);
		ac.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).click().build().perform();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_email")));

		log = new LoginPom();
		add = new AddressPOM();
		log.Login("dark");

		log.buttonclick();
		log.Paswd("Passwrod#");
		;
		log.checkboxbtn();
		log.submitbtn();

		// WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		add.naviagetion();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div/div[3]/div[1]/a/div")));
		add.accounttab();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html/body/div[1]/div[1]/div/div[2]/div[1]/div[1]/a/div/div/h2")));
		add.addresstab();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"a-page\"]/div[1]/div/div[2]/h2")));

	}

	@Test
	public void openpage() {

		Assert.assertEquals(add.dropdowncheck(), "Canada");
	}

	@Test(dataProvider = "Details")
	public void Tc_Address(String name1, String address11, String address21, String city1, String postal1)
			throws InterruptedException {

		add.name(name1);
		add.phone("778772");
		add.add1(address11);
		add.add2(address21);
		add.city(city1);
		add.post(postal1);

		add.regindrop();
		Thread.sleep(1000);
		add.suggestesdsave();
		add.btnclick();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div/div[2]/div/h4")));
		WebElement msg = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/div/h4"));
		Assert.assertEquals(msg.getText(), "Address saved");
	}

	@Test
	public void Tc_delete() {

		driver.navigate().back();
		add.addressdeletebtn();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.alertIsPresent());

		Alert ae = driver.switchTo().alert();
		ae.accept();

		Assert.assertEquals(add.deletemsg(), "Address deleted");

	}

	@AfterMethod
	public void close() {
		driver.close();
	}

}
