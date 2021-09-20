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
@Entity(name = "country")
public class CountryEntity implements Serializable{

	private static final long serialVersionUID = 8495189657983908847L;

	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable = false)
	private String countryId;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String logo;
	
	
	
}
