package controller.roles;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import controller.PMF;
import model.entity.*;
import controller.users.AccessControllerU;
public class AddControllerRo extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (AccessControllerU.isPermited(req.getServletPath(), req, resp, this)){	
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/Views/Roles/add.jsp");
			rd.forward(req, resp);
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		PersistenceManager pm = PMF.get().getPersistenceManager();
		String n= request.getParameter("name").replace(" ", "");
		String query = "select from " + Role.class.getName()+ " where nombre == '"+n+"'";
		List<Role> roles = (List<Role>)pm.newQuery(query).execute();
		if (roles.isEmpty()&&!n.equals("")){
			Role role = new Role(request.getParameter("name"));
			pm.makePersistent(role);
		}
		pm.close();
		response.sendRedirect("/roles");
	}
}
