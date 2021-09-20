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
@Entity(name="socialnetwork")
public class SocialNetworkEntity implements Serializable{

	private static final long serialVersionUID = -4799080070436260792L;

	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable = false)
	private String socialNetworkId;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String logo;
	
	
}
