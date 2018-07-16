package controller.users;


import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import controller.PMF;

import java.util.List;
import model.entity.*;;

public class LoginControllerU extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		UserService us = UserServiceFactory.getUserService();
		PersistenceManager pm = controller.PMF.get().getPersistenceManager();
		com.google.appengine.api.users.User user = us.getCurrentUser();
		
		if (user==null){
			if (request.getParameter("p")==null)
				 response.sendRedirect(us.createLoginURL(request.getRequestURI()+"?url="+request.getParameter("url")));
			else {
				request.setAttribute("respuesta", "No existe el usuario  " + "<a href=\"/users/register?email?=+"+request.getParameter("email")+"\">Registrar</a>");
				RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/Views/Users/loginMistake.jsp");
				rd.forward(request, response);
			}
		} else{
			String query = "select from " + Usuario.class.getName()	+ " where email == '"+user.getEmail()+"'";
			List<Usuario> list = (List<Usuario>) pm.newQuery(query).execute();
			pm.close();
			if (list.isEmpty()){
				response.setContentType("text/html");
			//	response.getWriter().println("No existe el usuario que desea ingresar " + "<a href=\"/users/register?url?=+"+request.getParameter("url")+"\">Registrar</a>");
				response.sendRedirect(us.createLogoutURL(request.getRequestURI()+"?email="+user.getEmail()+"&&p=t"));
			} else{
				response.sendRedirect("/");
			}
		}
	}
}
