package ch.kferati.roommanager.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Role")
public class Role {
	@Id
	private Integer id;
	private String name;
	private String permissions;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		if (id == null || id < 0) throw new IllegalArgumentException("id can't be null or empty");
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null || name.isEmpty()) throw new IllegalArgumentException("name can't be null or empty");
		this.name = name;
	}

	public String getPermissions() {
		return permissions;
	}

	public void setPermissions(String permissions) {
		if (permissions == null || permissions.isEmpty()) throw new IllegalArgumentException("permissions can't be null or empty");
		this.permissions = permissions;
	}
}
