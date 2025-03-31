package genericUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class javaUtility {
	/**
	 * This is a generic method to generate random number for a given bound
	 * @param bound
	 */
public int generateRandomNumber(int bound) {
	Random random = new Random();
	int value=random.nextInt(bound);
	return value;
}
/**
 * This is generic method to fetch the Calendar details
 * @param pattern
 * @return
 */
public String getCalendarDetails(String pattern) {
	Calendar calendar = Calendar.getInstance();
	Date date =calendar.getTime();
	SimpleDateFormat sdf=new SimpleDateFormat(pattern);
	String Value= sdf.format(date);
	return Value;
}
}
