package ch.kferati.roommanager.controllers;

import ch.kferati.roommanager.models.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@Autowired
	private SessionFactory factory;

	@GetMapping(value = "/")
	public String home() {
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

		return "index";
	}
}
