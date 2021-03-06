package ch.kferati.roommanager.models;

import javax.persistence.*;

@Entity(name = "RoomType")
public class RoomType {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column(nullable = false)
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		if (id == null || id < 0) throw new IllegalArgumentException("id can't be smaller than 0");
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null || name.isEmpty()) throw new IllegalArgumentException("name can't be empty");
		this.name = name;
	}
}
