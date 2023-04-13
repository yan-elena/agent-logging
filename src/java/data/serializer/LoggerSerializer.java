package data.serializer;

import com.google.gson.*;
import logger.LoggerImpl;

import java.lang.reflect.Type;

public class LoggerSerializer implements JsonSerializer<LoggerImpl> {

    @Override
    public JsonElement serialize(LoggerImpl src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject object = new JsonObject();
        JsonArray array = new JsonArray();
        src.getHistory().forEach((agent, history) -> {
            JsonObject historyObj = new JsonObject();
            historyObj.addProperty("agentName", agent);
            historyObj.add("history", context.serialize(history));
            array.add(historyObj);
        });
        object.add("log", array);
        return object;
    }
}
