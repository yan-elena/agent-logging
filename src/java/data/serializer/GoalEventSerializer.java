package data.serializer;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import event.GoalEvent;

import java.lang.reflect.Type;

public class GoalEventSerializer implements JsonSerializer<GoalEvent> {

    @Override
    public JsonElement serialize(GoalEvent src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject object = new JsonObject();
        object.addProperty("agentName", src.getAgentName());
        object.addProperty("cycle", src.getReasoningCycleNum());
        object.addProperty("timestamp", src.getTimestamp());
        object.addProperty("action", src.getGoalFunctor());
        object.addProperty("state", src.getGoalStates());
        object.addProperty("event", src.eventToString());
        return object;
    }
}
