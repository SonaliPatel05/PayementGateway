package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;

import pages.HomePage;
import pages.PaymentPage;
import utilities.Testdata;

public class PaymentTest extends TestBase{
	PaymentPage pg;
	HomePage hp;
	
	public PaymentTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initalization();
		pg = new PaymentPage();
		hp = new HomePage();
	}
	
	@Test (priority = 1)
	public void verifyCardDetails() {
		hp.checkQuantity();
		pg.fillDetails(prop.getProperty("cardNumber"), prop.getProperty("expiryMonth"), prop.getProperty("expiryYear"), prop.getProperty("cvvCode"));
		Assert.assertEquals(pg.paymentSuccessfull(), "Payment successfull!");
	}
	
	@Test(priority = 2)
	public void verifyCardwithWrongDetails() {
		hp.checkQuantity();
		pg.popupErrorMsg(prop.getProperty("wrongCardNumeric"));
		Assert.assertEquals(pg.cardErrNumeric(), "Check card number is 16 digits!");
	}
	
	@Test(priority = 3)
	public void verifyCvvNumber() {
		hp.checkQuantity();
		pg.fillDetails(prop.getProperty("cardNumber"), prop.getProperty("expiryMonth"), prop.getProperty("expiryYear"), prop.getProperty("cvvChar"));
		Assert.assertEquals(pg.cvvErrMsg(), prop.getProperty("cardErrorChar"));
	}

}
