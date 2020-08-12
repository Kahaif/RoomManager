package ch.kferati.roommanager.models;

import javax.persistence.*;

@Entity(name = "User")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String mail;
	private String password;
	@ManyToOne(targetEntity = Role.class)
	private Role role;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		if (id == null || id < 0) throw new IllegalArgumentException("id can't be null or empty");
		this.id = id;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		if (mail == null || mail.isEmpty()) throw new IllegalArgumentException("mail can't be null or empty");
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if (password == null || password.isEmpty()) throw new IllegalArgumentException("password can't be null or empty");
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		if (role == null) throw new IllegalArgumentException("role can't be null");
		this.role = role;
	}
}
