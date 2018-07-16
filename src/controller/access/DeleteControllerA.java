package controller.access;
import java.io.IOException;
import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import controller.PMF;
import controller.users.AccessControllerU;
//import controller.users.LogControllerU;
import model.entity.*;;
public class DeleteControllerA extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	if (AccessControllerU.isPermited(req.getServletPath(), req, resp, this)){
			PersistenceManager pm = PMF.get().getPersistenceManager();
			Access access = pm.getObjectById(Access.class, new Long(req.getParameter("id")).longValue());
			if (access!=null){
				pm.deletePersistent(access);
			}
			pm.close();
			resp.sendRedirect("/access");
		}
	}
}