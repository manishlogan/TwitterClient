package json;

import java.util.HashMap;

import javax.naming.ldap.Rdn;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import dao.IDHandler;

public class DataExtractor {
	public static long getId(String jsonData) throws ParseException{
		JSONParser parser = new JSONParser();
		JSONObject root = (JSONObject)parser.parse(jsonData);
		Long id = (Long)root.get("id");
		IDHandler.setId(id);
		return id;
	}
	
	public static long getRetweetCount(String data) throws ParseException{
		JSONParser parser = new JSONParser();
		JSONObject root = (JSONObject)parser.parse(data);
		Long count = (Long)root.get("retweet_count");
		IDHandler.setId(count);
		return count + 1;
	}
	
	public static HashMap<String, String> extractSearchData(String jsonData){
		HashMap<String, String> searchData = new HashMap<String, String>();
		JSONParser parser = new JSONParser();
		try{
			JSONObject root = (JSONObject)parser.parse(jsonData);
			JSONArray result = (JSONArray)root.get("results");
			for(Object obj : result){
				JSONObject tweet = (JSONObject)obj;
				String text = (String)tweet.get("text");
				String username = (String)tweet.get("from_user");
				searchData.put(username, text);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return searchData;
	}
}
