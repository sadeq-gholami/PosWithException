package view;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
/**
 * 
 * @author Sadeq
 *this class is responsible for printing the exception messages for the user
 */
public class ExceptionMessagePrinter {

	void printExceptionMessage(String msg) {
		StringBuilder excMessageBuilder = new StringBuilder();
		excMessageBuilder.append(getCurrentTime());
		excMessageBuilder.append("; some error has been accured: \n ");
		excMessageBuilder.append(msg);
		System.out.println(excMessageBuilder);
		
	}
	
	private String getCurrentTime() {
		 DateFormat dateFormate = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	     Date currentDateAndTime = new Date();
	     return dateFormate.format(currentDateAndTime).toString();
	}
}
