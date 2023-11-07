package testLayer;

import java.time.Duration;
import java.util.ArrayList;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import baseWebsite.ActionsPOM;
import baseWebsite.BaseClass;
import baseWebsite.LoginPom;

public class AmazonActions extends BaseClass {
	WebElement wm;
	LoginPom log;
	ActionsPOM amazonfun;

	public AmazonActions() {
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
		amazonfun = new ActionsPOM();
		
		log.Login("dark");

		log.buttonclick();
		log.Paswd("passwrod#");
		log.checkboxbtn();
		log.submitbtn();

	}

	@BeforeMethod
	public void ProductSearch() {
		amazonfun.SearchText();
		amazonfun.Searchicon();
		amazonfun.waitevent1(driver.findElement(By.className("s-asin")));
	}

	@Test
	public void Search() {
		amazonfun.SearchText();
		amazonfun.Searchicon();
		amazonfun.waitevent1(driver.findElement(By.className("s-asin")));
		Assert.assertEquals(amazonfun.Productcount(), 60);

	}

	@Test
	public void sort() {
		amazonfun.SearchText();
		amazonfun.Searchicon();
		amazonfun.waitevent1(driver.findElement(By.className("s-asin")));

		amazonfun.MovetoSorting();
		amazonfun.waitevent1(driver.findElement(By.xpath("//*[@id=\"a-autoid-0-announce\"]")));
		amazonfun.PriceSorting();
		amazonfun.waitevent1(driver.findElement(By.className("a-price-whole")));
		List<WebElement> prod = amazonfun.productContainer();

		ArrayList<String> prodprice = new ArrayList<String>();

		for (int i = 0; i < prod.size(); i++) {

			WebElement proditem = prod.get(i);
			List<WebElement> check = proditem.findElements(By.className("a-price-whole"));
			if (check.size() > 0) {
				String price = check.get(0).getText();
				System.out.println("price list" + price);
				prodprice.add((price));
			}
		}

		Assert.assertEquals(prodprice.get(0).toString(), "4,753");

	}

	@Test // pagination
	public void pagination() {

		amazonfun.SearchText();
		amazonfun.Searchicon();
		amazonfun.waitevent1(
				driver.findElement(By.xpath("//a[@class='s-pagination-item s-pagination-button' and text()='2']")));

		amazonfun.waitevent1(
				driver.findElement(By.xpath("//a[@class='s-pagination-item s-pagination-button' and text()='2']")));

		amazonfun.Pagenav();
		Assert.assertEquals(amazonfun.PageNUm(), "2");
	}

	@SuppressWarnings("unlikely-arg-type")

	@Test
	public void duplicate() {

		List<WebElement> prod = amazonfun.productContainer();

		boolean duplicate = false; // duplicate element amazonfun.Pagenav();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		List<WebElement> page2 = amazonfun.productContainer();
		List<String> urlduplicate = new ArrayList<String>();

		for (int i = 0; i < prod.size(); i++) {

			if (prod.contains(page2)) {
				duplicate = true;

				String url = page2.get(i).getAttribute("href").toString();
				urlduplicate.add(url);

			}

		}
		if (urlduplicate.size() > 0) {
			duplicate = true;
		}
		System.out.println(duplicate); // pagination dupllcaite check
		Assert.assertEquals(duplicate, false);
	}

	@Test
	public void multiplefilters() {

		amazonfun.SearchText();
		amazonfun.Searchicon();
		amazonfun.waitevent1(driver.findElement(By.className("s-asin")));
		amazonfun.BrandSorting();
		amazonfun.MultiSorting();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		amazonfun.ClearSort();
	}

	@Test
	public void filters() {
		amazonfun.SearchText();
		amazonfun.Searchicon();
		amazonfun.waitevent1(driver.findElement(By.className("s-asin")));
		amazonfun.BrandSorting();
		amazonfun.waitevent1(driver.findElement(By.className("s-asin")));

		List<WebElement> prod1 = amazonfun.productContainer();
		String result = "Amazon Essentials";
		Assert.assertTrue(prod1.get(0).getText().contains(result));
	}

	@AfterMethod
	public void close() {
		driver.close();
	}

}
