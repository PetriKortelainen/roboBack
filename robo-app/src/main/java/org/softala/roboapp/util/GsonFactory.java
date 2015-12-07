package org.softala.roboapp.util;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

/**
 * 
 * @author Mikko-Ville Salo Convert Json to Java object using Gson GsonBuilder
 *         typeAdapter for date as long
 */

public class GsonFactory {

	public GsonFactory() {

	}

	public <T> T convertJsonToObject(Type type, String json)
			throws JsonParseException {

		try {
			Gson gson;

			GsonBuilder builder = new GsonBuilder();
			
			// Register an adapter to manage the date types as long values
			builder.registerTypeAdapter(Date.class,
					new JsonDeserializer<Date>() {

						@Override
						public Date deserialize(JsonElement json, Type typeOfT,
								JsonDeserializationContext context)
								throws JsonParseException {
							return new Date(json.getAsJsonPrimitive()
									.getAsLong());
						}
					});

			gson = builder.create();
		
			T object = gson.fromJson(json, type);
			return object;
		} catch (JsonParseException e) {
			throw new JsonParseException("", e);
		}
	}

	//ei kyl toimi?
	public String convertObjectToJsonString(Object object, Type type)
			throws JsonParseException {

		try {
			Gson gson;
			GsonBuilder builder = new GsonBuilder();
			// Register an adapter to manage the date types as long values
			builder.registerTypeAdapter(Date.class,
					new JsonDeserializer<Date>() {
						// Year in 4, month in 2, day in 2, hour in 24, minutes
						// in hour, seconds in minute, timezone in 4
						final DateFormat df = new SimpleDateFormat(
								"MMM dd, yyyy HH:mm,a");

						@Override
						public Date deserialize(JsonElement json, Type arg1,
								JsonDeserializationContext arg2)
								throws JsonParseException {
							try {
								return df.parse(json.getAsString());
							} catch (final java.text.ParseException e) {
								e.printStackTrace();
								return null;
							}
						}
					});

			gson = builder.create();
			String jsonString = gson.toJson(object, type);
			return jsonString;
		} catch (JsonParseException e) {
			throw new JsonParseException("", e);
		}
	}
}
