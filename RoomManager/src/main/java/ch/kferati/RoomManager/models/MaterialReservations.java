package ch.kferati.RoomManager.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "MaterialReservations")
public class MaterialReservations {
	@Id
	private Integer id;
	private LocalDateTime from;
	private LocalDateTime to;
	private String comment;
	private Boolean validated;
	private Material material;
	private User user;
	@Column(nullable = true)
	private Room room;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		if (id == null || id < 0) throw new IllegalArgumentException("id can't be null");
		this.id = id;
	}

	public LocalDateTime getFrom() {
		return from;
	}

	public void setFrom(LocalDateTime from) {
		if (from == null || from.isBefore(LocalDateTime.now())) throw new IllegalArgumentException("from can't be null or after now");
		this.from = from;
	}

	public Boolean getValidated() {
		return validated;
	}

	public void setValidated(Boolean validated) {
		if (validated == null) throw new IllegalArgumentException("validated can't be null");
		this.validated = validated;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		if (comment == null) throw new IllegalArgumentException("updradeable can't be null");
		this.comment = comment;
	}

	public LocalDateTime getTo() {
		return to;
	}

	public void setTo(LocalDateTime to) {
		if (to == null || to.isBefore(LocalDateTime.now())) throw new IllegalArgumentException("to can't be null or after now");
		this.to = to;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		if (user == null) throw new IllegalArgumentException("user can't be null or after now");
		this.user = user;
	}
	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}
}
