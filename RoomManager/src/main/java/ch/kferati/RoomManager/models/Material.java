package ch.kferati.RoomManager.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Material")
public class Material {
	@Id
	private Integer id;
	private String name;
	private String serial;
	private Boolean reservable;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		if (id == null || id < 0) throw new IllegalArgumentException("id can't be null or smaller than 0");
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null || name.isEmpty()) throw new IllegalArgumentException("name can't be null or empty");
		this.name = name;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		if (serial == null || serial.isEmpty()) throw new IllegalArgumentException("string can't be null or empty");
		this.serial = serial;
	}

	public Boolean getReservable() {
		return reservable;
	}

	public void setReservable(Boolean reservable) {
		if (reservable == null ) throw new IllegalArgumentException("reservable can't be null or empty");
		this.reservable = reservable;
	}
}
