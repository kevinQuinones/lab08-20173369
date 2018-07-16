package controller.users;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import com.google.appengine.repackaged.org.joda.time.DateTimeZone;
import com.google.appengine.repackaged.org.joda.time.LocalDateTime;
import controller.PMF;
import model.entity.*;

public class EditControllerU extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (AccessControllerU.isPermited(req.getServletPath(), req, resp, this)){		
		PersistenceManager pm = PMF.get().getPersistenceManager();
			LocalDateTime ldt = LocalDateTime.now(DateTimeZone.forID("America/Lima"));
			req.setAttribute("date", ldt.toDate());
			String query = "select from " + Role.class.getName();
			List<Role> roles = (List<Role>)pm.newQuery(query).execute();//recoge a clase roles
			req.setAttribute("roles", roles);// lo manda 
			Usuario user = pm.getObjectById(Usuario.class, Long.parseLong(req.getParameter("id")));
//recoge el usuario a editar 			
			boolean editrol = true;
			if (user.isAdministrador()){
				query = "select from " + Usuario.class.getName()+ " where idRole == " + user.getIdRole();//recoge todos los usuario con el rol del usuario que quiere editar 
				List<Usuario> administrators = (List<Usuario>)pm.newQuery(query).execute();
				if (administrators.size()<=1) editrol=false;//si no hay mas usuarios queq tienen el mismo rol, es decir por ejemplo un unico profesor 
			}
			pm.close();
			req.setAttribute("editrol", editrol);
			req.setAttribute("user", user);
			RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/Views/Users/edit.jsp");
			rd.forward(req, resp);
		}
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		Usuario user = pm.getObjectById(Usuario.class, Long.parseLong(req.getParameter("id")));
		try {
			user.setBirth(date.parse(req.getParameter("date")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		user.setIdRole(Long.parseLong(req.getParameter("role")));
		user.setGender(Boolean.parseBoolean(req.getParameter("gender")));
		pm.close();
		resp.sendRedirect("/users/view?id="+req.getParameter("id"));
	}
}