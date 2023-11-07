package baseWebsite;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPom extends BaseClass{

	@FindBy(id="ap_email") WebElement email;
	@FindBy(id="continue") WebElement btn_continue;
	@FindBy(id="ap_password") WebElement pwd;
	@FindBy(id="signInSubmit") WebElement btn_signup;
	@FindBy(name="rememberMe") WebElement findme;

	@FindBy(id="nav-link-accountList-nav-line-1") WebElement logo;
	@FindBy(xpath="//*[@id=\"auth-email-missing-alert\"]/div/div") WebElement invalidEmailAlert;
	@FindBy(xpath="//*[@id=\"auth-error-message-box\"]/div/div/ul/li/span") WebElement invalidmobile;
	
	@FindBy(xpath="//*[@id=\"auth-password-missing-alert\"]/div/div") WebElement emptypassword;
	public LoginPom()
	{
		PageFactory.initElements(driver,this);
	}
	public void Login(String useremail)
	{
		email.sendKeys(useremail);
		
	}
	public void Paswd(String pass)
	{
		pwd.sendKeys(pass);
	}
	public void buttonclick() {
		btn_continue.click(); }
	public void checkboxbtn()
	{
		findme.click();
	}
	public void submitbtn()
	{
		btn_signup.click();
	}
	public String verify()
	{
		return driver.getTitle();
	}
	public String ValidatePageTitle()
	{
		
		String value1=logo.getText();
		return value1;
		
	}
	public String invalidemail()
	{
		String alert=invalidEmailAlert.getText();
		return alert;
	}
 public String Emptypassword()
	{
		String alert=emptypassword.getText();
		return alert;
	}
 
  public String invalidmobile()
	{
		String alert=invalidmobile.getText();
		return alert;
	}
 
	public String Validatepageload()
	{
		String value=driver.getTitle();
		return value;
	}
	

}
