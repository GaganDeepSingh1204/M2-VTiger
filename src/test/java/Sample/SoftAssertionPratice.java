package Sample;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertionPratice {
@Test
public void strictLevelComparison() {
	String expectedName="Binod";
	String actualName="Bino";
	SoftAssert s=new SoftAssert();
	s.assertTrue(actualName.equals(expectedName));
	System.out.println("Soft assertion strict level completed");
	s.assertAll();
}
@Test
public void containsLevelComparison() {
	String a1="hel";
	String a2 ="hello";
	SoftAssert s = new SoftAssert();
	s.assertEquals(a2.contains(a1), true);
	s.assertAll();
	System.out.println("Soft assertion contains level completed");
}
}
