package GenericUtility;

import java.util.Date;
import java.text.SimpleDateFormat;

public class JavaUtility 
{
	/**
	 * this class consist of generic  method related to java 
	 * @author = Tushar
	 */
	
	public String getSystemDateInFormat()
	{
		Date d = new Date();
	    SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss");
	    String date = f.format(d);
	    return date;
	}

}
