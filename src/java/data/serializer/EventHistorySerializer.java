package data.serializer;

import com.google.gson.*;
import eventHistory.EventHistory;
import eventHistory.EventHistoryImpl;

import java.lang.reflect.Type;

/**
 * Serializer for the class {@link EventHistory}.
 */
public class EventHistorySerializer implements JsonSerializer<EventHistory> {

    @Override
    public JsonElement serialize(EventHistory src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject object = new JsonObject();
        JsonArray array = new JsonArray();
        src.getHistory().forEach( e ->
                array.add(context.serialize(e))
        );
        object.add("eventHistory", array);
        return object;
    }
}
