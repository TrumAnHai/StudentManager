/**
 * 
 */
package bin;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

/**
 * @author Heretic
 *
 * UNSC
 */
public class DateTranform {
	public static String convertDateToString(Date _date){
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String strDate = dateFormat.format(_date);
		return strDate;
	}
	
	public static Date convertStringToDate(String sDate) {
		 DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		        Date date = null;
		        try {
		            date = new Date(dateFormat.parse(sDate).getTime());
		        } catch (Exception e) {
		            JOptionPane.showMessageDialog(null, "Date Register Incorect..!");
		            e.printStackTrace();
		        }
		        return date;
		    }
}
