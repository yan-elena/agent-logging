package logger;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import gson.GsonUtils;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 * A custom formatter for logging messages in JSON format using the Gson library.
 */
public class LogFormatter extends Formatter {

    private final Gson gson;

    /**
     * Creates a new instance of {@link LogFormatter}.
     */
    public LogFormatter() {
        this.gson = GsonUtils.createGson();
    }

    @Override
    public String format(LogRecord record) {
        JsonObject object = gson.fromJson(record.getMessage(), JsonObject.class);
        return "[" + record.getMillis() + "] " + object.get("type").getAsString() + ": " + object.get("log").getAsString() + "\n";
    }
}
