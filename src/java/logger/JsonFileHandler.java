package logger;

import com.google.gson.*;
import gson.GsonUtils;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

/**
 * A class that is responsible for handling logging information by writing it to a JSON file.
 */
public class JsonFileHandler extends Handler {

    private static final String PATH = "log/";
    private final Gson gson;
    private final String filename;
    private PrintWriter writer;
    private final JsonArray jsonArray;

    /**
     * Creates a new instance of {@link JsonFileHandler} with the specified filename.
     * @param filename the name of the file to save the log
     */
    public JsonFileHandler(String filename) {
        this.gson = GsonUtils.createGson();
        this.jsonArray = new JsonArray();
        this.filename = filename;
    }

    @Override
    public synchronized void publish(LogRecord record) {
        try {
            this.writer = new PrintWriter(PATH + filename + ".json");
            this.jsonArray.add(gson.toJsonTree(record));
            this.writer.println(gson.toJson(jsonArray));
            flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public synchronized void flush() {
        writer.flush();
    }

    @Override
    public synchronized void close() throws SecurityException {
        writer.close();
    }
}
