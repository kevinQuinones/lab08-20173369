package controller.users;
import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import controller.PMF;
import model.entity.*;
public class DeleteControllerU extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//si tiene permiso de eliminar roles 
		if (AccessControllerU.isPermited(req.getServletPath(), req, resp, this)){
			Usuario log = LogControllerU.getUser();
				PersistenceManager pm = PMF.get().getPersistenceManager();
				Usuario user = pm.getObjectById(Usuario.class, new Long(req.getParameter("id")).longValue());
				if (user!=null){
					if (user.getEmail().equalsIgnoreCase("in@vita.do")){
						req.setAttribute("respuesta", "No se puede eliminar un usuario con el rol Invitado");
						pm.close();
						RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/Views/Users/loginMistake.jsp");
						rd.forward(req, resp);
					} else {
						boolean isSame = log.getId().equals(user.getId());
						if (isSame && user.getRole().equalsIgnoreCase("Administrador")){
							req.setAttribute("respuesta", "No se puede eliminar  asi mismo");
							pm.close();
							RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/Views/Users/loginMistake.jsp");
							rd.forward(req, resp);
						}
						else{
							pm.deletePersistent(user);
							String directory = "/users";
							pm.close();
							resp.sendRedirect(directory);
						}
					}
				} else {
					resp.sendRedirect("/users");
				}
			}
	}
}