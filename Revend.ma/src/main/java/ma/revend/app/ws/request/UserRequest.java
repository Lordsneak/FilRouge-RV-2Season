package ma.revend.app.ws.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRequest {
	
	@NotNull
	@Size(min = 3, max = 12)
	private String firstName;
	
	@NotNull
	@Size(min = 3, max = 12)
	private String lastName;
	
	@NotNull
	@Size(min = 3, max = 30)
	private String address;
	
	@NotNull
	@Size(min = 3, max = 15)
	private String username;
	
	@NotNull
	@Email
	private String email;
	
	@NotNull
	@Size(min = 6 , max = 16)
	private String password;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
	

}
