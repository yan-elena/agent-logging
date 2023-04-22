package data.typeAdapter;

import com.google.gson.*;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;

/**
 * Serializer and deserializer for the class {@link Optional}.
 */
public class OptionalTypeAdapter implements JsonSerializer<Optional<?>>, JsonDeserializer<Optional<?>> {

    @Override
    public Optional<?> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        JsonElement value = jsonObject.get("value");
        return Optional.ofNullable(context.deserialize(value, ((ParameterizedType) typeOfT).getActualTypeArguments()[0]));
    }

    @Override
    public JsonElement serialize(Optional<?> src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("value", context.serialize(src.orElse(null)));
        return jsonObject;
    }
}