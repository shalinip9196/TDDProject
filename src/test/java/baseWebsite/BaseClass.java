package baseWebsite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	
	public static Properties prop=new Properties();
	public static WebDriver driver;
	
	
	
	public BaseClass() {
		try
		{
			FileInputStream file=new FileInputStream("C:\\Users\\Shalini\\AMAZON\\src\\test\\java\\environmentalVariables\\Config.properties");
			prop.load(file);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	public static void Initiation()
	{
		
		String browsername= prop.getProperty("browser");
		
		if(browsername.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver","C:\\Users\\Shalini\\AMAZON\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if (browsername.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Shalini\\AMAZON\\chromedriver.exe");
			driver= new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));;
		driver.get(prop.getProperty("url"));	
		

}
	public static void screenshots(String Filename) throws InterruptedException
	{
		File srcfile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
		FileUtils.copyFile(srcfile, new File("C:\\Users\\Shalini\\AMAZON\\src\\test\\java\\screenshot\\screenshots"+Filename+".jpg"));
		Thread.sleep(Duration.ofSeconds(20));
		}catch(IOException io)
		{
			io.printStackTrace();
		}
	}
	
}
