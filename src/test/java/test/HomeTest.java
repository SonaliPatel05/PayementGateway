package test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import utilities.Testdata;

public class HomeTest extends TestBase{
	HomePage hp;
	
	public HomeTest() {
		super();
	}
	
	@BeforeMethod
	  public void setUp() {
		  initalization();
		   hp = new HomePage();
	  }
	
	@Test (priority = 1)
	public void verifyHeaderList() {
		hp.headerList();
	}
	
	@Test(priority = 2)
	public void verifyProductDetails() {
		hp.checkProductDetails();
	}
	
	@Test(priority = 3)
	public void checkQuantityOfProduct() {
		hp.checkQuantity();
	}
	

}
