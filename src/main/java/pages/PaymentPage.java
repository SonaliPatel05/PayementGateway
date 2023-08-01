package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;

public class PaymentPage extends TestBase{
	
	public PaymentPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (id = "card_nmuber")
	WebElement cardNumber;
	
	@FindBy (id = "month")
	WebElement expiryMonth;
	
	@FindBy (id = "year")
	WebElement expiryYear;
	
	@FindBy (id = "cvv_code")
	WebElement cvvCode;
	
	@FindBy (name = "submit")
	WebElement payNow;
	
	@FindBy (id = "message1")
	WebElement cardError;
	
	@FindBy (id = "message2")
	WebElement cvvError;
	
	@FindBy (xpath = "//h2[contains(text(),'Payment successfull!')]")
	WebElement paymentSuccess;
	
	public void fillDetails(String cardnumber, String e_month, String e_year, String cvvNumber) {
		
		cardNumber.sendKeys(cardnumber);
		Select box = new Select(expiryMonth);
		Select box1 = new Select(expiryYear);
		box.selectByValue("5");
		box1.selectByValue("2022");
		cvvCode.sendKeys(cvvNumber);
		payNow.click();	
	}
	
	public String cardErrMsg() {
		
		String acutalError = cardError.getText();
		System.out.println(acutalError);
		return acutalError;	
	}
	
	public String paymentSuccessfull() {
		
		String acutalError = paymentSuccess.getText();
		System.out.println(acutalError);
		return acutalError;	
	}
	
	public void popupErrorMsg(String number) {
		
		cardNumber.sendKeys(number);
		Select box = new Select(expiryMonth);
		Select box1 = new Select(expiryYear);
		box.selectByValue("5");
		box1.selectByValue("2022");
		payNow.click(); 
	}
	
	public String cvvErrMsg() {
		
		String acutalError = cvvError.getText();
		System.out.println(acutalError);
		return acutalError;	
	}
	
	public String cardErrNumeric() {
		
		Alert al = driver.switchTo().alert();
		String actualvalue = al.getText();
		System.out.println(al.getText());
		al.accept();
		return actualvalue;
		
			
	}
}

