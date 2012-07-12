package oauth;

import json.DataExtractor;

import org.json.simple.parser.ParseException;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

import dao.IDHandler;

public class TweetAction {
	public static long tweetThis(OAuthService service,Token accessToken,String data) throws ParseException{
		OAuthRequest request = new OAuthRequest(Verb.POST, "http://api.twitter.com/1/statuses/update.json");
		request.addBodyParameter("status", data);
		service.signRequest(accessToken, request);
		Response response = request.send();
		if(response.getCode() == 200){
			return DataExtractor.getId(response.getBody());
		}else
		{
			return -1;
		}
	}
	
	public static boolean retweetThis(OAuthService service,Token accessToken,long tweetId){
		OAuthRequest request = new OAuthRequest(Verb.POST, "http://api.twitter.com/1/statuses/retweet/"+tweetId+".json");
		service.signRequest(accessToken, request);
		Response response = request.send();
		if(response.getCode() == 200){
			return true;
		}else{
			return false;
		}
	}
}
