package testLayer;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import baseWebsite.BaseClass;
import baseWebsite.LoginPom;
import baseWebsite.ShippingPOM;
import testdata.InputData;

public class Shoppingcart extends BaseClass {
	WebElement wm;
	LoginPom log;

	ShippingPOM ship;

	public Shoppingcart() {
		super();
	}

	@BeforeMethod
	public void initialsetup() throws InterruptedException {

		Initiation();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		Actions ac = new Actions(driver);
		ac.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).click().build().perform();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_email")));

		log = new LoginPom();
		ship = new ShippingPOM();
		log.Login("v.vignesh.0811@gmail.com");

		log.buttonclick();
		log.Paswd("Fresh@@1996");
		log.checkboxbtn();
		log.submitbtn();

	}

	@Test
	public void additems() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		ship.search("iphone 12 case");
		ship.icon();
		// ship.waitevent1(ship.pricedetails());

		// click on product
		driver.get(
				"https://www.amazon.ca/JETech-iPhone-6-1-Inch-Shockproof-Anti-Scratch/dp/B07QS4NMW6/ref=sr_1_1_sspa?crid=WBC2D3X64YW0&keywords=iphone+12+case&qid=1698873167&sprefix=iphone+12+case%2Caps%2C209&sr=8-1-spons&sp_csd=d2lkZ2V0TmFtZT1zcF9hdGY&psc=1");

		wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button")));

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20)); // click
		// on cart
		ship.linecart();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

		Assert.assertEquals(ship.cartprice(), "Subtotal (1 item):");
		// countprice

		Assert.assertEquals(ship.lablecartprice(), "$11.04");

	}

	@Test public void itemQuantitytest() {
	  
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	  ship.search("towels large"); 
	  ship.icon();
		
		  ship.waitevent1(ship.pricedetails()); // driver.get(
		  "https://www.amazon.ca/Polyte-Professional-Quick-Microfiber-Drying/dp/B07NVWR2R7/ref=sr_1_1_sspa?crid=2L58G9VSYB6IM&keywords=towles+large&qid=1698878484&sprefix=towles+large%2Caps%2C231&sr=8-1-spons&sp_csd=d2lkZ2V0TmFtZT1zcF9hdGY&psc=1"
		  ); ship.quantityincrease();
		  
		  ship.cartadd(); wait.until(ExpectedConditions
		  .visibilityOfElementLocated(By.xpath(
		  "//*[@id=\"sw-atc-details-single-container\"]"))); ship.linecart();
		  System.out.println("cart clicked"); // check quantity increased
		  Assert.assertEquals(ship.cartprice(), "Subtotal (5 items):");
		  Assert.assertEquals(ship.lablecartprice(), "$113.24");
		 
	  }

	@Test
	public void removeitemsfromcart() {
		ship.linecart();

		ship.deletelist();
		Assert.assertEquals(ship.cleancart(), "Your Amazon Cart is empty.");
	}

	@Test
	public void deleteallitems() {
		ship.linecart();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		List<WebElement> cartList = ship.containerdelete();

		while (cartList.size() > 0) {
			WebElement item = cartList.get(0);
			item.click();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
			cartList = ship.containerdelete();
		}

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

		Assert.assertEquals(ship.cleancart(), "Your Amazon Cart is empty.");

	}

	@AfterMethod
	public void close() {
		driver.close();
	}

}
