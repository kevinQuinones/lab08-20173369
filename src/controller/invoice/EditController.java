package controller.invoice;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import controller.PMF;
import controller.users.AccessControllerU;
import model.entity.*;

public class EditController extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (AccessControllerU.isPermited(req.getServletPath(), req, resp, this)){
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Invoice user = pm.getObjectById(Invoice.class, Long.parseLong(req.getParameter("id")));
		pm.close();
		req.setAttribute("invoice", user);
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/Views/Bills/edit.jsp");
		rd.forward(req, resp);
		}
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		Invoice user = pm.getObjectById(Invoice.class, Long.parseLong(req.getParameter("id")));
		user.setCost(Double.parseDouble(req.getParameter("cost")));
		try {
			user.setMade(date.parse(req.getParameter("date")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		user.setQuant(Integer.parseInt(req.getParameter("quant")));
		user.setCode(req.getParameter("code"));
		user.setName(req.getParameter("name"));
		user.setTotal(Integer.parseInt(req.getParameter("quant"))*Double.parseDouble(req.getParameter("cost")));
		user.setAddress(req.getParameter("address"));
		user.setRUC(req.getParameter("ruc"));
		pm.close();
		req.setAttribute("invoice", user);
		resp.sendRedirect("/bills/view?id="+req.getParameter("id"));
	}
}
