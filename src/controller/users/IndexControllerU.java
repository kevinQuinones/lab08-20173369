package controller.users;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import controller.PMF;
import model.entity.*;

public class IndexControllerU extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//if (AccessControllerU.isPermitedIndex(req.getServletPath(), req, resp, this)){
			PersistenceManager pm = PMF.get().getPersistenceManager();
			String query = "SELECT FROM "+ Usuario.class.getName();
			List<Usuario> users = (List<Usuario>)pm.newQuery(query).execute();
			pm.close();
			req.setAttribute("users", users);
			RequestDispatcher des = this.getServletContext().getRequestDispatcher("/WEB-INF/Views/Users/index.jsp");
			des.forward(req, resp);
		//}
	}
}