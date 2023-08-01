package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;

import pages.CreditCardPage;

public class CreditCardTest extends TestBase{
	CreditCardPage cp;
	public CreditCardTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initalization();
		cp = new CreditCardPage();
	}
	
	@Test (priority = 1)
	public void checkCreditCardBalance() {
		cp.checkCreditBalance(prop.getProperty("cardNumber"));
		Assert.assertEquals(cp.creditCardDetails(), "Check Credit Balance");
	}
	
	@Test (priority = 2)
	public void checkCreditCardBalanceWithoutDetails() {
		cp.checkCreditBalance("");
		Assert.assertEquals(cp.creditErrMsg(), prop.getProperty("creditErr"));
	}
	
	
	
	
	

}
