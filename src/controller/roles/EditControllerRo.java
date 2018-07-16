package controller.roles;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import controller.PMF;
import controller.users.AccessControllerU;
import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import model.entity.*;
import java.util.*;
public class EditControllerRo extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (AccessControllerU.isPermited(req.getServletPath(), req, resp, this)){
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Role role = pm.getObjectById(Role.class, Long.parseLong(req.getParameter("id")));
		String query = "SELECT FROM "+ Access.class.getName()+ " where idRole == " + req.getParameter("id");
		List<Access> access = (List<Access>)pm.newQuery(query).execute();
		pm.close();
		req.setAttribute("role", role);
		req.setAttribute("access", access);
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/Views/Roles/edit.jsp");
		rd.forward(req, resp);
		}
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Role role = pm.getObjectById(Role.class, Long.parseLong(req.getParameter("id")));
		String query = "SELECT FROM "+ Access.class.getName()+ " where idRole == " + req.getParameter("id");
		List<Access> access = (List<Access>)pm.newQuery(query).execute();
		for (Access ac: access){
			ac.setStatus(Boolean.parseBoolean(req.getParameter(""+ac.getId())));
		}
		role.setNombre(req.getParameter("name"));
		pm.close();
		resp.sendRedirect("/roles");
	}
}