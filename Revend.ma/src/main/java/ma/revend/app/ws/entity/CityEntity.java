package ma.revend.app.ws.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "city")
public class CityEntity implements Serializable{

	private static final long serialVersionUID = -3247859090371375841L;
	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable = false)
	private String cityId;
	@Column(nullable = false)
	private String name;
	
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cityEntity")
    private Set<AdvertEntity> advertEntities;
	
	
}
