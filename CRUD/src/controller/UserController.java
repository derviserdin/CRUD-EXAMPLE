package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.user;
import service.UserService;

/**
 * Servlet implementation class UserController
 */
@WebServlet(description = "user control class", urlPatterns = { "/User" })
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDao userDao = new UserDao();

		/*
		 * Null pointer hatasý vermesi için try-catch blogu kullanýldý
		 */
		try {
			String islem = request.getParameter("islem");
			if (islem.equalsIgnoreCase("sil")) {
				String id = request.getParameter("id");

				userDao.deleteUser(id);
				response.sendRedirect("User");
			} else if (islem.equalsIgnoreCase("duzenle")) {
				int id = Integer.parseInt(request.getParameter("id"));

				request.setAttribute("user", userDao.getUser(id));
				RequestDispatcher view = request.getRequestDispatcher("user.jsp");
				view.forward(request, response);
			}
		} catch (Exception e) {
			request.setAttribute("USER", userDao.getAll());
			RequestDispatcher view = request.getRequestDispatcher("index.jsp");
			view.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * @params
		 */
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String islem = request.getParameter("islem");

		/*
		 * @authenticate
		 */
		UserDao userDao = new UserDao();
		UserService userService = new UserService();
		if (userService.authenticateAddUser(username, password, email)) {
			// UserDao userDao = new UserDao();
			user User = new user();
			User.setUsername(username);
			User.setPassword(password);
			User.setEmail(email);

			/*
			 * @ iþlem karþýlaþtýrma ve ekleme yada düzenleme
			 */
			if (islem.equalsIgnoreCase("ekle")) {

				userDao.addNew(User);

				response.sendRedirect("User");
			} else if (islem.equalsIgnoreCase("duzenle")) {
				String id = request.getParameter("id");
				User.setId(Integer.parseInt(id));
				userDao.updateUser(User);
				response.sendRedirect("User");
			} else {
				response.sendRedirect("User");
			}
		} else {

			request.getSession().setAttribute("Sonuc", "Lütfen Boþ alanlarý doldurunuz");
			response.sendRedirect("User");
		}

	}

}
