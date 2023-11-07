package testLayer;

import java.lang.reflect.InvocationTargetException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseWebsite.BaseClass;
import baseWebsite.LoginPom;
import baseWebsite.ordersPOM;

public class OrderTestNg extends BaseClass {

	ordersPOM orders;
	LoginPom log;

	public OrderTestNg() {
		super();
	}

	@BeforeMethod
	public void initialsetup() throws InterruptedException {

		Initiation();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Actions ac = new Actions(driver);
		ac.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).click().build().perform();

		// orders.waitevent1(driver.findElement(By.id("ap_email")));

		log = new LoginPom();
		orders = new ordersPOM();
		log.Login("dark");

		log.buttonclick();
		log.Paswd("password");
		;
		log.checkboxbtn();
		log.submitbtn();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
		ac.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).click().build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html/body/div[1]/div[1]/div/div[2]/div[1]/a/div/div/div/div[1]/img")));
		ac.moveToElement(
				driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/div[1]/a/div/div/div/div[1]/img")))
				.click().build().perform();
	}

	@Test
	public void Test1() {
		String data1 = orders.OrdersCount();

		Assert.assertEquals(data1, "9 orders");
	}

	@Test
	public void Test2() {
		orders.SelectClick();
		orders.option0();

		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"a-autoid-1-announce\"]/span")));
		String data1 = orders.OrdersCount();
		Assert.assertEquals(data1, "2 orders");
	}

	@Test
	public void Test3() {
		orders.SelectClick();
		orders.option2();

		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"a-autoid-1-announce\"]/span")));
		String data2 = orders.OrdersCount();
		Assert.assertEquals(data2, "7 orders");
	}

	@Test(dependsOnMethods = { "Test3" })

	public void Test4() {

		String data3 = orders.OrderIdTest();
		Assert.assertEquals(data3, "702-5000333-3004215");

	}

	@Test
	public void Test5() {
		boolean orderimage = orders.imageofOrder();
		Assert.assertEquals(orderimage, true);

	}

	@Test
	public void Test6() {
		int sizelist = orders.orderlistcount();

		Assert.assertEquals(sizelist, 9);
	}

	@Test
	public void Test7() { //

		String data4 = orders.cancelledorderlist();
		Assert.assertEquals(data4, "3 cancelled orders");

	}

	@AfterMethod
	public void close() {
		driver.close();
	}

}
