package ma.revend.app.ws.reponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data 
@AllArgsConstructor 
@NoArgsConstructor 
@ToString
public class AdvertReponse {
	
	private String advertId;
	private String title;
	private String description;
	private String price;
	private String image;
	
	private Long cityId;
	private Long userId;
	private Long categoryId;

}
