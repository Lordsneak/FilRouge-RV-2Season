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
public class ShopDto implements Serializable{

	private static final long serialVersionUID = -6383248609648046137L;

	private Long id;
	private String shopId;
	private String name;

	
	
	
}
