package controller.roles;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import controller.PMF;

import model.entity.*;

public class ViewControllerRo extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("url", req.getRequestURI());
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Role rol = pm.getObjectById(Role.class, Long.parseLong(req.getParameter("id")));
		String query = "SELECT FROM "+ Access.class.getName()+ " where idRole == " + req.getParameter("id");
		List<Access> access = (List<Access>)pm.newQuery(query).execute();
		pm.close();
		req.setAttribute("role", rol);
		req.setAttribute("acc", access);
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/Views/Roles/view.jsp");
		rd.forward(req, resp);
	}
}