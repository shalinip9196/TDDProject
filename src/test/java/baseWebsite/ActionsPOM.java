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

public class ActionsPOM extends BaseClass{
	
	Actions ac=new Actions(driver);
	@FindBy(id="twotabsearchtextbox") WebElement SearchBox;
	@FindBy(xpath="//*[@id=\"a-autoid-0-announce\"]") WebElement SortDropdown;
	@FindBy(id="nav-search-submit-button") WebElement SearchLens;
	@FindBy(className="s-asin") List<WebElement> ProductContainer;
	@FindBy(xpath="//ul[@class='a-nostyle a-list-link']/li[3]/a[@id='s-result-sort-select_2']") WebElement HighToLow;
	@FindBy(id="a-price-whole") List<WebElement>  PriceDetails;
	 @FindBy(xpath="//a[@class='s-pagination-item s-pagination-button' and text()='2']") WebElement Page2;
	 @FindBy(xpath="//li[@id='p_89/Amazon Essentials']") WebElement brandSort;
@FindBy(xpath="//li[@id='p_89/Hanes']") WebElement multiSort;
@FindBy(css="#brandsRefinements > ul > li.a-spacing-micro.s-list-item > span > a") WebElement sortClear;
	public ActionsPOM()
	{
		
		PageFactory.initElements(driver,this);
	}
	
	
	public void waitevent1(WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		  wait.until(ExpectedConditions.visibilityOf(element)); }
public void SearchText() {
		
		SearchBox.sendKeys("Tshirt");
	}

public List<WebElement> priceList()
{
	return PriceDetails;
}

public void  Pagenav()
{
	Page2.click();
}

public String  PageNUm()
{
	return Page2.getText();
}
public List<WebElement> productContainer()
{
	return ProductContainer;
}
public void Sorting()
{
	SortDropdown.click();
}
public void ClearSort()
{
	sortClear.click();
}
public void Searchicon()
{
	SearchLens.click();
}
public void BrandSorting()
{
	brandSort.click();
}
public void MultiSorting()
{
	multiSort.click();
}
public int Productcount() {
	int size=ProductContainer.size();
	return size;
}


public void MovetoSorting()
{
	 ac.moveToElement(SortDropdown).click(). build().perform();
	 
}
public void PriceSorting()
{
	HighToLow.click();
}
}
