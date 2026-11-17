package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;



import pageObjects.Homepage;
import pageObjects.Loginpage;
import pageObjects.Myaccountpage;
import testBase.Baseclassdemo;
import utility.DataProviders;

public class TC_003_LoginDDT extends Baseclassdemo {
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)

	public void verify_loginDDT(String email, String password, String exp)

	{

		logger.info("**** Starting TC_003_LoginDDT *****");

		try {

		//Home page

			Homepage hp=new Homepage(driver);

			hp.clickMyAccount();

			hp.clickLogin(); //Login link under MyAccount

			//Login page

			Loginpage lp=new Loginpage(driver);

			lp.setEmail(email);

			lp.setPassword(password);

			lp.clickLogin(); //Login button

			//My Account Page

			Myaccountpage macc=new Myaccountpage(driver);

			boolean targetPage=macc.isMyAccountPageExists();

			if(exp.equalsIgnoreCase("Valid"))

			{

				if(targetPage==true)

				{

					macc.clickLogout();

					Assert.assertTrue(true);

				}

				else

				{

					Assert.assertTrue(false);

				}

			}

			if(exp.equalsIgnoreCase("Invalid"))

			{

				if(targetPage==true)

				{

					macc.clickLogout();

					Assert.assertTrue(false);

				}

				else

				{

					Assert.assertTrue(true);

				}

			}

		}

		catch(Exception e)

		{

			Assert.fail("An exception occurred: " + e.getMessage());

		}

		logger.info("**** Finished TC_003_LoginDDT *****");

	}

 
}
