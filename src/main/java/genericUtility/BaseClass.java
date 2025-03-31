package genericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import POM_class.HomePage;
import POM_class.LoginPage;

public class BaseClass {

	public WebDriver driver;
//	public static WebDriver sDriver;
	public SeleniumUtility sUtil=new SeleniumUtility();
	public propertiesUtility pUtil=new propertiesUtility();
	public ExcelUtility eUtil=new ExcelUtility();
	//For making WebDriver reference variable as thread safe
	public static ThreadLocal<WebDriver> driverInstance=new ThreadLocal<>();
	

	@BeforeSuite(alwaysRun=true)
	public void dbConnection()
	{
		System.out.println("DB connection created");
	}
	@Parameters("browser")
	@BeforeClass(alwaysRun=true)
	public void launchBrowser(@Optional("chrome")String Browser) throws Exception{
	
		if(Browser.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(Browser.equals("edge")) {
			driver=new EdgeDriver();
		}
		else {
			driver=new ChromeDriver();
		}
		//sDriver=driver;             // initializing static driver for listener
		setDriver(driver);  // used in listeners for screenshot for making driver as thread safe in parallel execution
		sUtil.maximizeWindow(driver);
		sUtil.implicitWait(driver,15);
		String URL=pUtil.getDataFRomPropertiesFile("url");
		sUtil.navigateToApplication(driver, URL);
		System.out.println("Browser launched successfully");
	}
	@BeforeMethod(alwaysRun=true)
     public void loginOperation()throws Exception{
		String URL=pUtil.getDataFRomPropertiesFile("username");
		String PWD=pUtil.getDataFRomPropertiesFile("password");
		LoginPage lp=new LoginPage(driver);
		lp.loginToApplication(URL, PWD);
		System.out.println("Login done successfully");
	}
     @AfterMethod(alwaysRun=true)
     public void logoutOperation()
     {
    	 HomePage hp = new HomePage(driver);
    	 hp.signOutOperation(driver);
    	 System.out.println("logout done sucessfully");
     }
	@AfterClass(alwaysRun=true)
	public void closeBrowser() {
		driver.quit();
		System.out.println("Browser closed sucessfully");
		
	}
    @AfterSuite(alwaysRun=true)
    public void closeDBConnection() {
    	System.out.println("DB connection closed");
    }
    
    //Sets the current thread's copy of this thread-local variable to the specified value
    public static void setDriver(WebDriver driver) {
    	driverInstance.set(driver);
    	
    }
    
    //Returns the value in the current thread's copy of this thread-local variable
    public static WebDriver getDriver() {
    	return driverInstance.get();
    }
}
