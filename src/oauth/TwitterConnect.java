package oauth;

import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.TwitterApi;
import org.scribe.oauth.OAuthService;

public class TwitterConnect {
	public static OAuthService connectToTwitter(){
		return new ServiceBuilder().provider(TwitterApi.class).apiKey("BqYd3r78AQXnXhljswoDSg").
		apiSecret("4J4QXD3K9kJ3l4jswRkq3fKhM1SHGPETqTpn5wjsvw").callback("http://172.25.28.53:8080/TwitterClient/oauth").debug().build();
	}
}
