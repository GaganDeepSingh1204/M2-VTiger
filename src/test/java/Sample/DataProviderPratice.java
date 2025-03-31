package Sample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import POM_class.LoginPage;
import genericUtility.SeleniumUtility;

public class DataProviderPratice {
//@Test(dataProvider="getDataHashMap",dataProviderClass=DataProviderMethods.class)
@Test(dataProvider="getData")
//public void practice(HashMap<String,String>m)
public void pratice(String UN,String PWD) throws InterruptedException
{
	WebDriver driver = new ChromeDriver();
	SeleniumUtility sUtil=new SeleniumUtility();
	sUtil.maximizeWindow(driver);
	sUtil.navigateToApplication(driver, "http://localhost:8888/");
	LoginPage lp=new LoginPage(driver);
//	System.out.println(m.get("username"));
//	System.out.println(m.get("password"));
//	String UN=m.get("username");
//	String PWD=m.get("password");
    lp.loginToApplication(UN,PWD);
    Thread.sleep(2000);
    driver.quit();
}

   @DataProvider(name="getData")
   public Object[][] loginCredentials()
   {
	   return new Object[][] {{"admin","admin"},{"admin123456","admin45678"}};
}
}
