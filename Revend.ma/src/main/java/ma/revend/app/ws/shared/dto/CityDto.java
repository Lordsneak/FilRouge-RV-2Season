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
public class CityDto implements Serializable{

	private static final long serialVersionUID = 5919059288221193486L;

	private Long id;
	private String cityId;
	private String name;
	

	
	
}
