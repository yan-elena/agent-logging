package logger;

import com.google.gson.*;
import gson.GsonUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

/**
 * A class that is responsible for handling logging information by writing it to a JSON file.
 */
public class JsonFileHandler extends Handler {

    private static final String PATH = "log/";
    private final Gson gson;
    private final PrintWriter writer;
    private final JsonArray jsonArray;

    /**
     * Creates a new instance of {@link JsonFileHandler} with the specified filename.
     * @param filename the name of the file to save the log
     * @throws IOException if there are IO problems opening the files
     */
    public JsonFileHandler(String filename) throws IOException {
        this.gson = GsonUtils.createGson();
        this.jsonArray = new JsonArray();
        this.writer = new PrintWriter(PATH + filename + ".json");
    }

    @Override
    public void publish(LogRecord record) {
        this.jsonArray.add(gson.toJsonTree(record));
    }

    @Override
    public void flush() {
        writer.flush();
    }

    @Override
    public void close() throws SecurityException {
        writer.println(gson.toJson(jsonArray));
        writer.close();
    }
}
