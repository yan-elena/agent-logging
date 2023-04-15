package data.serializer;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import event.ActionEvent;

import java.lang.reflect.Type;

public class ActionEventSerializer implements JsonSerializer<ActionEvent> {

    @Override
    public JsonElement serialize(ActionEvent src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject object = new JsonObject();
        object.addProperty("agentName", src.getAgentName());
        object.addProperty("cycle", src.getReasoningCycleNum());
        object.addProperty("timestamp", src.getTimestamp());
        object.addProperty("action", src.getAction());
        object.addProperty("event", src.logEvent());
        return object;
    }
}
