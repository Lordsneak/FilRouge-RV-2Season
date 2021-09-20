package ma.revend.app.ws.shared.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data 
@AllArgsConstructor 
@NoArgsConstructor 
@ToString
public class UserDto implements Serializable{

	private static final long serialVersionUID = -5825556661676755685L;


	    private Long id;
	    private String userId;
	    private String username;
	    private String password;
	    private boolean actived;
	    private String roles;
	    private String firstName;
	    private String lastname;
	    private String email;
	    private String numero;
	    private String type;
	
}
