package controller.users;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.entity.*;
import controller.PMF;
import java.io.IOException;
import java.util.List;
import controller.users.LogControllerU;

public class AccessControllerU {
	public static boolean  isPermited (String url, HttpServletRequest request, HttpServletResponse response, HttpServlet servlet) throws ServletException, IOException{
		String respuesta = "";
		PersistenceManager pm = PMF.get().getPersistenceManager();
		if (LogControllerU.isLogged()){//si esta logeado
			Usuario usuario = LogControllerU.getUser();//recupera el usuario logeado
		if(usuario!=null){	
			String query = "select from " + Resource.class.getName()	+ " where url == '"+url+"'";//recupera la url a la que quiere acceder el usuario 
			List<Resource> resources = (List<Resource>)pm.newQuery(query).execute();
			if (!resources.isEmpty()){
				//recupera el rol que tiene elusuario  y el recurso que queria acceder
				query = "select from " + Access.class.getName()	+ " where idRole == "+usuario.getIdRole()+ " && idResource == "+ resources.get(0).getId()+" && status == true";
				List<Access> access = (List<Access>)pm.newQuery(query).execute();
				if (!access.isEmpty()){
					pm.close();
					return true;
				} else {
					respuesta = "Usted no puede  entrar<br>";
							
				}
			} 
			else {
				respuesta = "El recurso  no existe  <br>";
						
			}
		}
		else{
			respuesta="debe iniciar sesion?";
		}
		}
		 else {
			respuesta = "Por favor inicie sesion para acceder  ";
		}
		pm.close();
		request.setAttribute("respuesta", respuesta);
		RequestDispatcher rd = servlet.getServletContext().getRequestDispatcher("/WEB-INF/Views/Users/loginMistake.jsp");
		rd.forward(request, response);
		return false;
	}
	public static boolean  isPermitedIndex (String url, HttpServletRequest request, HttpServletResponse response, HttpServlet servlet) throws ServletException, IOException{
		String respuesta = "";
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Usuario usuario = LogControllerU.getUser();
		if(usuario!=null){
		String query = "select from " + Resource.class.getName()	+ " where url == '"+url+"'";
		List<Resource> resources = (List<Resource>)pm.newQuery(query).execute();
		if (!resources.isEmpty()){
			query = "select from " + Access.class.getName()	+ " where idResource == "+ resources.get(0).getId()+" && idRole == "+ usuario.getIdRole()+" && status == true";
			List<Access> access = (List<Access>)pm.newQuery(query).execute();
			if (!access.isEmpty()){
				pm.close();
				return true;
			} else {
				respuesta = "Usted no tiene permisos<br>";
			}
		} else {
			respuesta = "El recurso no existe por favor comuniquese con un usuario a cargo para solucionar este problema <br>";
		}
		pm.close();
		}
		else{
			respuesta="inicie sesion?";
		}
		request.setAttribute("respuesta", respuesta);
		RequestDispatcher rd = servlet.getServletContext().getRequestDispatcher("/WEB-INF/Views/Users/loginMistake.jsp");
		rd.forward(request, response);
		return false;
	}
}

