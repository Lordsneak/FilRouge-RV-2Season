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
public class PremiumDto implements Serializable{

	private static final long serialVersionUID = 270878679074995675L;
	
	private Long id;
	private String premiumId;
	private String name;
	
	
	

}
