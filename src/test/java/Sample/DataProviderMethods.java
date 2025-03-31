package Sample;

import java.util.HashMap;

import org.testng.annotations.DataProvider;

public class DataProviderMethods {

	 @DataProvider(name="getDataHashMap")
	 public Object[][] loginCredentials2()
	 {
		 HashMap<String,String> m1=new HashMap<>();
		 m1.put("username", "admin");
		 m1.put("password", "admin");
			
		 HashMap<String,String> m2=new HashMap<>();
		 m2.put("username", "admin123");
		 m2.put("password", "admin456");
		 
		 return new Object[][] {{m1},{m2}};
	 }
}
