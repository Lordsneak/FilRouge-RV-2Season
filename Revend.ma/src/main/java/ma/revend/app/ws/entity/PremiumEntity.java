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
@Entity(name = "premium")
public class PremiumEntity implements Serializable{

	private static final long serialVersionUID = -4084745517395125633L;

	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable = false)
	private String premiumId;
	@Column(nullable = false)
	private String name;
	
	
	
}
