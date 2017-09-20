package pl.coderslab.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "Person")
@Table(name = "persons")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String login;
	private String password;
	private String email;
	@OneToOne(mappedBy = "person",
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY)
	private PersonDetails personDetails;
	
	public Person() {};
	
	public Person(String login, String password, String email, PersonDetails personDetails) {
		this.login = login;
		this.password = password;
		this.email = email;
		this.personDetails = personDetails;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public PersonDetails getPersonDetails() {
		return personDetails;
	}
	public void setPersonDetails(PersonDetails personDetails) {
		this.personDetails = personDetails;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", login=" + login + ", password=" + password + ", email=" + email
				+ ", personDetails=" + personDetails + "]";
	}
	
}
