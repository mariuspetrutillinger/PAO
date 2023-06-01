import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AuditLogger {
    private static final String CSV_FILE_PATH = "audit_log.csv";
    private FileWriter fileWriter;

    public AuditLogger() {
        try {
            fileWriter = new FileWriter(CSV_FILE_PATH, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void logAction(String actionName) {
        try {
            String timestamp = getCurrentTimestamp();
            String logEntry = actionName + "," + timestamp + System.lineSeparator();
            fileWriter.write(logEntry);
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getCurrentTimestamp() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date timestamp = new Date();
        return dateFormat.format(timestamp);
    }

    public void closeLogger() {
        try {
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
