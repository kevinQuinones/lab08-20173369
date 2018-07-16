package controller.users;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import com.google.appengine.repackaged.org.joda.time.DateTimeZone;
import com.google.appengine.repackaged.org.joda.time.LocalDateTime;
import controller.PMF;
import model.entity.*;

public class AddControllerU extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (AccessControllerU.isPermited(req.getServletPath(), req, resp, this)){	
		LocalDateTime ldt = LocalDateTime.now(DateTimeZone.forID("America/Lima"));
			PersistenceManager pm = PMF.get().getPersistenceManager();
			String query = "select from " + Role.class.getName();
			List<Role> roles = (List<Role>)pm.newQuery(query).execute();
			req.setAttribute("roles", roles);
			req.setAttribute("date", ldt.toDate());
			pm.close();
			RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/Views/Users/add.jsp");
			rd.forward(req, resp);
}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		PersistenceManager pm = PMF.get().getPersistenceManager();
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		try {
			String query = "select from " + Usuario.class.getName()	+ " where email== '"+request.getParameter("email")+"'";
			List<Usuario> users = (List<Usuario>)pm.newQuery(query).execute();
			if (users.isEmpty()){
				Usuario user = new Usuario( Long.parseLong(request.getParameter("role")),request.getParameter("email"), date.parse(request.getParameter("date")), Boolean.parseBoolean(request.getParameter("gender")));
				pm.makePersistent(user);
			}
		} catch (ParseException e) {
			response.getWriter().println(e.getMessage());
		} finally {
			pm.close();
			response.sendRedirect("/users");
		}
	}
}