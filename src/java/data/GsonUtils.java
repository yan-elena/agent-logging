package data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import data.serializer.*;
import event.ActionEvent;
import event.SelectPlanEvent;
import event.goalEvent.GoalAddedEvent;
import eventHistory.EventHistoryImpl;
import logger.EventLoggerImpl;

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
//                .excludeFieldsWithoutExposeAnnotation()
//                .serializeNulls()
                .registerTypeAdapter(LogRecord.class, new LogRecordSerializer())
                .registerTypeAdapter(Optional.class, new OptionalTypeAdapter())

//                .registerTypeAdapter(EventHistoryImpl.class, new EventHistorySerializer())
//                .registerTypeAdapter(EventHistory.class, new EventHistoryDeserializer())
//                .registerTypeAdapter(ActionEvent.class, new ActionEventSerializer())
//                .registerTypeAdapter(ActionEvent.class, new ActionEventDeserializer())
//                .registerTypeAdapter(GoalAddedEvent.class, new GoalEventSerializer())
//                .registerTypeAdapter(GoalEvent.class, new GoalEventDeserializer())
//                .registerTypeAdapter(SelectPlanEvent.class, new SelectPlanEventSerializer())
//                .registerTypeAdapter(SelectPlanEvent.class, new SelectPlanEventDeserializer())
//                .registerTypeAdapter(EventLoggerImpl.class, new LoggerSerializer())
                .create();
    }
}
