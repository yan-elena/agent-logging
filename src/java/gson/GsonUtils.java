package gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gson.typeAdapter.*;

import java.util.Optional;
import java.util.logging.LogRecord;

/**
 * This is a utility class to instantiate the {@link com.google.gson.JsonSerializer} and {@link com.google.gson.JsonDeserializer}.
 */
public class GsonUtils {

    /**
     * Create a new Gson builder with specific serializer and deserializer.
     * @return a new Gson builder with specific serializer and deserializer.
     */
    public static Gson createGson() {
        return new GsonBuilder()
                .setPrettyPrinting()
                .serializeNulls()
                .registerTypeAdapter(LogRecord.class, new LogRecordTypeAdapter())
                .registerTypeAdapter(Optional.class, new OptionalTypeAdapter())
                .create();
    }
}
