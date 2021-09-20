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
@Entity(name = "category")
public class CategoryEntity implements Serializable{

	
	private static final long serialVersionUID = -8485888765589962777L;
	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable = false)
	private String categoryId;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String logo;
	@Column(nullable = false)
	private String description;
	
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private Set<AdvertEntity> advertEntities;
	
}
