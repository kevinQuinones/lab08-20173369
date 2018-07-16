package controller.resources;

import java.io.IOException;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import controller.PMF;
import controller.users.AccessControllerU;
import controller.users.LogControllerU;
import model.entity.*;
public class IndexControllerRe extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	if (AccessControllerU.isPermitedIndex(req.getServletPath(), req, resp, this)){
			PersistenceManager pm = PMF.get().getPersistenceManager();
			String query = "SELECT FROM "+ Resource.class.getName();
			List<Resource> resource = (List<Resource>)pm.newQuery(query).execute();
			pm.close();
			req.setAttribute("resource", resource);
			RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/Views/Resources/index.jsp");
			rd.forward(req, resp);
		}
	}
}