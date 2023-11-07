package baseWebsite;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UpdatePOM extends BaseClass {
	
	public UpdatePOM()
	{
		PageFactory.initElements(driver,this);
	}
	Actions ac=new Actions(driver);
	
	@FindBy(id="twotabsearchtextbox") WebElement search;
	public void search() throws InterruptedException
	{
		search.wait(20);
	}
	@FindBy(xpath="/html/body/div[1]/div[1]/div/div[2]/div[2]/a/div/div/div/div[2]/div") WebElement security;
	public void loginsecurtiy()
	{
		security.click();
	}
	@FindBy(id="nav-link-accountList-nav-line-1") WebElement navbar;
	public void navclick()
	{
		ac.moveToElement(navbar).click().build().perform();
		
	}
	@FindBy(xpath="/html/body/div[1]/div[1]/div/div[3]/div[1]/a/div") WebElement account;
	public void account()
	{
		ac.moveToElement(account).click().build().perform();
	}
	@FindBy(id="auth-cnep-edit-name-button")WebElement  editbtn;
	public void btnclick()
	{
		editbtn.click();
	}
	@FindBy(id="ap_customer_name")WebElement  name;
	public void name(String input)
	{
		name.sendKeys(input);
	}
	@FindBy(id="cnep_1C_submit_button")WebElement  subtn;
	public void subbtn()
	{
		subtn.click();
	}
	@FindBy(xpath="/html/body/div[1]/div[1]/div/div/div[1]/div/h4") WebElement msg;
	public String mesg()
	{
		return msg.getText();
	}
	
	public void waitevent1(WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		  wait.until(ExpectedConditions.visibilityOf(element)); }
}
