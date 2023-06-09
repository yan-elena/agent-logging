package gson.typeAdapter;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import gson.GsonUtils;

import java.lang.reflect.Type;
import java.util.logging.LogRecord;

/**
 * Serializer for the class {@link LogRecord}.
 */
public class LogRecordTypeAdapter implements JsonSerializer<LogRecord> {

    @Override
    public JsonElement serialize(LogRecord src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject object = new JsonObject();
        object.addProperty("timestamp", src.getMillis());
        object.add("message", GsonUtils.createGson().fromJson(src.getMessage(), JsonObject.class));
        return object;
    }
}
