package pl.coderslab.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "games")
@DynamicUpdate
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String name;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "game_tags", joinColumns = { @JoinColumn(name = "game_id") }, inverseJoinColumns = {
			@JoinColumn(name = "tag_id") })
	private List<Tag> tags = new ArrayList<>();

	private String hardwareRequirements;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private String created;

	private int PEGI;

	private String language;

	private String description;

	private boolean multiplayer;

	private boolean couchCoop;

	private double price;
	
	private String imageUrl;
	
	private String movieUrl;

	

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getMovieUrl() {
		return movieUrl;
	}

	public void setMovieUrl(String movieUrl) {
		this.movieUrl = movieUrl;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "ugames")
	private List<User> users = new ArrayList<>();

	public int getValueOfGameAccuracy(List<Tag> userTags) {

		int result = 0;
		for (Tag tag : this.tags) {
			for (Tag userTag : userTags) {
				if (tag.getId() == userTag.getId()) {
					result++;
				}
			}
		}
		return result;
	}

	public boolean containedByList(List<Game> list) {
		for (Game game : list) {
			if (this.id == game.id) {
				return true;
			}
		}
		return false;
	}

	public Game() {
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public String getHardwareRequirements() {
		return hardwareRequirements;
	}

	public void setHardwareRequirements(String hardwareRequirements) {
		this.hardwareRequirements = hardwareRequirements;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public int getPEGI() {
		return PEGI;
	}

	public void setPEGI(int pEGI) {
		PEGI = pEGI;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isMultiplayer() {
		return multiplayer;
	}

	public void setMultiplayer(boolean multiplayer) {
		this.multiplayer = multiplayer;
	}

	public boolean isCouchCoop() {
		return couchCoop;
	}

	public void setCouchCoop(boolean couchCoop) {
		this.couchCoop = couchCoop;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", name=" + name + ", tags=" + tags + ", hardwareRequirements=" + hardwareRequirements
				+ ", created=" + created + ", PEGI=" + PEGI + ", language=" + language + ", description=" + description
				+ ", multiplayer=" + multiplayer + ", couchCoop=" + couchCoop + ", price=" + price + "]";
	}
}
