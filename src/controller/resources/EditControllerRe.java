package controller.resources;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import controller.PMF;
import controller.users.AccessControllerU;
import controller.users.LogControllerU;
import model.entity.*;
public class EditControllerRe extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (AccessControllerU.isPermited(req.getServletPath(), req, resp, this)){
			PersistenceManager pm = PMF.get().getPersistenceManager();
			Resource rsr = pm.getObjectById(Resource.class, Long.parseLong(req.getParameter("id")));
			String query = "SELECT FROM "+ Access.class.getName()+ " where idResource == " + req.getParameter("id");
			List<Access> access = (List<Access>)pm.newQuery(query).execute();
			pm.close();
			req.setAttribute("rsr", rsr);
			req.setAttribute("access", access);
			RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/Views/Resources/edit.jsp");
			rd.forward(req, resp);
		}
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Resource rsr = pm.getObjectById(Resource.class, Long.parseLong(req.getParameter("id")));
		String query = "SELECT FROM "+ Access.class.getName()+ " where idResource == " + req.getParameter("id");
		List<Access> access = (List<Access>)pm.newQuery(query).execute();
		for (Access ac: access){
			ac.setStatus(Boolean.parseBoolean(req.getParameter(""+ac.getId())));
		}
		rsr.setNombre(req.getParameter("url"));
		pm.close();
		resp.sendRedirect("/resources/view?id="+req.getParameter("id"));
	}
}
