package controller.invoice;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import controller.users.AccessControllerU;
import controller.PMF;
import model.entity.*;

public class IndexController extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (AccessControllerU.isPermitedIndex(req.getServletPath(), req, resp, this)){
		PersistenceManager pm = PMF.get().getPersistenceManager();
		String query = "SELECT FROM "+ Invoice.class.getName();
		List<Invoice> users = (List<Invoice>)pm.newQuery(query).execute();
		pm.close();
		req.setAttribute("users", users);
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/Views/Bills/index.jsp");
		rd.forward(req, resp);
		}
	}
}
