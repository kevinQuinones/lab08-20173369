package controller.invoice;
import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import controller.PMF;
import controller.users.AccessControllerU;
import model.entity.*;
public class DeleteController extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (AccessControllerU.isPermited(req.getServletPath(), req, resp, this)){
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Invoice user = pm.getObjectById(Invoice.class, new Long(req.getParameter("id")).longValue());
		if (user!=null){
			pm.deletePersistent(user);
		}
		pm.close();
		resp.sendRedirect("/bills");
		}
	}
}
