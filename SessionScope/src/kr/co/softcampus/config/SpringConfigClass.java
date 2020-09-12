package kr.co.softcampus.config;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

public class SpringConfigClass implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub
		// Spring MVC 프로젝트 설정을 위해 작성하는 클래스의 객체를 생성한다.
		AnnotationConfigWebApplicationContext servletAppContext = new AnnotationConfigWebApplicationContext();
		servletAppContext.register(ServletAppContext.class);

		// 요청 발생시 요청을 처리하는 서블릿을 DispatcherServlet 으로 설정해준다.
		DispatcherServlet dispatcherServlet = new DispatcherServlet(servletAppContext);
	    ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", dispatcherServlet);
	    servlet.setLoadOnStartup(1);
	    servlet.addMapping("/");
	    
	    //Bean 을 정의하는 클래스를 지정한다.
	    AnnotationConfigWebApplicationContext rootAppContext = new AnnotationConfigWebApplicationContext();
	    rootAppContext.register(RootAppContext.class);
	    
	    ContextLoaderListener listner = new ContextLoaderListener(rootAppContext);
	    servletContext.addListener(listner);
	    
	    //파라미터 인코딩 설정
	    FilterRegistration.Dynamic filter = servletContext.addFilter("encodinfFilter", CharacterEncodingFilter.class);
	    filter.setInitParameter("encoding", "UTF-8");
	    filter.addMappingForServletNames(null, false, "dispatcher");
	    
	    
	}
	

}
