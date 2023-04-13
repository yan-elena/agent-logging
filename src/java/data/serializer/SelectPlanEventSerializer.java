package data.serializer;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import event.SelectPlanEvent;

import java.lang.reflect.Type;

public class SelectPlanEventSerializer implements JsonSerializer<SelectPlanEvent> {

    @Override
    public JsonElement serialize(SelectPlanEvent src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject object = new JsonObject();
        object.addProperty("agentName", src.getAgentName());
        object.addProperty("cycle", src.getReasoningCycleNum());
        object.addProperty("timestamp", src.getTimestamp());
        object.add("options", context.serialize(src.getPlanOptions()));
        object.addProperty("selected", src.getSelected());
        object.addProperty("event", src.eventToString());
        return object;
    }
}
