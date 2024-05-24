package practise_crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name", nullable = false)
	private String lastName;

	@Column(name = "date_of_birth", nullable = false)
	private String dateOfBirth;

	@Column(name = "mobile", nullable = false, unique = true)
	private String mobile;

	@Column(name = "address1", nullable = false)
	private String address1;

	@Column(name = "address2")
	private String address2;

	@Column(name = "age")
	private Integer age; // Typically, age is a derived attribute and not stored in the database

	@Column(name = "gender", nullable = false)
	private String gender;

	@Column(name = "email", nullable = false, unique = true)
	private String email;

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth
				+ ", mobile=" + mobile + ", address1=" + address1 + ", address2=" + address2 + ", age=" + age
				+ ", gender=" + gender + ", email=" + email + "]";
	}

}