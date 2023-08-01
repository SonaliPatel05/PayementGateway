package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterMethod;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream f = new FileInputStream("C:\\Users\\owner\\Documents\\QA Testing\\wetransfer_eclipse-zip_2023-02-06_1455\\QA"
					+ "\\SeleniumWorkspace\\PaymentGateway\\src\\main\\java\\config\\prop.properties");
		
			prop.load(f);	
		}
		catch(FileNotFoundException e) {
		e.printStackTrace();
		}
		catch(IOException e) {
		e.printStackTrace();
		}
	}
	
public void initalization() {
		
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver_win32\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
		}else if (browserName.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\geckodriver-v0.33.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		} 
		
		driver.get(prop.getProperty("url"));
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	
}
