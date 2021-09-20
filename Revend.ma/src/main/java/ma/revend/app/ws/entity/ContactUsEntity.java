package ma.revend.app.ws.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "contactus")
public class ContactUsEntity implements Serializable{

	private static final long serialVersionUID = 7581628346115205L;

	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable = false)
	private String contactUsId;
	@Column(nullable = false)
	private String email;
    @CreationTimestamp
    private Date createTime;
    
   
	
}
