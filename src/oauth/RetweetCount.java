package oauth;

import json.DataExtractor;

import org.json.simple.parser.ParseException;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

public class RetweetCount {
	public static long getCount(OAuthService service,Token accessToken,long tweetId) throws ParseException{
		OAuthRequest request = new OAuthRequest(Verb.GET, "https://api.twitter.com/1/statuses/show/"+tweetId+".json");
		service.signRequest(accessToken, request);
		Response response = request.send();
		if(response.getCode() == 200){
			return DataExtractor.getRetweetCount(response.getBody());
		}else{
			return -1;
		}
	}
}
