package controller.roles;

import java.io.IOException;
import java.util.List;
import controller.users.AccessControllerU;
import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import controller.PMF;

import model.entity.*;

public class IndexControllerRo extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (AccessControllerU.isPermitedIndex(req.getServletPath(), req, resp, this)){
		PersistenceManager pm = PMF.get().getPersistenceManager();
		String query = "SELECT FROM "+ Role.class.getName();
		List<Role> roles = (List<Role>)pm.newQuery(query).execute();
		pm.close();
		req.setAttribute("roles", roles);
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/Views/Roles/index.jsp");
		rd.forward(req, resp);
		}
	}
}