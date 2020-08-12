package ch.kferati.roommanager.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Property")
public class Property {
	@Id
	@Column(unique = true)
	private String name;
	private String value;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null || name.isEmpty()) throw new IllegalArgumentException("name can't be null or empty");
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		if (value == null || value.isEmpty()) throw new IllegalArgumentException("value can't be null or empty");
		this.value = value;
	}
}
