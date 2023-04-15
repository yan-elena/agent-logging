package data.serializer;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import event.goalEvent.GoalEvent;

import java.lang.reflect.Type;

public class GoalEventSerializer implements JsonSerializer<GoalEvent> {

    @Override
    public JsonElement serialize(GoalEvent src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject object = new JsonObject();
        object.addProperty("agentName", src.getAgentName());
        object.addProperty("cycle", src.getReasoningCycleNum());
        object.addProperty("timestamp", src.getTimestamp());
        object.addProperty("type", src.getClass().getSimpleName());
        object.add("goalInfo", context.serialize(src.getGoalInfo()));
        object.addProperty("event", src.logEvent());
        return object;
    }
}
