package ma.revend.app.ws.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "advertisement")
public class AdvertisementEntity implements Serializable{

	private static final long serialVersionUID = 2915231308132468246L;

	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable = false)
	private String advertisementId;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String url;
	//@Column(nullable = false)
	//private String image; table ImageAd
	
	
	
	
	
	
	
}
