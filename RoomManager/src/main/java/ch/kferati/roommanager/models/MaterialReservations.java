package ch.kferati.roommanager.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "MaterialReservations")
public class MaterialReservations {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column(nullable = false)
	private LocalDateTime fromDateTime;
	@Column(nullable = false)
	private LocalDateTime toDateTime;
	@Column(nullable = false)
	private String comment;
	@Column(columnDefinition = "boolean default false", nullable = false)
	private Boolean validated;
	@ManyToOne(targetEntity = Material.class, optional = false)
	private Material material;
	@ManyToOne(targetEntity = User.class, optional = false)
	private User user;
	@ManyToOne(targetEntity = Room.class)
	private Room room;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		if (id == null || id < 0) throw new IllegalArgumentException("id can't be null");
		this.id = id;
	}

	public LocalDateTime getFromDateTime() {
		return fromDateTime;
	}

	public void setFromDateTime(LocalDateTime fromDateTime) {
		if (fromDateTime == null || fromDateTime.isBefore(LocalDateTime.now())) throw new IllegalArgumentException("fromDateTime can't be null or after now");
		this.fromDateTime = fromDateTime;
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

	public LocalDateTime getToDateTime() {
		return toDateTime;
	}

	public void setToDateTime(LocalDateTime toDateTime) {
		if (toDateTime == null || toDateTime.isBefore(LocalDateTime.now())) throw new IllegalArgumentException("toDateTime can't be null or after now");
		this.toDateTime = toDateTime;
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
