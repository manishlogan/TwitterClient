package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oauth.TweetAction;
import oauth.TwitterConnect;

import org.scribe.model.Token;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

import dao.IDHandler;

public class OAuthServlet extends HttpServlet {
	private OAuthService service;
	private Token requestToken;
	private String data = "Check";
	private HttpSession session;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			String code = req.getParameter("oauth_verifier");
			Verifier verifier = new Verifier(code);
			Token accessToken = service.getAccessToken(requestToken, verifier);
			HttpSession newSession = req.getSession(true);
			newSession.setAttribute("accessToken", accessToken);
			newSession.setAttribute("username", session.getAttribute("username"));
			if (IDHandler.getId() == 0) {
				TweetAction.tweetThis(service, accessToken, data);
			} else {
				TweetAction.retweetThis(service, accessToken, 222589618539859969l);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		service = TwitterConnect.connectToTwitter();
		requestToken = service.getRequestToken();
		session = req.getSession(false);
		resp.sendRedirect(service.getAuthorizationUrl(requestToken));
	}
}
