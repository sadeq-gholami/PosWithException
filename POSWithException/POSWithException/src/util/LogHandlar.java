package util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogHandlar {
    private PrintWriter logFile;
    
    public LogHandlar() throws IOException {
    	FileWriter fileWriter = new FileWriter("POS-log-file.txt");
        logFile = new PrintWriter(fileWriter, true);
    }
    
    /**
     * Prints a log entry for an exception, with some detailed information, in the log file
     * 
     * @param exc The exception that should be printed to the log file
     */
    public void logException(Exception exc) {
        StringBuilder logMsgBuilder = new StringBuilder();
        logMsgBuilder.append(getCurrentTime());
        logMsgBuilder.append("; the following Exception has been accured: \n" +
        					"exception message: ");
        logMsgBuilder.append(exc.getMessage());
        logMsgBuilder.append("\n" + " stack trace: \n");
        logFile.println(logMsgBuilder);
        exc.printStackTrace(logFile);
    }
    private String getCurrentTime() {
		 DateFormat dateFormate = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	     Date currentDateAndTime = new Date();
	     return dateFormate.format(currentDateAndTime).toString();
	}
}
