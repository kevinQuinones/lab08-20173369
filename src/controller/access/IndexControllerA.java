package controller.access;

import java.io.IOException;
import java.util.List;

import javax.jdo.JDOObjectNotFoundException;
import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import controller.PMF;
import controller.users.AccessControllerU;
import controller.users.LogControllerU;
import model.entity.*;;

public class IndexControllerA extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (AccessControllerU.isPermitedIndex(req.getServletPath(), req, resp, this)){
			PersistenceManager pm = PMF.get().getPersistenceManager();
			String query = "SELECT FROM "+ Access.class.getName();
			List<Access> access = (List<Access>)pm.newQuery(query).execute();
			pm.close();
			req.setAttribute("access", access);
			RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/Views/Access/index.jsp");
			rd.forward(req, resp);
		}
	}
}