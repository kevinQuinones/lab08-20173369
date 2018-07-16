package controller.resources;
import java.io.IOException;
import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import controller.PMF;
import controller.users.AccessControllerU;
//import controller.users.LogControllerU;
import model.entity.*;
import java.util.*;
public class DeleteControllerRe extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (AccessControllerU.isPermited(req.getServletPath(), req, resp, this)){
			PersistenceManager pm = PMF.get().getPersistenceManager();
			Resource resource = pm.getObjectById(Resource.class, new Long(req.getParameter("id")).longValue());
			if (resource!=null){
				String query = "SELECT FROM "+ Access.class.getName()+ " where idResource == " + req.getParameter("id");
				List<Access> access = (List<Access>)pm.newQuery(query).execute();
				for (Access ac: access){
					pm.deletePersistent(ac);
				}
				pm.deletePersistent(resource);
			}
			pm.close();
			resp.sendRedirect("/resources");
		}
	}
}