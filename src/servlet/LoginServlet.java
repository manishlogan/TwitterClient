package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	String username = req.getParameter("username");
	HttpSession session = req.getSession(true);
	session.setAttribute("username", username);
	req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
}
