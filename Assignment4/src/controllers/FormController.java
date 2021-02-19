package controllers;
import java.io.IOException;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User;
import business.MyTimerService;
import business.OrdersBusinessInterface;
/**
 * @author Nick
 *
 */
@ManagedBean
@ViewScoped
public class FormController {
	
	@Inject
	OrdersBusinessInterface services;
	
	@EJB
	MyTimerService timer;
	
	public String onSubmit() {
		// Get user data from form 
		FacesContext context = FacesContext.getCurrentInstance();
		User user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);
		// Debug through console 
		System.out.println("onSubmit Clicked");
		System.out.println("User first name is " + user.getFirstName());
		System.out.println("User last name is " + user.getLastName());
		
		// Timer object from injected 
		timer.setTimer(10000);
		
		// Attach the user data to the request 
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		return "TestResponse.xhtml";
	}
	
	public String onFlash(User user) {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("user", user);
		System.out.println("onFlash Clicked");
		return "TestResponse2.xhtml";
	}
	
	public String onReturn() {
		//FacesContext context = FacesContext.getCurrentInstance();
		//FacesContext.getCurrentInstance().getExternalContext().getFlash().put("user", user);
		//FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		System.out.println("onReturn Clicked");
		return "TestForm.xhtml?faces-redirect=true";
	}
	
	public String onSubmitBusinessInterface() {
		
		FacesContext context = FacesContext.getCurrentInstance();
		User user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);
		
		services.test();
		
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		return "TestResponse.xhtml";
	}
	
	public OrdersBusinessInterface getService() {
		return services;
	}
}
