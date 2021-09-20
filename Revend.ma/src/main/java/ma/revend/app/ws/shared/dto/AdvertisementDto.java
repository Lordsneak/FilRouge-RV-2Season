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
public class AdvertisementDto implements Serializable{

	private static final long serialVersionUID = -6761878244929786869L;

	private Long id;
	private String advertisementId;
	private String name;
	private String url;
	private String image;
	
	

	
	
	
}
