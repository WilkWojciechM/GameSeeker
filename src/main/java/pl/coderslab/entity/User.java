package pl.coderslab.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="users")
@DynamicUpdate
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String firstName;
	@NotBlank
	private String lastName;
	
	@Column(unique = true)
	private String login;
	@NotBlank
	private String password;
	
	@Column(unique = true)
	private String email;
	@NotBlank
	private String dateOfBirth;
	

	
	private boolean admin;
	
	


	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_games",
    joinColumns = { @JoinColumn(name = "user_id") },
    inverseJoinColumns = { @JoinColumn(name = "game_id") })
	private List<Game> ugames=new ArrayList<>();
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_tags",
    joinColumns = { @JoinColumn(name = "user_id") },
    inverseJoinColumns = { @JoinColumn(name = "tag_id") })
	private List<Tag> hobbies=new ArrayList<>();
	
	
	public User() {}
	

	public boolean isAdmin() {
		return admin;
	}




	public void setAdmin(boolean admin) {
		this.admin = admin;
	}


	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getFirstName() {
		return firstName;
	}




	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}




	public String getLastName() {
		return lastName;
	}




	public void setLastName(String lastName) {
		this.lastName = lastName;
	}




	public String getLogin() {
		return login;
	}




	public void setLogin(String login) {
		this.login = login;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getDateOfBirth() {
		return dateOfBirth;
	}




	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}




	public List<Game> getUgames() {
		return ugames;
	}




	public void setUgames(List<Game> ugames) {
		this.ugames = ugames;
	}




	public List<Tag> getHobbies() {
		return hobbies;
	}




	public void setHobbies(List<Tag> hobbies) {
		this.hobbies = hobbies;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", login=" + login
				+ ", password=" + password + ", email=" + email + ", yearOfBirth=" + dateOfBirth + ", admin=" + admin
				+ ", ugames=" + ugames + ", hobbies=" + hobbies + "]";
	}

}
