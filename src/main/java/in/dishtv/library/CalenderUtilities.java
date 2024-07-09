package in.dishtv.library;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CalenderUtilities {

	public static String dateTime() {
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy 'at' hh-mm-ss a zzz");
		Date date = new Date();
		String Str_Date = dateFormat.format(date);
		return Str_Date;
	}
	
}
