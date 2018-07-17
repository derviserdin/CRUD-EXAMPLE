/**
 * 
 */
package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author dervish
 *
 */
@WebServlet("/logout")

public class LogoutController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession(false);
		if (session != null) {
			request.getSession().invalidate();
			response.sendRedirect("login.jsp");
		} else {
			response.sendRedirect("index.jsp");
		}
	}
	
}
