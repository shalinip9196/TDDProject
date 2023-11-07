package testLayer;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseWebsite.BaseClass;
import baseWebsite.LoginPom;
import baseWebsite.UpdatePOM;

public class UpdatePage extends BaseClass {
	LoginPom log;
	UpdatePOM updated;

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
		updated = new UpdatePOM();
		log.Login("dark");

		log.buttonclick();
		log.Paswd("passwrod#");
		;
		log.checkboxbtn();
		log.submitbtn();
	}

	@Test
	public void UpdateName() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Actions ac = new Actions(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
		updated.navclick();
		// ac.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).click().build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html/body/div[1]/div[1]/div/div[2]/div[1]/a/div/div/div/div[1]/img")));
		// ac.moveToElement(driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/div[2]/a/div/div/div/div[2]/div"))).click().build().perform();

		updated.loginsecurtiy();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("auth-cnep-edit-name-button")));
		updated.btnclick();
		updated.name("ss");
		updated.subbtn();

		Assert.assertEquals(updated.mesg(), "Success");
	}

	@AfterMethod
	public void close() {
		driver.close();
	}

}
