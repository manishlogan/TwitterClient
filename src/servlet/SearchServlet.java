package servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oauth.Search;
import oauth.TwitterConnect;

import org.scribe.oauth.OAuthService;

/**
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OAuthService service = TwitterConnect.connectToTwitter();
		HashMap<String, String> searchData = Search.searchData(service,request.getParameter("searchText"));
		request.setAttribute("searchData", searchData);
		request.getRequestDispatcher("search.jsp").forward(request, response);
	}

}
