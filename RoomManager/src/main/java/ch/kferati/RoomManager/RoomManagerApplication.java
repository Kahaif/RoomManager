package ch.kferati.RoomManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

@SpringBootApplication
public class RoomManagerApplication implements WebApplicationInitializer {
	public static void main(String[] args) {
		SpringApplication.run(RoomManagerApplication.class, args);
	}

	@Override
	public void onStartup(ServletContext servletContext) {

		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(Configurer.class);
		context.setServletContext(servletContext);

		servletContext.addListener(new ContextLoaderListener(context));

		ServletRegistration.Dynamic appServlet = servletContext.addServlet("dispatcher", new DispatcherServlet(context));
		appServlet.setLoadOnStartup(1);
		appServlet.addMapping("/");
	}
}
