package com.capgemini.fms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Entity
@Table(name = "Users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Long userid;
	@Column(name = "user_type")
	private String userType;
	@Column(name = "username")
	private String userName;
	@Column(name = "password")
	private String password;
	@Column(name = "phone_number")
	private Long phoneNumber;
	@Column(name = "email_id")
	private String email;
	
	@Override
	public String toString() {
		return "userid=" + userid + ", userName=" + userName + ", password=" + password
				+ ", phoneNumber=" + phoneNumber + ", email=" + email+", userType=" + userType+"\n";
	}
	
	public User(Long userid, String userType, String userName, String password, Long phoneNumber, String email) {
		super();
		this.userid = userid;
		this.userType = userType;
		this.userName = userName;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

}
