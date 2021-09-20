package ma.revend.app.ws.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data 
@AllArgsConstructor 
@NoArgsConstructor 
@ToString
public class CategoryRequest {
	
	private String name;
	private String logo;
	private String description;

}
