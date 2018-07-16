package controller.users;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import controller.PMF;
import javax.servlet.http.HttpServletResponse;
import javax.jdo.PersistenceManager;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import model.entity.*;
import java.util.List;

public class LogControllerU {
	public static boolean isLogged (){
		//captura el loggin actual
		UserService us = UserServiceFactory.getUserService();
		//user= usuario que esta logeado
		com.google.appengine.api.users.User user = UserServiceFactory.getUserService().getCurrentUser();
		//si hay loggin presente 	//no hay loggin presente 
		if (user!=null){
			String query = "select from " + Usuario.class.getName()	+ " where email =='"+user.getEmail()+"'";
			PersistenceManager pm = PMF.get().getPersistenceManager();
			List <Usuario> users = (List<Usuario>)pm.newQuery(query).execute();
			pm.close();
			return !users.isEmpty();
		}
		return false;
	}
	public static Usuario getUser(){
		String email="";
		UserService us = UserServiceFactory.getUserService();
		com.google.appengine.api.users.User user = UserServiceFactory.getUserService().getCurrentUser();
		PersistenceManager pm = PMF.get().getPersistenceManager();
		if (user==null){
		return null; 
		} else {
			email = user.getEmail();
		
		String query = "select from " + Usuario.class.getName()	+ " where email== '"+email+"'";
		List <Usuario> users = (List<Usuario>)pm.newQuery(query).execute();
		if (users.isEmpty()){
			return null;
		}
		else{
			pm.close();
			return users.get(0);
		}
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
}
}
