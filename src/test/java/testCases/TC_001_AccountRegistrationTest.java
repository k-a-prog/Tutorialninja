package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;



import pageObjects.Accountregpage;
import pageObjects.Homepage;
import testBase.Baseclassdemo;

public class TC_001_AccountRegistrationTest extends Baseclassdemo {
	@Test(groups= {"Regression","Master"})

	public void verify_account_registration()

	{
		logger.info("***** Starting TC001_AccountRegistrationTest  ****");

		logger.debug("This is a debug log message");

		try

		{


		Homepage hp=new Homepage(driver);

		hp.clickMyAccount();

		
		logger.info("Clicked on MyAccount Link.. ");

		hp.clickRegister();

		logger.info("Clicked on Register Link.. ");

		Accountregpage registration=new Accountregpage(driver);
		logger.info("Providing customer details...");

		registration.setFirstName(randomeString().toUpperCase());
		registration.setLastName(randomeString().toUpperCase());
		registration.setEmail(randomeString()+ "@gmail.com");
		registration.setTelephone(randomeNumber());
		String password=randomAlphaNumeric();
		registration.setPassword(password);
		registration.setConfirmPassword(password);
		registration.setPrivacyPolicy();
		registration.clickContinue();
		logger.info("Validating expected message..");
		String confmsg=registration.getConfirmationMsg();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!", "Confirmation message mismatch");
		 
		logger.info("Test passed");

		} 

		catch (Exception e)

		{

			logger.error("Test failed: " + e.getMessage());

			Assert.fail("Test failed: " + e.getMessage());

		} 

		finally 

		{

		logger.info("***** Finished TC001_AccountRegistrationTest *****");

		}

		

	}


 
}
