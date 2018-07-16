package controller.invoice;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.repackaged.org.joda.time.DateTimeZone;
import com.google.appengine.repackaged.org.joda.time.LocalDateTime;

import controller.users.AccessControllerU;
import controller.PMF;
import model.entity.*;

public class AddController extends HttpServlet {
	public static int NRecibo= 1;
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (AccessControllerU.isPermited(req.getServletPath(), req, resp, this)){	
			RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/Views/Bills/add.jsp");
			rd.forward(req, resp);
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		PersistenceManager pm = PMF.get().getPersistenceManager();
		double cost= Double.parseDouble(request.getParameter("cost"));
		int quant=Integer.parseInt(request.getParameter("quant"));
		String address=request.getParameter("address").replace(" ", "");
		String code= request.getParameter("code");
		String ruc= request.getParameter("ruc");
		String name= request.getParameter("name").replace(" ","");
		if(!address.equals("")&&!name.equals("")){
		Invoice invoice = new Invoice(cost,quant,address,code,ruc,name,NRecibo);
		pm.makePersistent(invoice);
		}
		pm.close();
		response.sendRedirect("/bills");
		NRecibo++;
	}
}

