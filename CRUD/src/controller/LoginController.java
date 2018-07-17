package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoginDao;
import service.LoginService;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName, password;
		userName = request.getParameter("username");
		password = request.getParameter("password");

		LoginService loginService = new LoginService();
		boolean result = loginService.authenticate(userName, password);
		if (result) {
			LoginDao dao = new LoginDao();
			if (dao.check(userName, password)) {

				HttpSession session = request.getSession(false);
				if (session != null) {
					session.setAttribute("user", userName);
					response.sendRedirect("User");
				} else {
					response.sendRedirect("login.jsp");
				}

			} else {
				response.sendRedirect("login.jsp");
			}

		} else {
			response.sendRedirect("login.jsp");
		}

	}

}
