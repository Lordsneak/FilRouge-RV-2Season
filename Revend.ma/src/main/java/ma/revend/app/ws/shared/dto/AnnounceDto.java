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
public class AnnounceDto implements Serializable{

	private static final long serialVersionUID = 8096505077809065930L;
	
	private Long id;
	private String announceId;
	private String titre;
	private String description;
	private String image;
	private int price;
	
	// Foriegn key 
	//private String categoryId;

}
