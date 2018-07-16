package controller.access;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import controller.PMF;
import controller.users.AccessControllerU;
//import controller.users.LogControllerU;
import model.entity.*;

public class EditControllerA extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	if (AccessControllerU.isPermited(req.getServletPath(), req, resp, this)){
			PersistenceManager pm = PMF.get().getPersistenceManager();
			Access access = pm.getObjectById(Access.class, Long.parseLong(req.getParameter("id")));
			pm.close();
			req.setAttribute("access", access);
			RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/Views/Access/edit.jsp");
			rd.forward(req, resp);
		}
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		Access access = pm.getObjectById(Access.class, Long.parseLong(req.getParameter("id")));
		access.setStatus(Boolean.parseBoolean(req.getParameter("is")));
		pm.close();
		resp.sendRedirect("/access/view?id="+req.getParameter("id"));
	}
}