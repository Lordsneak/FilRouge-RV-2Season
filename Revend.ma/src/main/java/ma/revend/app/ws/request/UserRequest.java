package ma.revend.app.ws.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data 
@AllArgsConstructor 
@NoArgsConstructor 
@ToString
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


}
