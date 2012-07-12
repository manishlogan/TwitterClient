package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oauth.RetweetCount;
import oauth.TwitterConnect;

import org.scribe.model.OAuthRequest;
import org.scribe.model.Token;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

import dao.IDHandler;

/**
 * Servlet implementation class RetweetCountServlet
 */
public class RetweetCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private OAuthService service;
	private Token requestToken;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service = TwitterConnect.connectToTwitter();
		Token accessToken = (Token)request.getSession(false).getAttribute("accessToken");
		long id = IDHandler.getId();
		try{
			request.setAttribute("count", RetweetCount.getCount(service, accessToken, id));
		}catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("totalCount.jsp").forward(request, response);
	}
}
