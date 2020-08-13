package ch.kferati.roommanager.controllers;

import ch.kferati.roommanager.models.*;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

	@Autowired private SessionFactory factory;


	@GetMapping(value = "/")
	public String home(Model m, HttpServletRequest request) {

		Role r = new Role();
		r.setName("abc");
		r.setPermissions("abc");

		Session s = factory.openSession();
		Transaction transaction = null;
		try {
			transaction = s.beginTransaction();
			s.save(r);
			transaction.commit();
		} catch (RuntimeException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			 s.close();
		}

		m.addAttribute("brand", "Gestion de salles")
				.addAttribute("title", "Gestion de salles")
				.addAttribute("connection", "<li class=\"nav-item\"><a class=\"nav-link\" href=\"/login\">Connexion</a></li>")
				.addAttribute("head", "<script src=\"/js/calendar.min.js\"></script><script src=\"/js/calendar-locales.min.js\"></script>");

		return "rooms";
	}
}
