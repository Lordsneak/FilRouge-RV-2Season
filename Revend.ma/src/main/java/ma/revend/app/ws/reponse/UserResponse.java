package ma.revend.app.ws.reponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data 
@AllArgsConstructor 
@NoArgsConstructor 
@ToString
public class UserResponse {
	
	private String userId;
	private String username;
	private String email;
	private String address;
	private String firstName;
	private String lastName;
	
	
	
	
}
