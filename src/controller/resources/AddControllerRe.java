package controller.resources;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.PMF;
import controller.users.AccessControllerU;
import controller.users.LogControllerU;
import model.entity.*;

public class AddControllerRe extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	if (AccessControllerU.isPermited(req.getServletPath(), req, resp, this)){
			RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/Views/Resources/add.jsp");
			rd.forward(req, resp);
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		PersistenceManager pm = PMF.get().getPersistenceManager();
		String query = "select from " + Resource.class.getName()	+ " where url == '"+request.getParameter("url")+"'";
		List<Resource> resources = (List<Resource>)pm.newQuery(query).execute();
		String rev= request.getParameter("url").replaceAll(" ", "");
		if (resources.isEmpty()&&!rev.equals("")){
			Resource resource = new Resource(request.getParameter("url"));
			pm.makePersistent(resource);
		}
		pm.close();
		response.sendRedirect("/resources");
	}
}