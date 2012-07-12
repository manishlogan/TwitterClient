package oauth;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import json.DataExtractor;

import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

public class Search {
	public static HashMap<String,String> searchData(OAuthService service, String searchString) throws UnsupportedEncodingException{
		HashMap<String, String> resultData = new HashMap<String, String>();
		String encodedSearchString = URLEncoder.encode(searchString, "UTF-8");
		OAuthRequest request = new OAuthRequest(Verb.GET, "http://search.twitter.com/search.json?q="+encodedSearchString);
		Response response = request.send();
		if(response.getCode() == 200){
			resultData = DataExtractor.extractSearchData(response.getBody());
		}
		else{
			//TODO Add Error
		}
		return resultData;
	}
}
