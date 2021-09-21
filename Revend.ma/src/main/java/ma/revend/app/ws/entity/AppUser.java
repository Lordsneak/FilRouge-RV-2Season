package ma.revend.app.ws.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;

import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Set;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
    private String userId;
    
    @Column(unique = true) // Switch = True
    private String username;
    
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    
    @Column
    private boolean actived;
	
	@Column
	private String emailVerificationToken;
	
	@Column
	private Boolean emailVerificationStatuts=false;
	
	@Email
	@Column
	private String email;
	
	@Column
	private String address;
    
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<AppRole> roles=new ArrayList<>();
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userEntity")
    private Set<AdvertEntity> advertEntities;
    
    @Column
    private String firstName;
    
    @Column
    private String lastName;

    
    @Column
    private String type;
    

	@Column
	private Boolean userValid = false;

	
	@CreationTimestamp
    private Date createTime;
    
    
    
}
