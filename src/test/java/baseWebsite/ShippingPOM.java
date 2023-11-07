package baseWebsite;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShippingPOM extends BaseClass{
	Actions ac=new Actions(driver);
	
	public ShippingPOM()
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(id="twotabsearchtextbox") WebElement searchbox;
	public void search(String text)
	{
		searchbox.sendKeys(text);
	}
	
	@FindBy(id="nav-search-submit-button") WebElement searchlens;
	@FindBy(className="a-price-whole") WebElement wholeprice;
	public void icon()
	{
		searchlens.click();
		
	}
	public WebElement pricedetails()
	{
		return wholeprice;
	}
	public void waitevent1(WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		  wait.until(ExpectedConditions.visibilityOf(element)); }
	
	@FindBy(id="add-to-cart-button") WebElement addcartbutton;
	public void cartadd()
	{
		ac.moveToElement(addcartbutton).click().build().perform();
	}
	
	@FindBy(id="nav-cart-count") WebElement carticon;
	public void linecart()
	{
		carticon.click();
	}
	
	@FindBy (id="sc-subtotal-label-activecart") WebElement cartprice;
	public String cartprice()
	{
		
		return cartprice.getText();
	}
	
	@FindBy(className="sc-price") WebElement labelcartprice;
	public String lablecartprice()
	{
		return labelcartprice.getText();
	}
	@FindBy(id="quantity") WebElement quantitydropdown;
	@FindBy(id="quantity_2") WebElement quantitydropdownoption;
	public void quantityincrease()
	{
		 Select option =new Select(quantitydropdown);
		 option.selectByValue("4");
	}

	@FindBy(xpath="//*[@id='sc-active-22b09133-af76-4344-b6de-cea72f346fd4']/div[4]/div/div[3]/div[1]/span[2]/span/input") WebElement DeleteList;
	public void deletelist()
	{
		DeleteList.click();
	}
	@FindBy(xpath="//*[@id=\"sc-active-cart\"]/div/div/div/h1") WebElement cleancart;
	public String cleancart()
	{
		return cleancart.getText();
	}
	
	@FindBy(css="#sc-active-cart .sc-action-delete input") List<WebElement> deletecontainer;
	public List<WebElement> containerdelete()
	{
		return deletecontainer;
	}
	@FindBy(id="sc-subtotal-amount-buybox") WebElement buybox;
	public String buybox()
	{
		return buybox.getText();
	}
	
}
