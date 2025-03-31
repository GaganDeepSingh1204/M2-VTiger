package Sample;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestNGPratice {
	@Test(priority = 1,invocationCount=3 )
	public void createUser()
	{
     System.out.println("User Created");
	}
	@Test(priority = 2,dependsOnMethods= {"createUser"})
	public void modifyUser()
	{
		System.out.println("User Modified");
	}
  @Ignore
  @Test(priority=3)
  public void deleteUser()
  {
	  System.out.println("User Deleted");
  }
}
