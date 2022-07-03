package Com.Test;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Com.Base.BaseClass;
import Com.Pages.LoginPage;
import net.bytebuddy.implementation.bytecode.Throw;

public class LoginTest extends BaseClass {

	LoginPage lp = null;

	@BeforeSuite
	public void setup() throws Exception {
		initialization();
		reportInit();
		lp = new LoginPage(driver);
	}

	@AfterSuite
	public void tearDown() {
		driver.close();
		report.flush();
	}

	@Test
	public void passTest() {
		lp.loginToApplication("kiran@gmail.com","123456");
		Assert.assertEquals(driver.getTitle(),"JavaByKiran | DashBoard");
	}

	@Test
	public void failTest() {
		Assert.assertTrue(true);

	}

	@Test
	public void skipTest() {
		throw new SkipException("Skipping a Test case");

	}
}
