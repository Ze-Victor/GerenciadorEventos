package br.ufrn.imd.modelo;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class EventoAdpter implements JsonSerializer<Evento>, JsonDeserializer<Evento>{

	@Override
	public Evento deserialize(JsonElement arg0, Type arg1, JsonDeserializationContext arg2) throws JsonParseException {
        JsonObject jsonObject = arg0.getAsJsonObject();
        String type = "Evento" + jsonObject.get("tipoEvento").getAsJsonObject().get("value").getAsString();
        JsonElement element = jsonObject;
        try {
            String thePackage = "br.ufrn.imd.modelo.";
            return arg2.deserialize(element, Class.forName(thePackage + type));
        } catch (ClassNotFoundException cnfe) {
            throw new JsonParseException("Unknown element type: " + type, cnfe);
        }

	}

	@Override
	public JsonElement serialize(Evento arg0, Type arg1, JsonSerializationContext arg2) {
		JsonObject result = new JsonObject();
        result.add("type", new JsonPrimitive(arg0.getClass().getSimpleName()));
        result.add("properties", arg2.serialize(arg0, arg0.getClass()));
        return result;
	}

}
