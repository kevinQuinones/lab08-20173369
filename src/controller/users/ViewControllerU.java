package controller.users;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import controller.PMF;
import model.entity.*;

public class ViewControllerU extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (AccessControllerU.isPermited(req.getServletPath(), req, resp, this)){
			PersistenceManager pm = PMF.get().getPersistenceManager();
			Usuario user = pm.getObjectById(Usuario.class, Long.parseLong(req.getParameter("id")));
			pm.close();
			req.setAttribute("user", user);
			RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/Views/Users/view.jsp");
			rd.forward(req, resp);
		}
	}
}