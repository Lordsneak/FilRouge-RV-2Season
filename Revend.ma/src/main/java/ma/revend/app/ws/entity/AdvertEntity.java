package ma.revend.app.ws.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Advert")
public class AdvertEntity implements Serializable{

	private static final long serialVersionUID = 1365386544290809105L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private String advertId;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private String description;
	
	@Column(nullable = false)
	private String price;
	
	@Column(nullable = false)
	private String image;
	
	@ManyToOne
    @JoinColumn(name = "cityId")
    private CityEntity cityEntity;

	// UserID
	
	@ManyToOne
    @JoinColumn(name = "userId")
    private AppUser userEntity;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private CategoryEntity category;
    
    
	@CreationTimestamp
    private Date createTime;
	@UpdateTimestamp
	private Date updateTime;
	
	 
}
