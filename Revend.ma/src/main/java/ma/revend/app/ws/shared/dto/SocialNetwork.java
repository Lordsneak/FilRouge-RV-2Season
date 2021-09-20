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
public class SocialNetwork implements Serializable{

	private static final long serialVersionUID = 2858723290950138365L;

	private Long id;
	private String socialNetworkId;
	private String name;
	private String logo;
	
	
	
	
}
