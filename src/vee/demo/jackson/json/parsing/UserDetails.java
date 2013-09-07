package vee.demo.jackson.json.parsing;

import java.util.List;


public class UserDetails {

	private String			city;
	private String			first_name;
	private String			last_name;
	private List<User_user>	user_user;

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getFirst_name() {
		return this.first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return this.last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public List<User_user> getUser_user() {
		return this.user_user;
	}

	public void setUser_user(List<User_user> user_user) {
		this.user_user = user_user;
	}

}