package baseWebsite;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddressPOM extends BaseClass{
	
	Actions ac=new Actions(driver);
	
	
	@FindBy(id="address-ui-widgets-enterAddressFullName") WebElement name;
	@FindBy(id="address-ui-widgets-enterAddressPhoneNumber") WebElement phone;
	@FindBy(id="address-ui-widgets-enterAddressLine1") WebElement address1;
	@FindBy(id="address-ui-widgets-enterAddressLine2") WebElement address2;
	@FindBy(id="address-ui-widgets-enterAddressCity") WebElement city;
	@FindBy(id="address-ui-widgets-enterAddressPostalCode") WebElement postal;
	@FindBy(id="address-ui-widgets-enterAddressStateOrRegion") WebElement regiondropdown;
	@FindBy(id="address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId_1") WebElement regionid;
	@FindBy(id="address-ui-widgets-use-as-my-default") WebElement defaultehck;
	@FindBy(id="address-ui-widgets-form-submit-button")WebElement btn;
	@FindBy(xpath="//a[@id='ya-myab-address-delete-btn-10']") WebElement deletebtn;
	@FindBy(id="nav-link-accountList-nav-line-1") WebElement logoline;
	@FindBy(xpath="/html/body/div[1]/div[1]/div/div[3]/div[1]/a/div") WebElement account;
	
	@FindBy(xpath="/html/body/div[1]/div[1]/div/div[2]/div[1]/div[1]/a/div/div/h2") WebElement Addresstab;
	@FindBy(xpath="/html/body/div[1]/div[1]/div/div[2]/form/span/div/div[1]/div/div[2]/span/span/span/span") WebElement countrydropdown;
	@FindBy(xpath="//*[@id=\"address-ui-widgets-countryCode\"]/span/span/span") WebElement defaultcounty;
	@FindBy(xpath="//*[@id=\"a-autoid-2\"]") WebElement suggestedbtn;
	@FindBy (xpath="/html/body/div[1]/div[1]/div/div[2]/div/h4") WebElement addressdeletemsg;
	public AddressPOM()
	{
		PageFactory.initElements(driver,this);
	}
	public void regindrop()
	{
		regiondropdown.click();
		regionid.click();
		btn.click();
	}
	public void addressdeletebtn()
	{
		deletebtn.click();
	}
	public void suggestesdsave()
			{
		suggestedbtn.click();
			}
	public void name(String name1)
	{
		name.sendKeys(name1);
		
	}
	public void phone(String phone1)
	{
		phone.sendKeys(phone1);;
	}public void add1(String address11  )
	{
		address1.sendKeys(address11);
	}public void add2(String address21 )
	{
		address2.sendKeys( address21);
	}public void city(String city1)
	{
		city.sendKeys(city1);
	}public void post(String postal1)
	{
		postal.sendKeys(postal1);
	}
	public void btnclick()
	{
		btn.click();
	}
	public void naviagetion()
	{
			
	ac.moveToElement(logoline).click().build().perform();
	}
	public void accounttab()
	{
		ac.moveToElement(account).click().build().perform();
	}
	public void addresstab()
	{

	ac.moveToElement(Addresstab).click().build().perform();
	}
	public String deletemsg()
	{
		return addressdeletemsg.getText();
	}
	
	public String dropdowncheck()
	{
		return defaultcounty.getText();
	}
	
	public void waitevent1(WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		  wait.until(ExpectedConditions.visibilityOf(element)); }
	
}
