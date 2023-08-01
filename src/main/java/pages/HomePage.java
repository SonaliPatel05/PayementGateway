package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;

public class HomePage extends TestBase{
	
	public HomePage() {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//div[@class='inner']/child::nav/child::a")
	List<WebElement> header;
	
	@FindBy (name = "quantity")
	WebElement quantity;
	
	@FindBy (xpath = "//input[@type='submit']")
	WebElement BuyNow;
	
	@FindBy (xpath = "//div[@class='6u 12u$(small)']/child::ul/child::li")
	List<WebElement> productDetails;
	
	public void headerList() {
		List<WebElement> list = header;
		
		for(WebElement e : list) {
			System.out.println(e.getText());
		}
	}
	
	public void checkQuantity() {
		Select box = new Select(quantity);
		box.selectByValue("3");
		BuyNow.click();
	}
	
	public void checkProductDetails() {
		List<WebElement> product = productDetails;
		
		for(WebElement t : product) {
			System.out.println(t.getText());
		}
	}
	
	

}
