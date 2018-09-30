package form16;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class timeconventor {
	
	public static void main(String[] args) throws Exception {
	    String today = "21/12/2007";

	    DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	    Date date = formatter.parse(today);
	    long dateInLong = date.getTime();

	    System.out.println("date = " + date);
	    System.out.println("dateInLong = " + dateInLong);
	  }
	

}
