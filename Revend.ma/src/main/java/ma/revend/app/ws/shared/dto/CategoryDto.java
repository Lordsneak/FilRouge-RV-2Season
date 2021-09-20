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
public class CategoryDto implements Serializable{

	private static final long serialVersionUID = -5111314995353994700L;

	private Long id;
	private String categoryId;
	private String name;
	private String logo;
	private String description;
	
}
