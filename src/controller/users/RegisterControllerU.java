package controller.users;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.appengine.repackaged.org.joda.time.DateTimeZone;
import com.google.appengine.repackaged.org.joda.time.LocalDateTime;

import controller.PMF;
import model.entity.*;


public class RegisterControllerU extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		UserService us = UserServiceFactory.getUserService();
		com.google.appengine.api.users.User user = us.getCurrentUser();
		if (user==null){
			if (request.getParameter("email")==null)
				 response.sendRedirect(us.createLoginURL(request.getRequestURI()));
			else {
				request.setAttribute("email", request.getParameter("email"));
				LocalDateTime ldt = LocalDateTime.now(DateTimeZone.forID("America/Lima"));
				PersistenceManager pm = PMF.get().getPersistenceManager();
				String query = "select from " + Role.class.getName() + " where nombre== 'UsuarioStandard'" ;
				List<Role> roles = (List<Role>)pm.newQuery(query).execute();
				request.setAttribute("role", roles.get(0));
				request.setAttribute("date", ldt.toDate());
				RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/Views/Users/register.jsp");
				rd.forward(request, response);
			}
		}  else {
			String query = "select from " + Usuario.class.getName()	+ " where email=='"+user.getEmail()+"'";
			PersistenceManager pm = PMF.get().getPersistenceManager();
			List<Usuario> list = (List<Usuario>) pm.newQuery(query).execute();
			pm.close();
			if (list.isEmpty()){
				response.sendRedirect(us.createLogoutURL(request.getRequestURI()+"?email="+user.getEmail()));
			} else {
				request.setAttribute("respuesta", "El correo ya ha sido registrado anteriormente y ha sido logueado");
				RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/Views/Users/loginMistake.jsp");
				rd.forward(request, response);
			}
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		PersistenceManager pm = PMF.get().getPersistenceManager();
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		try {
			String query = "select from " + Usuario.class.getName()	+ " where email == '"+request.getParameter("email")+"'";
			List<Usuario> users = (List<Usuario>)pm.newQuery(query).execute();
			if (users.isEmpty()){
				Usuario user = new Usuario(Long.parseLong(request.getParameter("role")),request.getParameter("email"), date.parse(request.getParameter("date")), Boolean.parseBoolean(request.getParameter("gender")));
				pm.makePersistent(user);
			}
		} catch (ParseException e) {
			response.getWriter().println(e.getMessage());
		} finally {
			request.setAttribute("respuesta", "Registrado <a href=\"/users/login\">inicie sesion</a>");
			RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/Views/Users/loginMistake.jsp");
			rd.forward(request, response);
		}
	}
}