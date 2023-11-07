package baseWebsite;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.opentelemetry.api.internal.StringUtils;

public class ordersPOM extends BaseClass {
	
	Actions ac=new Actions(driver);
	 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	
	@FindBy() WebElement startwait;
	@FindBy(id="nav-link-accountList-nav-line-1") WebElement navigate;
	@FindBy(xpath="//*[@id=\"nav-link-accountList\"]/span") WebElement accountList;
	@FindBy(id="twotabsearchtextbox") WebElement search;
	@FindBy(xpath="/html/body/div[1]/div[1]/div/div[2]/div[1]/a/div/div/div/div[1]/img") WebElement ordertab;
	@FindBy(xpath="/html/body/div[1]/section/div[1]/div[4]/form/label/span") WebElement orderList;
	@FindBy(xpath="//*[@id=\"a-autoid-1-announce\"]") WebElement orderdropdown;
	@FindBy(id="time-filter_0") WebElement dropdownoption0;
	
	@FindBy(xpath="/html/body/div[1]/section/div[1]/div[4]/form/label/span") WebElement Message1;
	@FindBy(id="time-filter_3") WebElement dropdownoption2;
	@FindBy(xpath="/html/body/div[1]/section/div/div[4]/form/label/span") WebElement Message2;
	@FindBy(xpath="/html/body/div[1]/section/div/div[9]/div/div[1]/div/div/div/div[2]/div[1]/span[2]/bdi") WebElement Orderid1;
	@FindBy(xpath="/html/body/div[1]/section/div/div[9]/div/div[2]/div/div/div/div[1]/div/div/div/div[1]/div/a/img")WebElement  Orderimag1;
	@FindBy(xpath="/html/body/div[1]/div[1]/div/div[2]/div[1]/a/div/div/div/div[1]/img")WebElement ordertabimage;
	@FindBy(className="order-card") List<WebElement> OderList;
	@FindBy(xpath="/html/body/div[1]/section/div/div[3]/ul/li[4]")WebElement cancelledorderslist;
	@FindBy(xpath="/html/body/div[1]/div[1]/div[1]/div[4]/div[2]/label/span")WebElement canceledMessage;
	
	
	
	
	
	public ordersPOM()
	{
		
		PageFactory.initElements(driver,this);
	}
	
	
	 public void waitevent1(WebElement element) {
	  
	  wait.until(ExpectedConditions.visibilityOf(element)); } 
	 
	 
	 public void navabar()
	  {
	  
	  ac.moveToElement(navigate).click().build().perform(); } public void
	  navabaraccountlist() {
	  
	  ac.moveToElement(accountList).click().build().perform(); }
	 
	
	  public void navordertab() {
	  
	  ac.moveToElement(ordertabimage).click().build().perform(); }
	 
	public String OrdersCount() {
		String data=Message1.getText();
		return data;
	}

	
	  public void navabarlist() {
	  
	  ac.moveToElement(cancelledorderslist).click().build().perform(); }
	 
	public void SelectClick() {
		
		orderdropdown.click();
	}
		 
			
//orderList.click(); }
	
	public void option0()
	{
		dropdownoption0.click();
	}
	public void option2()
	{
		dropdownoption2.click();
	}
	public boolean imageofOrder()
	{
		boolean imagesho=Orderimag1.isDisplayed();
		return imagesho;
	}
	public String OrderIdTest() {
		wait.until(ExpectedConditions.visibilityOf(Orderid1));
		String Id=Orderid1.getText();
		return Id;
	}
	public String cancelledorderlist() {
		String message3=canceledMessage.getText();
		return message3;
	}
	
	public int orderlistcount() {
		int size=OderList.size();
		return size;
	}
	
	
	
			
	
	
	
	
	
	
	
}
