package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CreditCardPage extends TestBase{
	
	public CreditCardPage() {
		
		PageFactory.initElements(driver, this);
	}
	@FindBy (xpath = "//nav[@id='nav']/child::a[3]")
	WebElement creditCardBtn;
	
	@FindBy (id = "card_nmuber")
	WebElement cardNumber;
	
	@FindBy (name = "submit")
	WebElement submitBtn;
	
	@FindBy (xpath = "//div[@class='inner']/child::font")
	WebElement creditDetails;
	
	public void checkCreditBalance(String number) {
		creditCardBtn.click();
		cardNumber.sendKeys(number);
		submitBtn.click();
	}
	
	public String creditErrMsg() {
		
		Alert al = driver.switchTo().alert();
		String actualvalue = al.getText();
		System.out.println(al.getText());
		al.accept();
		return actualvalue; 
	}
	
	public String creditCardDetails() {
		
		String acutalError = creditDetails.getText();
		System.out.println(acutalError);
		return acutalError;	
	}

}
