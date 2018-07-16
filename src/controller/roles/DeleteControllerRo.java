package controller.roles;
import java.io.IOException;
import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import controller.PMF;
import controller.users.AccessControllerU;
import model.entity.*;
import java.util.*;
public class DeleteControllerRo extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (AccessControllerU.isPermited(req.getServletPath(), req, resp, this)){
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Role rol = pm.getObjectById(Role.class, Long.parseLong(req.getParameter("id")));
		if ((!rol.getNombre().equalsIgnoreCase("Invitado"))&&!(rol.getNombre().equalsIgnoreCase("Administrador"))){
			Role role = pm.getObjectById(Role.class, new Long(req.getParameter("id")).longValue());
			String query = "SELECT FROM "+ Role.class.getName();
			List<Role> roles = (List<Role>)pm.newQuery(query).execute();
			req.setAttribute("role", role);
			req.setAttribute("roles", roles);
			pm.close();
			RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/Views/Roles/delete.jsp");//NO HAY¡¡
			rd.forward(req, resp);
		}
		else {
			req.setAttribute("respuesta", "Los roles no seran eliminados");
			RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/Views/Users/loginMistake.jsp");
			rd.forward(req, resp);
		}
		}
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Role role = pm.getObjectById(Role.class, new Long(req.getParameter("id")).longValue());
		if (role!=null){
			String query = "SELECT FROM "+ Access.class.getName()+ " where idRole == " + req.getParameter("id");
			List<Access> access = (List<Access>)pm.newQuery(query).execute();
			query = "SELECT FROM "+ Usuario.class.getName()+ " where idRole == " + req.getParameter("id");
			List<Usuario> users = (List<Usuario>)pm.newQuery(query).execute();
			for (Usuario us: users){
				us.setIdRole(Long.parseLong(req.getParameter("rol")));
			}
			for (Access ac: access){
				pm.deletePersistent(ac);
			}
			pm.deletePersistent(role);
		}
		pm.close();
		resp.sendRedirect("/roles");
	}
}
		