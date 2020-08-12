package ch.kferati.roommanager.models;

import javax.persistence.*;

@Entity(name = "Room")
public class Room {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String name;
	private Boolean upgradeable;

	@ManyToOne(optional = false, targetEntity = RoomType.class)
	public RoomType roomType;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		if (id == null || id < 0) throw new IllegalArgumentException("id can't be smaller than 0");
		this.id = id;
	}

	public void setName(String name) {
		if (name == null || name.isEmpty()) throw new IllegalArgumentException("name can't be empty");
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Boolean getUpgradeable() {
		return upgradeable;
	}

	public void setUpgradeable(Boolean upgradeable) {
		if (upgradeable == null) throw new IllegalArgumentException("updradeable can't be null");
		this.upgradeable = upgradeable;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		if (roomType == null)  throw new IllegalArgumentException("roomType can't be null");
		this.roomType = roomType;
	}
}
