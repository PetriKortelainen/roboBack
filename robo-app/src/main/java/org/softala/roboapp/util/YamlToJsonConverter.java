package org.softala.roboapp.util;

import org.json.simple.JSONValue;
import org.yaml.snakeyaml.Yaml;

import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

/**
 * 
 * @author Mikko-Ville Salo
 *
 *
 */

public class YamlToJsonConverter {
	
	public static String YamlToJsonString(String yamlString){
		Yaml yaml = new Yaml();
		Object obj = yaml.load(yamlString);
		return JSONValue.toJSONString(obj);
	}
	
	public static boolean isValid(String json) {
	    try {
	        new JsonParser().parse(json);
	        return true;
	    } catch (JsonSyntaxException jse) {
	        return false;
	    }
	}
}
