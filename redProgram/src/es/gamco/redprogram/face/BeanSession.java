//package es.gamco.redprogram.face;
//
//import java.io.Serializable;
//import java.util.Date;
//
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.ManagedProperty;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Scope;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import es.gamco.redprogram.service.TeleService;
//
//
//@Controller
////@RequestMapping(value="/app/*")
//@Scope("request")
//@ManagedBean(name="beanSession")
//public class BeanSession implements Serializable {
//	
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//	
//	private String name="Pepe";
//    private Date date;
//	
//	
//    @ManagedProperty(value="#{teleService}")
//    private TeleService teleService;
//    
//    
//    
//    
//	public BeanSession() {
//		super();
//		date=new Date();
//		// TODO Auto-generated constructor stub
//	}
//
//	public Date getDate() {
//		return date;
//	}
//
//	public void setDate(Date date) {
//		this.date = date;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//	
//	public String sayHello(String name){
//		if(teleService==null){
//			ApplicationContext contextoSpring = new ClassPathXmlApplicationContext(
//					new String[] { 
//							"applicationContext.xml"});
//			teleService=(TeleService) contextoSpring.getBean("teleService");
//		}
//		
//		return teleService.sayHello(name);
//	}
//	
//	public TeleService getTeleService() {
//		return teleService;
//	}
//
//	public void setTeleService(TeleService teleService) {
//		this.teleService = teleService;
//	}
//	
////	@ResponseBody
////	@RequestMapping(value = "/app/say")
//	public String saySome(){
//		return "Hi";
//	}
//
//}
